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


    public void before(JoinPoint point) {

        Class<?> aClass = point.getTarget().getClass();
        String whichDataSource = aClass.getName().substring(25, aClass.getName().lastIndexOf("."));
        if ("ssmone".equals(whichDataSource)) {
            DataSourceHolder.setDataSources(Constants.DATASOURCE_ONE);
        } else {
            DataSourceHolder.setDataSources(Constants.DATASOURCE_TWO);
        }

    }


    public void after() {
        DataSourceHolder.setDataSources(null);
    }

}
