package com.crossoverJie.seconds.kill.api;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 15/04/2018 23:50
 * @since JDK 1.8
 */
public interface StockService {

    /**
     * 获取当前库存
     * @return
     * @throws Exception
     */
    Integer getCurrentCount() throws Exception;
}
