package com.crossoverJie.dao;

import com.crossoverJie.pojo.PriceVersion;
import com.crossoverJie.pojo.PriceVersionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PriceVersionMapper {
    int countByExample(PriceVersionExample example);

    int deleteByExample(PriceVersionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PriceVersion record);

    int insertSelective(PriceVersion record);

    List<PriceVersion> selectByExample(PriceVersionExample example);

    PriceVersion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PriceVersion record, @Param("example") PriceVersionExample example);

    int updateByExample(@Param("record") PriceVersion record, @Param("example") PriceVersionExample example);

    int updateByPrimaryKeySelective(PriceVersion record);

    int updateByPrimaryKey(PriceVersion record);

    int updateByVersion(PriceVersion record);


}