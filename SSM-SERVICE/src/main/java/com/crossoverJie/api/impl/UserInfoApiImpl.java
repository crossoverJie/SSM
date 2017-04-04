package com.crossoverJie.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.crossoverJie.api.UserInfoApi;
import com.crossoverJie.api.dubbo.pojo.T_user;
import com.crossoverJie.api.dubbo.service.T_userService;
import com.crossoverJie.api.dubbo.util.CommonUtil;
import com.crossoverJie.dto.UserInfoRsp;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Function:
 * @author chenjiec
 * Date: 2017/4/4 下午9:51
 * @since JDK 1.7
 */
@Service
public class UserInfoApiImpl implements UserInfoApi {
    @Autowired
    private T_userService t_userService ;

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public UserInfoRsp getUserInfo(int userId) throws Exception {

        //返回对象
        UserInfoRsp userInfoRsp = new UserInfoRsp() ;
        T_user t_user = t_userService.selectByPrimaryKey(userId) ;

        //构建
        buildUserInfoRsp(userInfoRsp,t_user) ;

        return userInfoRsp;
    }


    /**
     * 构建返回
     * @param userInfoRsp
     * @param t_user
     */
    private void buildUserInfoRsp(UserInfoRsp userInfoRsp, T_user t_user) {
        CommonUtil.setLogValueModelToModel(t_user,userInfoRsp);
    }
}
