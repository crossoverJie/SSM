package com.crossoverjie.kafka.orderconsumer.mapper;

import com.crossoverjie.kafka.orderconsumer.pojo.Stock;
import com.crossoverjie.kafka.orderconsumer.pojo.StockExample;
import com.crossoverjie.kafka.orderconsumer.util.IOPMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockMapper extends IOPMapper<Stock> {
    int countByExample(StockExample example);

    int deleteByExample(StockExample example);

    List<Stock> selectByExample(StockExample example);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByOptimistic(Stock record) ;
}