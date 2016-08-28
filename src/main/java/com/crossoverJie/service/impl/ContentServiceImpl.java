package com.crossoverJie.service.impl;

import com.crossoverJie.dao.ContentDao;
import com.crossoverJie.dao.T_userDao;
import com.crossoverJie.pojo.Content;
import com.crossoverJie.pojo.T_user;
import com.crossoverJie.service.ContentService;
import com.crossoverJie.service.T_userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

    @Resource
    public ContentDao contentDao ;

    @Override
    public List<Content> findContentList() {
        return contentDao.findContentList();
    }

    @Override
    public int insertSelective(Content content) {
        return contentDao.insertSelective(content);
    }
}
