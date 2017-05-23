/**
 * Project Name:zbj-real-name-mobile-web
 * File Name:ErrorController.java
 * Package com.zhubajie.real.name.mobile.controller
 * Date:2015-10-17下午4:27:20
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.crossoverJie.controller;

import com.crossoverJie.enums.StatusEnum;
import com.crossoverJie.res.BaseResponse;
import com.crossoverJie.vo.NULLBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

/**
 *
 * ClassName: ErrorController <br/>
 * Function: 错误异常统一处理. <br/>
 * @author crossoverJie
 * @version
 * @since JDK 1.7
 */
@ControllerAdvice
public class ErrorController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object processUnauthenticatedException(NativeWebRequest request, Exception e) {
        logger.error("请求出现异常:", e);

        BaseResponse<NULLBody> response = new BaseResponse<NULLBody>();
        response.setCode(StatusEnum.FAIL.getCode());
        if (e instanceof RuntimeException){
            response.setMessage(e.getMessage());

        } else {
            response.setMessage(StatusEnum.FAIL.getMessage());
        }
        return response ;
    }
}
