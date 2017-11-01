package com.crossoverJie.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.crossoverJie.api.DemoApi;

/**
 * Function:
 * @author chenjiec
 * Date: 2017/3/1 下午11:42
 * @since JDK 1.7
 */
@Service
public class DemoApiImpl implements DemoApi {

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     * @throws RuntimeException
     */
    @Override
    public String readMsg(int userId) throws RuntimeException {
        return null;
    }
}
