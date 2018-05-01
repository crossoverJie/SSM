package com.crossoverJie.seconds.kill.api.impl;

import com.crossoverJie.seconds.kill.api.OrderService;
import com.crossoverJie.seconds.kill.pojo.Stock;

import javax.annotation.Resource;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 01/05/2018 14:01
 * @since JDK 1.8
 */
public class OrderServiceImpl implements OrderService {

    @Resource(name = "DBOrderService")
    private com.crossoverJie.seconds.kill.service.OrderService orderService ;

    @Override
    public int createWrongOrder(int sid) {
        return orderService.createWrongOrder(sid);
    }
}
