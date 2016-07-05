package com.crossoverJie.service;

import com.crossoverJie.pojo.User;
import com.crossoverJie.util.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public interface IUserService {

    public User getUserById(int userId);
    public int createUser(User user) ;
    public User findByLogin(User user) ;
    public Page<User> findByParams(User u, int pageNo, int limit) ;
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(User record);
    int findAllCount(User u) ;
    List<User> findHotUser() ;

    List<User> findAllByQuery(User user) ;
}
