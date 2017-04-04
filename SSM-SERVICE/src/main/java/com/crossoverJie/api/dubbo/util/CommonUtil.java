package com.crossoverJie.api.dubbo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/30.
 */
public class CommonUtil {

    public static JSONObject parseJson(String code, String msg, Object data){
        JSONObject jo = new JSONObject();
        //返回码，1表示成功，2表示失败
        jo.put("result", code);
        //中文提示
        jo.put("msg", msg);
        //返回数据
        jo.put("data", data);
        return jo;
    }


    public static void responseBuildJson(HttpServletResponse response, Object jo){
        String json = "";
        if(jo instanceof JSONObject){
            json = JSONUtils.valueToString(jo);
        }else{
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                json = objectMapper.writeValueAsString(jo);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //response.setContentType("text/plain");
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer;
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成日志实体工具
     *
     * @param objectFrom
     * @param objectTo
     */
    public static void setLogValueModelToModel(Object objectFrom, Object objectTo) {
        Class<? extends Object> clazzFrom = objectFrom.getClass();
        Class<? extends Object> clazzTo = objectTo.getClass();

        for (Method toSetMethod : clazzTo.getMethods()) {
            String mName = toSetMethod.getName();
            if (mName.startsWith("set")) {
                //字段名
                String field = mName.substring(3);

                //获取from 值
                Object value;
                try {
                    if ("LogId".equals(field)) {
                        continue;
                    }
                    Method fromGetMethod = clazzFrom.getMethod("get" + field);
                    value = fromGetMethod.invoke(objectFrom);

                    //设置值
                    toSetMethod.invoke(objectTo, value);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
