package com.crossoverJie.kafka.optimization;



import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2017/10/24 17:40
 * @since JDK 1.8
 */
public class ConsumerCallable implements Callable<ConsumerFuture> {
    private static Logger LOGGER = LoggerFactory.getLogger(ConsumerCallable.class);

    private AtomicInteger totalCount = new AtomicInteger() ;
    private AtomicLong totalTime = new AtomicLong() ;

    private AtomicInteger count = new AtomicInteger() ;

    /**
     * 每个线程维护KafkaConsumer实例
     */
    private final KafkaConsumer<String, String> consumer;

    public ConsumerCallable(String brokerList, String groupId, String topic) {
        Properties props = new Properties();
        props.put("bootstrap.servers", brokerList);
        props.put("group.id", groupId);
        //自动提交位移
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));
    }


    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public ConsumerFuture call() throws Exception {
        boolean flag = true;
        int failPollTimes = 0 ;
        long startTime = System.currentTimeMillis() ;
        while (flag) {
            // 使用200ms作为获取超时时间
            ConsumerRecords<String, String> records = consumer.poll(200);
            if (records.count() <= 0){
                failPollTimes ++ ;

                if (failPollTimes >= 20){
                    LOGGER.debug("达到{}次数，退出 ",failPollTimes);
                    flag = false ;
                }

                continue ;
            }

            //获取到之后则清零
            failPollTimes = 0 ;

            LOGGER.debug("本次获取:"+records.count());
            count.addAndGet(records.count()) ;
            totalCount.addAndGet(count.get()) ;
            long endTime = System.currentTimeMillis() ;
            if (count.get() >= 10000 ){
                LOGGER.info("this consumer {} record，use {} milliseconds",count,endTime-startTime);
                totalTime.addAndGet(endTime-startTime) ;
                startTime = System.currentTimeMillis() ;
                count = new AtomicInteger();
            }
            LOGGER.debug("end totalCount={},min={}",totalCount,totalTime);

            /*for (ConsumerRecord<String, String> record : records) {
                // 简单地打印消息
                LOGGER.debug(record.value() + " consumed " + record.partition() +
                        " message with offset: " + record.offset());
            }*/
        }

        ConsumerFuture consumerFuture = new ConsumerFuture(totalCount.get(),totalTime.get()) ;
        return consumerFuture ;

    }
}
