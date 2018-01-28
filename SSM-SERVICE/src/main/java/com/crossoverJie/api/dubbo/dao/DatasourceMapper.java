package com.crossoverJie.api.dubbo.dao;

import com.crossoverJie.api.dubbo.pojo.Datasource;
import com.crossoverJie.api.dubbo.pojo.DatasourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenjie
 */
public interface DatasourceMapper {

    /**
     * 根据条件统计数量
     * @param example
     * @return
     */
    int countByExample(DatasourceExample example);

    /**
     * 根据条件删除
     * @param example
     * @return
     */
    int deleteByExample(DatasourceExample example);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(Datasource record);

    /**
     * 根据条件新增
     * @param record
     * @return
     */
    int insertSelective(Datasource record);

    /**
     * 根据条件查询
     * @param example
     * @return
     */
    List<Datasource> selectByExample(DatasourceExample example);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Datasource selectByPrimaryKey(Integer id);

    /**
     * 根据条件更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Datasource record, @Param("example") DatasourceExample example);

    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Datasource record, @Param("example") DatasourceExample example);

    /**
     * 根据主键更新指定字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Datasource record);

    /**
     * 根据主键更新所有字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(Datasource record);
}