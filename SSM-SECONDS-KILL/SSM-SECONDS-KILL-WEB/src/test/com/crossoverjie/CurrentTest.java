package com.crossoverjie;

import com.crossoverJie.seconds.kill.controller.IndexController;
import com.crossoverJie.seconds.kill.util.HttpTools;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.*;


public class CurrentTest {

    private static Logger logger = LoggerFactory.getLogger(CurrentTest.class);
    private static ExecutorService executorServicePool;
    private static String url="http://127.0.0.1:8083/SSM-SECONDS-KILL-WEB-2.2.0-SNAPSHOT/createOptimisticLimitOrder/1" ;


    public static void main(String[] args) throws InterruptedException {
        init();
        //单机极限并发450 配置 Tomcat 最大线程 250 acceptCount="200"
        try {
            for (int i = 0; i < 100; i++) {

                executorServicePool.execute(new Worker(i));
            }
        }catch (RejectedExecutionException e){
            logger.error("RejectedExecutionException",e);
        }

        executorServicePool.shutdown() ;
        while (!executorServicePool.awaitTermination(1,TimeUnit.SECONDS)){
            logger.info("worker running");
        }
        logger.info("worker over");
    }

    public static void init() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("current-thread-%d").build();
        executorServicePool = new ThreadPoolExecutor(100, 100
                , 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(200), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    }




    private static class Worker implements Runnable{

        private int index ;

        public Worker(int index) {
            this.index = index;
        }

        @Override
        public void run() {

            String res = HttpTools.doGet(url, HttpClients.createDefault()) ;
            logger.info("=======index={}====res={}====",index,res);
        }
    }


}
