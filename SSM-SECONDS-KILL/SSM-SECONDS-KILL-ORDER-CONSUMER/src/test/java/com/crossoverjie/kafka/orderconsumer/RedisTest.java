package com.crossoverjie.kafka.orderconsumer;

import com.crossoverjie.kafka.orderconsumer.constant.RedisKeysConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 07/05/2018 15:49
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


    @Autowired
    private RedisTemplate<String,String> redisTemplate ;

    @Test
    public void test(){
        String value = redisTemplate.opsForValue().get(RedisKeysConstant.STOCK_VERSION + 1);
        System.out.println(value);
    }

}
