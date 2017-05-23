package com.crossoverJie.vo;

/**
 * 空对象,用在泛型中,表示没有额外的请求参数或者返回参数
 */
public class NULLBody {

    public NULLBody() {}

    public static NULLBody create(){
        return new NULLBody();
    }
}
