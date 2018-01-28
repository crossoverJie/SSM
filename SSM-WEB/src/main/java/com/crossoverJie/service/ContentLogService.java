package com.crossoverJie.service;


import com.crossoverJie.pojo.ContentLog;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2017/1/16 上午12:16
 * @since JDK 1.7
 */
public interface ContentLogService {

    /**
     * 根据条件新增
     * @param record
     * @return
     */
    int insertSelective(ContentLog record);
}
