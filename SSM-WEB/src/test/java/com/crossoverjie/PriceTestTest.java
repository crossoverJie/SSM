package com.crossoverjie;

import com.alibaba.fastjson.JSON;
import com.crossoverJie.dao.PriceMapper;
import com.crossoverJie.pojo.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2017/1/2 下午7:51
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class PriceTestTest {

    @Autowired
    private PriceMapper priceMapper ;

    @Test
    public void selectByPrimaryKey() throws Exception {
        Price price = priceMapper.selectByPrimaryKey(1);
        System.out.println(JSON.toJSONString(price));
    }

    /**
     * 单线程消费
     */
    @Test
    public void singleCounsumerTest1(){

        for (int i=0 ;i<100 ;i++){
            Price price = priceMapper.selectByPrimaryKey(1);
            int ron = 10 ;
            price.setFront(price.getFront().subtract(new BigDecimal(ron)));
            price.setEnd(price.getEnd().add(new BigDecimal(ron)));
            price.setTotal(price.getFront().add(price.getEnd()));

            priceMapper.updateByPrimaryKey(price) ;

            price.setId(null);
            priceMapper.insertSelective(price) ;
        }
    }
    @Test
    public void singleCounsumerTest2(){

        for (int i=0 ;i<100 ;i++){
            Price price = priceMapper.selectByPrimaryKey(1);
            int ron = new Random().nextInt(20);
            price.setFront(price.getFront().subtract(new BigDecimal(ron)));
            price.setEnd(price.getEnd().add(new BigDecimal(ron)));

            priceMapper.updateByPrimaryKey(price) ;
        }
    }

    @Test
    public void mulCounsumerTest(){
        for (int i=0 ;i<5 ;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Price price = priceMapper.selectByPrimaryKey(1);
                    int ron = new Random().nextInt(20);
                    price.setFront(price.getFront().subtract(new BigDecimal(ron)));
                    price.setEnd(price.getEnd().add(new BigDecimal(ron)));
                    price.setTotal(price.getFront().add(price.getEnd()));
                    price.setId(null);
                    priceMapper.insertSelective(price) ;
                }
            }).start();

        }
    }


}