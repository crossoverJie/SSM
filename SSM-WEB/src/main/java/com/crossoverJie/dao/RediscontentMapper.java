package com.crossoverJie.dao;

import com.crossoverJie.pojo.Rediscontent;
import com.crossoverJie.pojo.RediscontentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RediscontentMapper {
    int countByExample(RediscontentExample example);

    int deleteByExample(RediscontentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rediscontent record);

    int insertSelective(Rediscontent record);

    List<Rediscontent> selectByExample(RediscontentExample example);

    Rediscontent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rediscontent record, @Param("example") RediscontentExample example);

    int updateByExample(@Param("record") Rediscontent record, @Param("example") RediscontentExample example);

    int updateByPrimaryKeySelective(Rediscontent record);

    int updateByPrimaryKey(Rediscontent record);
}