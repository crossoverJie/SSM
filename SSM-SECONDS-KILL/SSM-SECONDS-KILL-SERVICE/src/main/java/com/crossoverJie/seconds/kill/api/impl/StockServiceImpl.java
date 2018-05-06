package com.crossoverJie.seconds.kill.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.crossoverJie.seconds.kill.api.StockService;
import com.crossoverJie.seconds.kill.pojo.Stock;
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
    private RedisTemplate<String,Object> redisTemplate ;

    @Override
    public int getCurrentCount() {
        String remoteAddressString = RpcContext.getContext().getRemoteHostName();
        logger.info("request ={}",remoteAddressString);

        int count = getStockCount();

        return count;
    }

    /**
     * 再 Redis 中设置库存
     * @return
     */
    private int getStockCount() {
        int count ;
        Object oCount = redisTemplate.opsForValue().get("sid_1");
        if (oCount == null){
            Stock stock = stockService.getStockById(1);
            count = stock.getCount() ;
            redisTemplate.opsForValue().set("sid_1",count) ;
            redisTemplate.opsForValue().set("stock_1",stock) ;
        }else {
            count = (int) oCount;
        }
        return count;
    }
}
