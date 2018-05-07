package com.crossoverjie.kafka.orderconsumer;

import com.crossoverjie.kafka.orderconsumer.mapper.StockMapper;
import com.crossoverjie.kafka.orderconsumer.pojo.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderConsumerApplicationTests {


	@Autowired
	private StockMapper stockMapper ;

	@Test
	public void contextLoads() {
		Stock stock = new Stock() ;
		stock.setVersion(1);
		stock.setSale(1);
		stock.setId(1);

		int count = stockMapper.updateByOptimistic(stock);
		System.out.println(count);

		Stock stock1 = stockMapper.selectByPrimaryKey(1);
		System.out.println(stock1.getName());
	}

}
