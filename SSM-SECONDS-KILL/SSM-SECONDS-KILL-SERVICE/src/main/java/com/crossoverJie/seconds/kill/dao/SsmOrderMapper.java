package com.crossoverJie.seconds.kill.dao;

import com.crossoverJie.seconds.kill.pojo.SsmOrder;
import com.crossoverJie.seconds.kill.pojo.SsmOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmOrderMapper {
    int countByExample(SsmOrderExample example);

    int deleteByExample(SsmOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmOrder record);

    int insertSelective(SsmOrder record);

    List<SsmOrder> selectByExample(SsmOrderExample example);

    SsmOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmOrder record, @Param("example") SsmOrderExample example);

    int updateByExample(@Param("record") SsmOrder record, @Param("example") SsmOrderExample example);

    int updateByPrimaryKeySelective(SsmOrder record);

    int updateByPrimaryKey(SsmOrder record);
}