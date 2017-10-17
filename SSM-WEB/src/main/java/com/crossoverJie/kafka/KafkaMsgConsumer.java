package com.crossoverJie.kafka;

import com.alibaba.fastjson.JSON;
import com.crossoverJie.util.DateUtil;
import com.easyfun.easyframe.msg.MsgIterator;
import com.easyfun.easyframe.msg.MsgUtil;
import com.easyfun.easyframe.msg.config.EasyMsgConfig;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static com.crossoverJie.util.PreconditionUtil.checkArguments;


/**
 * kafka消费
 *
 * @author crossoverJie
 * @date 2017年6月19日 下午3:15:16
 */
public class KafkaMsgConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMsgConsumer.class);

    private static final int CORE_POOL_SIZE = 4;
    private static final int MAXIMUM_POOL_SIZE = 4;
    private static final int BLOCKING_QUEUE_CAPACITY = 4000;
    private static final String KAFKA_CONFIG = "kafkaConfig";
    private static final ExecutorService FIXED_THREAD_POOL = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(BLOCKING_QUEUE_CAPACITY));

    /**
     * 最后更新时间
     */
    private static AtomicLong LAST_MESSAGE_TIME = new AtomicLong(DateUtil.getLongTime());

    private static MsgIterator iterator = null;

    /**
     * 主题名称
     */
    private static String topic;

    /**
     * 检测时间
     */
    private final static int CHECK_MIN = 10 ;


    static {
        Properties properties = new Properties();
        String path = System.getProperty(KAFKA_CONFIG);
        checkArguments(!StringUtils.isBlank(path), "启动参数中没有配置kafka_easyframe_msg参数来指定kafka启动参数，请使用-DkafkaConfig=/path/fileName/easyframe-msg.properties");
        try {
            properties.load(new FileInputStream(new File(path)));
        } catch (IOException e) {
            LOGGER.error("IOException" ,e);
        }
        EasyMsgConfig.setProperties(properties);

    }

    private static void iteratorTopic() {
        if (iterator == null) {
            iterator = MsgUtil.consume(topic);
        }
        long i = 0L;
        while (iterator.hasNext()) {
            i++;
            if (i % 10000 == 0) {
                LOGGER.info("consume i:" + i);
            }
            try {
                String message = iterator.next();
                if (StringUtils.isEmpty(message)) {
                    continue;
                }
                LAST_MESSAGE_TIME = new AtomicLong(DateUtil.getLongTime());

                //处理消息
                LOGGER.debug("msg = " + JSON.toJSONString(message));
            } catch (Exception e) {
                LOGGER.error("KafkaMsgConsumer err:", e);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    LOGGER.error("Thread InterruptedException", e1);
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        topic = System.getProperty("topic");
        checkArguments(!StringUtils.isBlank(topic), "system property topic or log_path is necessary!");
        while (true) {
            try {
                iteratorTopic();
            } catch (Exception e) {
                MsgUtil.shutdownConsummer();
                iterator = null;

                LOGGER.error("KafkaMsgConsumer err:", e);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    LOGGER.error("Thread InterruptedException", e1);
                }
            } finally {
                //此处关闭之后，由crontab每分钟检查一次，挂掉的话会重新拉起来 10分钟检测一次
                if (DateUtil.getLongTime() - LAST_MESSAGE_TIME.get() > 10 * 60) {
                    FIXED_THREAD_POOL.shutdown();
                    LOGGER.info("线程池是否关闭：" + FIXED_THREAD_POOL.isShutdown());
                    try {
                        //当前线程阻塞10ms后，去检测线程池是否终止，终止则返回true
                        while (!FIXED_THREAD_POOL.awaitTermination(CHECK_MIN, TimeUnit.MILLISECONDS)) {
                            LOGGER.info("检测线程池是否终止：" + FIXED_THREAD_POOL.isTerminated());
                        }
                    } catch (InterruptedException e) {
                        LOGGER.error("等待线程池关闭错误", e);
                    }
                    LOGGER.info("线程池是否终止：" + FIXED_THREAD_POOL.isTerminated());
                    LOGGER.info("in 10 min dont have data break");
                    break;
                }
            }
        }
        LOGGER.info("app shutdown");
        System.exit(0);
    }

}
