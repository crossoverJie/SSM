package com.crossoverJie.api.dubbo.service;


import com.crossoverJie.api.dubbo.pojo.T_user;

import java.util.Set;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 */
public interface T_userService {
    /**
     * Shiro的登录验证，通过用户名查询用户信息
     * @param username
     * @return
     */
    public T_user findUserByUsername(String username) ;

    /**
     * 根据账号查找角色名称
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) ;

    /**
     * 根据账号查找权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) ;

    public T_user selectByPrimaryKey(int userId) ;
}
