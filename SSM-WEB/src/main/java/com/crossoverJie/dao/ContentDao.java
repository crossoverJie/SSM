package com.crossoverJie.dao;

import com.crossoverJie.pojo.Content;

import java.util.List;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 * @author chenjie
 */
public interface ContentDao {

    /**
     * 返回所有内容
     * @return
     */
    List<Content> findContentList();

    /**
     * 新增
     * @param content
     * @return
     */
    int insertSelective(Content content) ;

}
