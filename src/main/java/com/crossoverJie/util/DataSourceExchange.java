package com.crossoverJie.util;

import org.aspectj.lang.JoinPoint;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2017/1/3 上午12:34
 * @since JDK 1.7
 */
public class DataSourceExchange {


    public void befor(JoinPoint joinPoint) {
        if (DataSourceHolder.getDataSources() != null) {
            return;
        }

    }


    public void after() {
        DataSourceHolder.setDataSources(null);
    }
}
