package com.crossoverjie.seconds.kill.service.impl;

import com.crossoverJie.seconds.kill.api.dto.Stock;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 07/05/2018 10:02
 * @since JDK 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mvc.xml")
public class KafkaProductTest {

    @Autowired
    private KafkaProducer<String,Stock> producer;

    @Test
    public void product(){
        Stock stock = new Stock();
        stock.setId(1);
        producer.send(new ProducerRecord<String,Stock>("ORDER-TOPIC",stock)) ;
        System.out.println("send success");
    }
}
