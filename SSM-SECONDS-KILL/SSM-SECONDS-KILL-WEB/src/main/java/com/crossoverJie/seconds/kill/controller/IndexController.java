package com.crossoverJie.seconds.kill.controller;

import com.crossoverJie.seconds.kill.api.StockService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StockService stockService ;

    @RequestMapping("/health")
    @ResponseBody
    public String health(){
        return "OK" ;
    }

    @RequestMapping("/getStockNum")
    @ResponseBody
    public String getStockNum(){
        int currentCount = stockService.getCurrentCount();
        System.out.println("currentCount=" + currentCount);
        return String.valueOf(currentCount) ;
    }
}
