package com.crossoverJie.service;

import com.crossoverJie.pojo.RedisContent;
import com.crossoverJie.pojo.RedisContentExample;
import com.crossoverJie.util.PageEntity;

import java.util.List;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2016/12/9 上午12:16
 * @since JDK 1.7
 */
public interface RediscontentService {
    List<RedisContent> selectByExample(RedisContentExample example);

    RedisContent selectByPrimaryKey(Integer id);

    PageEntity<RedisContent> selectByPage(Integer pageNum, Integer pageSize);

}
