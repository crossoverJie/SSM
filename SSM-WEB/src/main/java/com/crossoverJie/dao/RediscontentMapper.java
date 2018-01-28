package com.crossoverJie.dao;

import com.crossoverJie.pojo.Rediscontent;
import com.crossoverJie.pojo.RedisContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RediscontentMapper {
    int countByExample(RedisContentExample example);

    int deleteByExample(RedisContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rediscontent record);

    int insertSelective(Rediscontent record);

    List<Rediscontent> selectByExample(RedisContentExample example);

    Rediscontent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rediscontent record, @Param("example") RedisContentExample example);

    int updateByExample(@Param("record") Rediscontent record, @Param("example") RedisContentExample example);

    int updateByPrimaryKeySelective(Rediscontent record);

    int updateByPrimaryKey(Rediscontent record);
}