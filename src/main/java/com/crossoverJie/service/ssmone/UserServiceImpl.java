package com.crossoverJie.service.ssmone;

import com.crossoverJie.dao.IUserDao;
import com.crossoverJie.pojo.User;
import com.crossoverJie.service.IUserService;
import com.crossoverJie.util.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/22.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

    public int createUser(User user) {
        return this.userDao.insertSelective(user) ;
    }

    public User findByLogin(User user) {
        return userDao.findByLogin(user) ;
    }

    /**
     * 分页查询
     */
    public Page<User> findByParams(User u,int pageNo,int limit) {
        Page<User> page = new Page<User>();
        page.setPageNo(pageNo);
        page.setLimit(limit);

        int offset = page.getOffsets();
        RowBounds rowBound = new RowBounds(offset, limit);

        List<User> users = userDao.findByParams(u,rowBound);
        page.setRows(users);
        int total = userDao.findAllCount(u) ;
        page.setTotal(total) ;
        if(offset >= page.getTotal()){
            page.setPageNo(page.getTotalPages());
        }
        return page ;
    }

    public int deleteByPrimaryKey(Integer id) {
        return userDao.deleteByPrimaryKey(id) ;
    }

    public int updateByPrimaryKeySelective(User record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    public int findAllCount(User u) {
        // TODO Auto-generated method stub
        return userDao.findAllCount(u) ;
    }

    public List<User> findHotUser() {
        return userDao.findHotUser();
    }

    @Override
    public List<User> findAllByQuery(User user) {
        return userDao.findAllByQuery(user);
    }

    @Override
    public List<User> list(Map<String, Object> map) {
        return userDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return userDao.getTotal(map);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
