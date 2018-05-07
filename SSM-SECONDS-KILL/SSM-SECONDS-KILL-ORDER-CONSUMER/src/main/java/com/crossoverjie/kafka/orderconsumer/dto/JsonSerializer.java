package com.crossoverjie.kafka.orderconsumer.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;


public class JsonSerializer<T> implements Serializer<T> {

    public JsonSerializer() {

    }


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No-op
    }

    @Override
    public byte[] serialize(String topic, T data) {
        try {
            byte[] result = null;
            if (data != null) {

                result = JSONObject.toJSONBytes(data,
                        SerializerFeature.UseISO8601DateFormat,
                        SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteClassName);
            }
            return result;
        } catch (Exception ex) {
            throw new SerializationException("Can't serialize data [" + data + "] for topic [" + topic + "]", ex);
        }
    }

    @Override
    public void close() {
        // No-op
    }
}
