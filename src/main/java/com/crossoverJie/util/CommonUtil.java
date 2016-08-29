package com.crossoverJie.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
}
