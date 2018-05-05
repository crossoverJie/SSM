package com.crossoverJie.seconds.kill.config;

import com.crossoverjie.distributed.limit.RedisLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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


    @Value("${redis.limit}")
    private int limit;


    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public RedisLimit build() {
        JedisConnection clusterConnection = jedisConnectionFactory.getConnection();
        Jedis jedis =  clusterConnection.getNativeConnection();
        RedisLimit redisLimit = new RedisLimit.Builder<>(jedis)
                .limit(limit)
                .build();

        return redisLimit;
    }
}
