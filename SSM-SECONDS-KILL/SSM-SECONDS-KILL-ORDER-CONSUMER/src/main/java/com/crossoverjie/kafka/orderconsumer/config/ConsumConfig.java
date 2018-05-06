package com.crossoverjie.kafka.orderconsumer.config;

import com.crossoverjie.kafka.orderconsumer.kafka.ConsumerGroup;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 15/01/2018 18:07
 * @since JDK 1.8
 */
@Configuration
public class ConsumConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(ConsumConfig.class);

    @Value("${consumer.broker.list}")
    private String brokerList;

    @Value("${consumer.group.id}")
    private String groupId;

    @Value("${consumer.topic}")
    private String topic;

    @Value("${consumer.thread}")
    private int threadNum;



    @Bean(value = "consumerGroup")
    public ConsumerGroup createConsumerGroup() {
        ConsumerGroup consumerGroup = new ConsumerGroup(threadNum, groupId, topic, brokerList);
        LOGGER.info("ConsumerGroup 初始化成功");
        return consumerGroup;
    }

}
