package com.crossoverJie.service.impl;

import com.crossoverJie.dao.RediscontentMapper;
import com.crossoverJie.pojo.Rediscontent;
import com.crossoverJie.pojo.RediscontentExample;
import com.crossoverJie.service.RediscontentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2016/12/9 上午12:17
 * @since JDK 1.7
 */
@Service
public class RediscontentServiceImpl implements RediscontentService {

    @Autowired
    private RediscontentMapper rediscontentMapper;


    @Override
    public List<Rediscontent> selectByExample(RediscontentExample example) {
        return rediscontentMapper.selectByExample(example);
    }

    @Override
    public Rediscontent selectByPrimaryKey(Integer id) {
        return rediscontentMapper.selectByPrimaryKey(id);
    }
}
