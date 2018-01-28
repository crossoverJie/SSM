package com.crossoverJie.api.dubbo.util;

/**
 * Function:动态数据源
 *
 * @author chenjiec
 *         Date: 2017/1/2 上午12:19
 * @since JDK 1.7
 */
public class DataSourceHolder {
    private static final ThreadLocal<String> DATA_SOURCES = new ThreadLocal<String>();

    public static void setDataSources(String dataSource) {
        DATA_SOURCES.set(dataSource);
    }

    public static String getDataSources() {
        return DATA_SOURCES.get();
    }
}
