package com.crossoverJie.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created with IDEA
 * 基于Shiro的MD5加密
 * Created by ${jie.chen} on 2016/7/13.
 */
public class MD5Util {

    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString() ;
    }

    public static void main(String[] args) {
        String md5 = md5("abc123","crossoverjie") ;
        System.out.println(md5);
    }
}
