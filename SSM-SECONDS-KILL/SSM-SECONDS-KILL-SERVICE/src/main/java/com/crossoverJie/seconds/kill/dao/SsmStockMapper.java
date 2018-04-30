package com.crossoverJie.seconds.kill.dao;

import com.crossoverJie.seconds.kill.pojo.SsmStock;
import com.crossoverJie.seconds.kill.pojo.SsmStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmStockMapper {
    int countByExample(SsmStockExample example);

    int deleteByExample(SsmStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmStock record);

    int insertSelective(SsmStock record);

    List<SsmStock> selectByExample(SsmStockExample example);

    SsmStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmStock record, @Param("example") SsmStockExample example);

    int updateByExample(@Param("record") SsmStock record, @Param("example") SsmStockExample example);

    int updateByPrimaryKeySelective(SsmStock record);

    int updateByPrimaryKey(SsmStock record);
}