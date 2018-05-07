package com.crossoverjie.kafka.orderconsumer;

import com.alibaba.fastjson.JSON;
import com.crossoverjie.kafka.orderconsumer.kafka.ConsumerTask;
import com.crossoverjie.kafka.orderconsumer.pojo.Stock;
import com.google.gson.Gson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 07/05/2018 14:02
 * @since JDK 1.8
 */
public class JsonTest {

    private static Logger LOGGER = LoggerFactory.getLogger(ConsumerTask.class);

    @Test
    public void test(){
        String json = "{\"@type\":\"com.crossoverJie.seconds.kill.pojo.Stock\",\"count\":10,\"id\":1,\"name\":null,\"sale\":2,\"version\":2}" ;
        Gson gson = new Gson() ;
        Stock stock = gson.fromJson(json, Stock.class);
        LOGGER.info("consumer stock={}",JSON.toJSONString(stock));
    }
}
