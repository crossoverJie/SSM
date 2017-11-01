package com.crossoverJie.kafka.optimization;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2017/10/24 17:52
 * @since JDK 1.8
 */
public class ConsumerThreadMain {
    private static String brokerList = "localhost:9094";
    private static String groupId = "group1";
    private static String topic = "test";

    /**
     * 线程数量
     */
    private static int threadNum = 3;

    public static void main(String[] args) {


        ConsumerGroup consumerGroup = new ConsumerGroup(threadNum, groupId, topic, brokerList);
        consumerGroup.execute();
    }
}
