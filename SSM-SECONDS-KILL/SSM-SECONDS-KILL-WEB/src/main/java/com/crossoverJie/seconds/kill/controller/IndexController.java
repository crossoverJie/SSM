package com.crossoverJie.seconds.kill.controller;

import com.crossoverJie.seconds.kill.api.OrderService;
import com.crossoverJie.seconds.kill.api.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private StockService stockService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/health")
    @ResponseBody
    public String health() {
        logger.info("heath");
        return "OK";
    }

    @RequestMapping("/getStockNum")
    @ResponseBody
    public String getStockNum() {
        int currentCount = 0;
        try {
            currentCount = stockService.getCurrentCount();
        } catch (Exception e) {
            logger.error("Exception",e);
        }
        logger.info("currentCount={}", currentCount);
        return String.valueOf(currentCount);
    }


    @RequestMapping("/createWrongOrder/{sid}")
    @ResponseBody
    public String createWrongOrder(@PathVariable int sid) {
        logger.info("sid=[{}]", sid);
        int id = 0;
        try {
            id = orderService.createWrongOrder(sid);
        } catch (Exception e) {
            logger.error("Exception",e);
        }
        return String.valueOf(id);
    }


}
