package com.crossoverjie;

import com.crossoverJie.pojo.Content;
import com.crossoverJie.service.ContentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class RedisTest {

    @Autowired
    private ContentService contentService;

    @Test
    public void test() {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置空间连接

        config.setMaxIdle(20);
        config.setMaxWaitMillis(1000);


        JedisPool pool = new JedisPool(config, "27.126.180.210", 6379);
        System.out.println(pool.getResource());
        Jedis jedis = pool.getResource();
        jedis.set("name", "陈杰");
        System.out.println(jedis.get("name"));

    }

    @Test
    public void testCache() {
        List<Content> contentList = contentService.findContentList();
        List<Content> contentList1 = contentService.findContentList();
        System.out.println(contentList == contentList1);

        System.out.println(contentList.get(0).getContent() + "-----------");

    }
}
