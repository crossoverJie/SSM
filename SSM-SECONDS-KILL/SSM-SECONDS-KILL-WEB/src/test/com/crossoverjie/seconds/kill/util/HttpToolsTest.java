package com.crossoverjie.seconds.kill.util;

import com.crossoverJie.seconds.kill.util.HttpTools;
import com.crossoverjie.CurrentTest;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class HttpToolsTest {

    private static Logger logger = LoggerFactory.getLogger(HttpToolsTest.class);

    @Test
    public void doGet() throws Exception {
        String url="http://127.0.0.1:8083/SSM-SECONDS-KILL-WEB-2.2.0-SNAPSHOT/getStockNum" ;

        String res = HttpTools.doGet(url, HttpClients.createDefault()) ;

        logger.info("res={}",res);
    }

}