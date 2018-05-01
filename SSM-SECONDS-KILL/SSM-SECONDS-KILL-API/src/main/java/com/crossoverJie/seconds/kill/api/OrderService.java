package com.crossoverJie.seconds.kill.api;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 01/05/2018 13:58
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
