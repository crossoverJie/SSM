package com.crossoverJie.controller;

import com.crossoverJie.dao.PriceMapper;
import com.crossoverJie.dao.PriceVersionMapper;
import com.crossoverJie.enums.StatusEnum;
import com.crossoverJie.pojo.Price;
import com.crossoverJie.pojo.PriceVersion;
import com.crossoverJie.req.RedisContentReq;
import com.crossoverJie.res.BaseResponse;
import com.crossoverJie.util.ThreadPoolConfig;
import com.crossoverJie.vo.NULLBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Random;


@Controller
@RequestMapping("/price")
public class PriceController {

    private static Logger logger = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceMapper priceMapper ;

    @Autowired
    private PriceVersionMapper priceVersionMapper ;


    @Autowired
    private ThreadPoolConfig config ;

    @RequestMapping(value = "/price",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<NULLBody> price(@RequestBody RedisContentReq redisContentReq){
        BaseResponse<NULLBody> response = new BaseResponse<NULLBody>() ;

        try {

            for (int i=0 ;i<50 ;i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Price price = priceMapper.selectByPrimaryKey(1);
                        int ron = 20;
                        price.setFront(price.getFront().subtract(new BigDecimal(ron)));
                        price.setEnd(price.getEnd().add(new BigDecimal(ron)));

                        priceMapper.updateByPrimaryKey(price) ;

                        price.setId(null);
                        priceMapper.insertSelective(price) ;
                    }
                }).start();

            }

            response.setReqNo(redisContentReq.getReqNo());
            response.setCode(StatusEnum.SUCCESS.getCode());
            response.setMessage(StatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.error("system error",e);
            response.setReqNo(response.getReqNo());
            response.setCode(StatusEnum.FAIL.getCode());
            response.setMessage(StatusEnum.FAIL.getMessage());
        }

        return response ;

    }

    /**
     * 线程池 无锁
     * @param redisContentReq
     * @return
     */
    @RequestMapping(value = "/threadPrice",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<NULLBody> threadPrice(@RequestBody RedisContentReq redisContentReq){
        BaseResponse<NULLBody> response = new BaseResponse<NULLBody>() ;

        try {

            for (int i=0 ;i<10 ;i++){
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Price price = priceMapper.selectByPrimaryKey(1);
                        int ron = 10 ;
                        price.setFront(price.getFront().subtract(new BigDecimal(ron)));
                        price.setEnd(price.getEnd().add(new BigDecimal(ron)));
                        priceMapper.updateByPrimaryKey(price) ;

                        price.setId(null);
                        priceMapper.insertSelective(price) ;
                    }
                });

                config.submit(t);

            }

            response.setReqNo(redisContentReq.getReqNo());
            response.setCode(StatusEnum.SUCCESS.getCode());
            response.setMessage(StatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.error("system error",e);
            response.setReqNo(response.getReqNo());
            response.setCode(StatusEnum.FAIL.getCode());
            response.setMessage(StatusEnum.FAIL.getMessage());
        }

        return response ;

    }


    /**
     * 线程池，乐观锁
     * @param redisContentReq
     * @return
     */
    @RequestMapping(value = "/threadPriceVersion",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<NULLBody> threadPriceVersion(@RequestBody RedisContentReq redisContentReq){
        BaseResponse<NULLBody> response = new BaseResponse<NULLBody>() ;

        try {

            for (int i=0 ;i<3 ;i++){
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PriceVersion priceVersion = priceVersionMapper.selectByPrimaryKey(1);
                        int ron = new Random().nextInt(20);
                        logger.info("本次消费="+ron);
                        priceVersion.setFront(new BigDecimal(ron));
                        int count = priceVersionMapper.updateByVersion(priceVersion);
                        if (count == 0){
                            logger.error("更新失败");
                        }else {
                            logger.info("更新成功");
                        }

                    }
                });

                config.submit(t);

            }

            response.setReqNo(redisContentReq.getReqNo());
            response.setCode(StatusEnum.SUCCESS.getCode());
            response.setMessage(StatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.error("system error",e);
            response.setReqNo(response.getReqNo());
            response.setCode(StatusEnum.FAIL.getCode());
            response.setMessage(StatusEnum.FAIL.getMessage());
        }

        return response ;

    }

}
