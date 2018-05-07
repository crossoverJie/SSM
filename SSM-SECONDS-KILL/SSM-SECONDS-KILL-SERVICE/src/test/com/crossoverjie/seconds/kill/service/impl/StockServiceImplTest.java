package com.crossoverjie.seconds.kill.service.impl;

import com.crossoverJie.seconds.kill.service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-*.xml")
public class StockServiceImplTest {

    @Resource(name = "DBStockService")
    private StockService stockService ;

    @Test
    public void getCurrentCount() throws Exception {
        int stockCount = stockService.getStockCount(1);
        System.out.println(stockCount);
    }

}