package com.crossoverJie.kafka.optimization;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2017/10/24 17:52
 * @since JDK 1.8
 */
public class ConsumerGroup {
    private static Logger LOGGER = LoggerFactory.getLogger(ConsumerGroup.class);
    /**
     * 线程池
     */
    private ExecutorService threadPool;

    private List<ConsumerCallable> consumers ;

    public ConsumerGroup(int threadNum, String groupId, String topic, String brokerList) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("consumer-pool-%d").build();

        threadPool = new ThreadPoolExecutor(threadNum, threadNum,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


        consumers = new ArrayList<ConsumerCallable>(threadNum);
        for (int i = 0; i < threadNum; i++) {
            ConsumerCallable consumerThread = new ConsumerCallable(brokerList, groupId, topic);
            consumers.add(consumerThread);
        }
    }

    /**
     * 执行任务
     */
    public void execute() {
        long startTime = System.currentTimeMillis() ;
        for (ConsumerCallable runnable : consumers) {
            Future<ConsumerFuture> future = threadPool.submit(runnable) ;
        }
        if (threadPool.isShutdown()){
            long endTime = System.currentTimeMillis() ;
            LOGGER.info("main thread use {} Millis" ,endTime -startTime) ;
        }
        threadPool.shutdown();
    }
}