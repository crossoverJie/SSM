package com.crossoverJie.seconds.kill.service.impl;

import com.crossoverJie.seconds.kill.dao.SsmStockMapper;
import com.crossoverJie.seconds.kill.pojo.SsmStock;
import com.crossoverJie.seconds.kill.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 30/04/2018 22:39
 * @since JDK 1.8
 */
//@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private SsmStockMapper ssmStockMapper ;

    @Override
    public int getStockCount(int id) {
        SsmStock ssmStock = ssmStockMapper.selectByPrimaryKey(id);
        return ssmStock.getCount();
    }
}
