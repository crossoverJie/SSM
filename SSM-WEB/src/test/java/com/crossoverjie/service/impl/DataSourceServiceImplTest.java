package com.crossoverjie.service.impl;

import com.alibaba.fastjson.JSON;
import com.crossoverJie.pojo.Datasource;
import com.crossoverJie.service.DataSourceService;
import com.crossoverJie.util.Constants;
import com.crossoverJie.util.DataSourceHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2017/1/2 下午8:02
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class DataSourceServiceImplTest {

    @Autowired
    private DataSourceService dataSourceService;

    @Test
    public void selectByPrimaryKey() throws Exception {
        DataSourceHolder.setDataSources(Constants.DATASOURCE_TWO);
        Datasource datasource = dataSourceService.selectByPrimaryKey(7);
        System.out.println(JSON.toJSONString(datasource));
    }


    @Test
    public void selectByPrimaryKey2() throws Exception {
        Datasource datasource = dataSourceService.selectByPrimaryKey(7);
        System.out.println(JSON.toJSONString(datasource));
    }

}