package com.crossoverJie.service;

import com.crossoverJie.pojo.Content;

import java.util.List;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 * 后台登录Service
 */
public interface ContentService {
    /**
     * 获取内容list
     * @return
     */
    List<Content> findContentList();

    /**
     * 根据条件新增
     * @param content
     * @return
     */
    int insertSelective(Content content) ;
}
