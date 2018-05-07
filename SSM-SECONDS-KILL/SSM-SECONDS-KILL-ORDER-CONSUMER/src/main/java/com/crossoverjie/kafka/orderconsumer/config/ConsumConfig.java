package com.crossoverjie.kafka.orderconsumer.config;

import com.crossoverjie.kafka.orderconsumer.kafka.ConsumerGroup;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import tk.mybatis.mapper.autoconfigure.MapperProperties;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.*;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 15/01/2018 18:07
 * @since JDK 1.8
 */
@Configuration
@EnableConfigurationProperties(MapperProperties.class)
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


    @Autowired
    private MapperProperties properties;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @Bean(value = "consumerGroup")
    public ConsumerGroup createConsumerGroup() {
        ConsumerGroup consumerGroup = new ConsumerGroup(threadNum, groupId, topic, brokerList);
        LOGGER.info("ConsumerGroup 初始化成功");
        return consumerGroup;
    }

    @Bean
    public Gson build(){
        return new Gson() ;
    }



    @PostConstruct
    public void addPageInterceptor() {
        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.setConfig(properties);
        if (properties.getMappers().size() > 0) {
            for (Class mapper : properties.getMappers()) {
                //提前初始化MapperFactoryBean,注册mappedStatements
                applicationContext.getBeansOfType(mapper);
                mapperHelper.registerMapper(mapper);
            }
        } else {
            //提前初始化MapperFactoryBean,注册mappedStatements
            applicationContext.getBeansOfType(Mapper.class);
            mapperHelper.registerMapper(Mapper.class);
        }
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            mapperHelper.processConfiguration(sqlSessionFactory.getConfiguration());
        }
    }

}
