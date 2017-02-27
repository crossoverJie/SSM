package com.crossoverjie.service.impl;

import com.alibaba.fastjson.JSON;
import com.crossoverJie.pojo.Rediscontent;
import com.crossoverJie.service.RediscontentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2017/1/2 下午7:51
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class RediscontentServiceImplTest {

    @Autowired
    private RediscontentService rediscontentService;

    @Test
    public void selectByPrimaryKey() throws Exception {
        Rediscontent rediscontent = rediscontentService.selectByPrimaryKey(30);
        System.out.println(JSON.toJSONString(rediscontent));
    }

}