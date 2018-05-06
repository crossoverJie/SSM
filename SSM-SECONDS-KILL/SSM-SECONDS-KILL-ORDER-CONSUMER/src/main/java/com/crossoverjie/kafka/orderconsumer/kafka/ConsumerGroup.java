package com.crossoverjie.kafka.orderconsumer.kafka;

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

    private List<ConsumerTask> consumers ;

    public ConsumerGroup(int threadNum, String groupId, String topic, String brokerList) {
        LOGGER.info("kafka parameter={},{},{},{}",threadNum,groupId,topic,brokerList);
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("consumer-pool-%d").build();

        threadPool = new ThreadPoolExecutor(threadNum, threadNum,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


        consumers = new ArrayList<ConsumerTask>(threadNum);
        for (int i = 0; i < threadNum; i++) {
            ConsumerTask consumerThread = new ConsumerTask(brokerList, groupId, topic);
            consumers.add(consumerThread);
        }
    }

    /**
     * 执行任务
     */
    public void execute() {
        for (ConsumerTask runnable : consumers) {
            threadPool.submit(runnable) ;
        }
    }
}