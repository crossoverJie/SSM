package com.crossoverjie.kafka.orderconsumer.kafka;


import com.alibaba.fastjson.JSONObject;
import com.crossoverjie.kafka.orderconsumer.util.SpringBeanFactory;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2017/10/24 17:40
 * @since JDK 1.8
 */
public class ConsumerTask implements Runnable {
    private static Logger LOGGER = LoggerFactory.getLogger(ConsumerTask.class);


    /**
     * 每个线程维护KafkaConsumer实例
     */
    private final KafkaConsumer<String, String> consumer;


    public ConsumerTask(String brokerList, String groupId, String topic) {

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


    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            // 使用200ms作为获取超时时间
            ConsumerRecords<String, String> records = consumer.poll(200);

            for (ConsumerRecord<String, String> record : records) {
                // 简单地打印消息
                LOGGER.debug("==="+record.value() + " consumed " + record.partition() +
                        " message with offset: " + record.offset());

                dealMessage(record.value()) ;
            }
        }


    }

    /**
     * @param value
     */
    private void dealMessage(String value) {
        try {


        }catch (RejectedExecutionException e){
            LOGGER.error("rejected message = " + value);
        }catch (Exception e){
            LOGGER.error("unknown exception",e);
        }

    }

}
