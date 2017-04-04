package com.crossoverJie.api.dubbo.dao;

import com.crossoverJie.api.dubbo.pojo.Datasource;
import com.crossoverJie.api.dubbo.pojo.DatasourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DatasourceMapper {
    int countByExample(DatasourceExample example);

    int deleteByExample(DatasourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Datasource record);

    int insertSelective(Datasource record);

    List<Datasource> selectByExample(DatasourceExample example);

    Datasource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Datasource record, @Param("example") DatasourceExample example);

    int updateByExample(@Param("record") Datasource record, @Param("example") DatasourceExample example);

    int updateByPrimaryKeySelective(Datasource record);

    int updateByPrimaryKey(Datasource record);
}