package com.crossoverJie.seconds.kill.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.crossoverJie.seconds.kill.api.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @Override
    public int getCurrentCount() {
        String remoteAddressString = RpcContext.getContext().getRemoteAddressString();
        logger.debug("request ={}",remoteAddressString);
        return 10;
    }
}
