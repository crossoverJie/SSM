package com.crossoverJie.kafka.official;

import com.crossoverJie.util.StringUtil;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Function:kafka官方消费
 *
 * @author crossoverJie
 *         Date: 2017/10/19 01:11
 * @since JDK 1.8
 */
public class KafkaOfficialConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaOfficialConsumer.class);

    /**
     * 日志文件地址
     */
    private static String logPath;

    /**
     * 主题名称
     */
    private static String topic;

    /**
     * 消费配置文件
     */
    private static String consumerProPath ;


    /**
     * 初始化参数校验
     * @return
     */
    private static boolean initCheck() {
        topic = System.getProperty("topic") ;
        logPath = System.getProperty("log_path") ;
        consumerProPath = System.getProperty("consumer_pro_path") ;
        if (StringUtil.isEmpty(topic) || logPath.isEmpty()) {
            LOGGER.error("system property topic ,consumer_pro_path, log_path is required !");
            return true;
        }
        return false;
    }

    /**
     * 初始化kafka配置
     * @return
     */
    private static KafkaConsumer<String, String> initKafkaConsumer() {
        KafkaConsumer<String, String> consumer = null;
        try {
            FileInputStream inputStream = new FileInputStream(new File(consumerProPath)) ;
            Properties properties = new Properties();
            properties.load(inputStream);
            consumer = new KafkaConsumer<String, String>(properties);
            consumer.subscribe(Arrays.asList(topic));

        } catch (IOException e) {
            LOGGER.error("加载consumer.props文件出错", e);
        }
        return consumer;
    }

    public static void main(String[] args) {
        if (initCheck()){
            return;
        }

        int totalCount = 0 ;
        long totalMin = 0L ;
        int count = 0;
        KafkaConsumer<String, String> consumer = initKafkaConsumer();

        long startTime = System.currentTimeMillis() ;
        //消费消息
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(200);
            if (records.count() <= 0){
                continue ;
            }
            LOGGER.debug("本次获取:"+records.count());
            count += records.count() ;

            long endTime = System.currentTimeMillis() ;
            LOGGER.debug("count=" +count) ;
            if (count >= 10000 ){
                totalCount += count ;
                LOGGER.info("this consumer {} record，use {} milliseconds",count,endTime-startTime);
                totalMin += (endTime-startTime) ;
                startTime = System.currentTimeMillis() ;
                count = 0 ;
            }
            LOGGER.debug("end totalCount={},min={}",totalCount,totalMin);

            /*for (ConsumerRecord<String, String> record : records) {
                record.value() ;
                JsonNode msg = null;
                try {
                    msg = mapper.readTree(record.value());
                } catch (IOException e) {
                    LOGGER.error("消费消息出错", e);
                }
                LOGGER.info("kafka receive = "+msg.toString());
            }*/


        }
    }
}
