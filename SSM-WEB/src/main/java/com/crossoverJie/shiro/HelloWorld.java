package com.crossoverJie.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/12.
 */
public class HelloWorld {

    public static void main(String args[]){
        //读取配置文件，初始化工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini") ;
        //获取SecurityManager的实例对象
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        //得到当前的用户
        Subject curentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("crossoverjie","12341") ;
        try {
            curentUser.login(token);
            System.out.println("认证成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("认证失败");
        }
        curentUser.logout();
    }
}
