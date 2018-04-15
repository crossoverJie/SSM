package com.crossoverJie.seconds.kill.service.impl;

import com.crossoverJie.seconds.kill.api.StockService;
import org.springframework.stereotype.Service;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 15/04/2018 23:50
 * @since JDK 1.8
 */
public class StockServiceImpl implements StockService {

    @Override
    public int getCurrentCount() {
        return 10;
    }
}
