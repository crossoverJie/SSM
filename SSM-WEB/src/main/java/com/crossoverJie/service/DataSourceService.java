package com.crossoverJie.service;

import com.crossoverJie.pojo.Datasource;
import com.crossoverJie.pojo.DatasourceExample;

import java.util.List;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2016/12/9 上午12:16
 * @since JDK 1.7
 */
public interface DataSourceService {

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


}
