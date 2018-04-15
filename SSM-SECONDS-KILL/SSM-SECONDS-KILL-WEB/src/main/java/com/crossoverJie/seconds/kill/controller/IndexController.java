package com.crossoverJie.seconds.kill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 15/04/2018 21:58
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping("/health")
    @ResponseBody
    public String health(){
        return "OK" ;
    }
}
