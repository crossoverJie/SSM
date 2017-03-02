package com.crossoverjie;

import com.alibaba.fastjson.JSON;
import com.crossoverJie.dao.RediscontentMapper;
import com.crossoverJie.pojo.Content;
import com.crossoverJie.pojo.Rediscontent;
import com.crossoverJie.service.ContentService;
import com.crossoverJie.service.IUserService;
import com.crossoverJie.service.RediscontentService;
import com.crossoverJie.util.PageEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;


public class CommonTest {

    @Test
    public void test() {
        String str = "com.crossoverJie.service.ssmone.RediscontentServiceImpl";
        String substring = str.substring(25, str.lastIndexOf("."));
        System.out.println(substring);
    }


}
