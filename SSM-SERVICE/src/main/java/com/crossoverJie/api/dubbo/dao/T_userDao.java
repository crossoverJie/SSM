package com.crossoverJie.api.dubbo.dao;


import com.crossoverJie.api.dubbo.pojo.T_user;

import java.util.Set;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 */
public interface T_userDao {
    T_user findUserByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    T_user selectByPrimaryKey(int userId) ;
}
