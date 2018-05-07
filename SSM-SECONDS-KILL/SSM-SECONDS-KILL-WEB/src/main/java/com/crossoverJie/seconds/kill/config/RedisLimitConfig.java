package com.crossoverJie.seconds.kill.config;

import com.crossoverJie.seconds.kill.controller.IndexController;
import com.crossoverjie.distributed.constant.RedisToolsConstant;
import com.crossoverjie.distributed.limit.RedisLimit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 05/05/2018 17:39
 * @since JDK 1.8
 */
@Configuration
public class RedisLimitConfig {

    private Logger logger = LoggerFactory.getLogger(RedisLimitConfig.class);

    @Value("${redis.limit}")
    private int limit;


    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public RedisLimit build() {
        RedisLimit redisLimit = new RedisLimit.Builder(jedisConnectionFactory, RedisToolsConstant.SINGLE)
                .limit(limit)
                .build();

        return redisLimit;
    }
}
