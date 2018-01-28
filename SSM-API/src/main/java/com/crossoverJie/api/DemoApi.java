package com.crossoverJie.api;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2017/3/1 下午11:42
 * @since JDK 1.7
 */
public interface DemoApi {
    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     * @throws RuntimeException
     */
    String readMsg(int userId) throws RuntimeException;
}
