package com.crossoverJie.seconds.kill.service;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 01/05/2018 14:09
 * @since JDK 1.8
 */
public interface OrderService {

    /**
     * 创建订单
     * @param sid
     *  库存ID
     * @return
     *  订单ID
     */
    int createWrongOrder(int sid) ;
}
