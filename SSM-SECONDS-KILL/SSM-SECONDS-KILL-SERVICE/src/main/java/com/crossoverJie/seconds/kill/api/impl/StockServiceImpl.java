package com.crossoverJie.seconds.kill.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.crossoverJie.seconds.kill.api.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 15/04/2018 23:50
 * @since JDK 1.8
 */
@Service
public class StockServiceImpl implements StockService {

    private Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    @Resource(name = "DBStockService")
    private com.crossoverJie.seconds.kill.service.StockService stockService ;

    @Autowired
    private RedisTemplate<String,Integer> redisTemplate ;

    @Override
    public int getCurrentCount() {
        String remoteAddressString = RpcContext.getContext().getRemoteHostName();
        logger.info("request ={}",remoteAddressString);

        int count = redisTemplate.opsForValue().get("sid_1") ;
        if (count == 0){
            count = stockService.getStockCount(1) ;
            redisTemplate.opsForValue().set("sid_1",count) ;
        }

        return count;
    }
}
