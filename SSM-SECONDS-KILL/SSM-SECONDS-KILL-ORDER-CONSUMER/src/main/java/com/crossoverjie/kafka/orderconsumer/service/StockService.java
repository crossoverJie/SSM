package com.crossoverjie.kafka.orderconsumer.service;


import com.crossoverjie.kafka.orderconsumer.pojo.Stock;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 30/04/2018 22:38
 * @since JDK 1.8
 */
public interface StockService {

    /**
     * 获取剩余库存
     * @param id
     * @return
     */
    int getStockCount(int id) ;

    /**
     * 根据库存 ID 查询库存信息
     * @param id
     * @return
     */
    Stock getStockById(int id) ;

    /**
     * 更新库存信息
     * @param stock
     * return
     */
    int updateStockById(Stock stock);

    /**
     * 乐观锁更新库存
     * @param stock
     * @return
     */
    int updateStockByOptimistic(Stock stock);


}
