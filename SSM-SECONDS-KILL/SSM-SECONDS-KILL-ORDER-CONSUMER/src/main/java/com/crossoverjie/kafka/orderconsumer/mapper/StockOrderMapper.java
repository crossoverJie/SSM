package com.crossoverjie.kafka.orderconsumer.mapper;

import com.crossoverjie.kafka.orderconsumer.pojo.StockOrder;
import com.crossoverjie.kafka.orderconsumer.pojo.StockOrderExample;
import com.crossoverjie.kafka.orderconsumer.util.IOPMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockOrderMapper extends IOPMapper<StockOrder> {
    int countByExample(StockOrderExample example);

    int deleteByExample(StockOrderExample example);

    List<StockOrder> selectByExample(StockOrderExample example);

    int updateByExampleSelective(@Param("record") StockOrder record, @Param("example") StockOrderExample example);

    int updateByExample(@Param("record") StockOrder record, @Param("example") StockOrderExample example);
}