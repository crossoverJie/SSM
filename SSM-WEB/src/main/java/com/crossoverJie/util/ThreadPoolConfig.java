package com.crossoverJie.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Function:线程池
 *
 * @author crossoverJie
 *         Date: 2017/7/2 21:30
 * @since JDK 1.8
 */
@Component
public class ThreadPoolConfig {

    private static final int MAX_SIZE = 10 ;
    private static final int CORE_SIZE = 5;
    private static final int SECOND = 1000;

    private ThreadPoolExecutor executor ;

    public ThreadPoolConfig(){
        executor = new ThreadPoolExecutor(CORE_SIZE,MAX_SIZE,SECOND, TimeUnit.MICROSECONDS,new LinkedBlockingQueue<Runnable>()) ;
    }

    public void submit(Thread thread){
        executor.submit(thread) ;
    }
}
