package com.crossoverJie.seconds.kill.service.impl;

import com.crossoverJie.seconds.kill.dao.OrderMapper;
import com.crossoverJie.seconds.kill.pojo.Order;
import com.crossoverJie.seconds.kill.pojo.Stock;
import com.crossoverJie.seconds.kill.service.OrderService;
import com.crossoverJie.seconds.kill.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 01/05/2018 14:10
 * @since JDK 1.8
 */
@Transactional(rollbackFor = Exception.class)
@Service(value = "DBOrderService")
public class OrderServiceImpl implements OrderService {

    @Resource(name = "DBStockService")
    private com.crossoverJie.seconds.kill.service.StockService stockService ;

    @Autowired
    private OrderMapper orderMapper ;

    @Override
    public int createWrongOrder(int sid) {

        Stock stock = stockService.getStockById(sid);
        if (stock.getSale().equals(stock.getCount())){
            throw new RuntimeException("库存不足") ;
        }

        //扣库存
        saleStock(stock);

        //创建订单
        int id  = createOrder(stock);

        return id ;
    }



    private int createOrder(Stock stock) {
        Order order = new Order() ;
        order.setSid(stock.getId());
        order.setName(stock.getName());
        order.setCreateTime(new Date());
        int id = orderMapper.insertSelective(order);
        return id ;
    }

    private void saleStock(Stock stock) {
        stock.setSale(stock.getSale() + 1) ;
        stockService.updateStockById(stock) ;
    }
}
