package com.crossoverjie;

import org.junit.Test;

import java.util.Random;


public class CommonTest {

    @Test
    public void test() {
        String str = "com.crossoverJie.service.ssmone.RediscontentServiceImpl";
        String substring = str.substring(25, str.lastIndexOf("."));
        System.out.println(substring);
    }

    @Test
    public void random(){
        Random random = new Random() ;
        int i = random.nextInt(20);
        System.out.println("================"+i);
    }


}
