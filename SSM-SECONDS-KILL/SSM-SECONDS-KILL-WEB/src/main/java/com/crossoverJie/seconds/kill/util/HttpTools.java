package com.crossoverJie.seconds.kill.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * ClassName: HttpTools <br/>
 * Function: httpClent工具类. <br/>
 *
 * @author crossoverJie
 * @since JDK 1.7
 */
public class HttpTools {
    private static Logger logger = LoggerFactory.getLogger(HttpTools.class);

    /**
     * HTTP GET下载文件
     */
    public static byte[] getFile(String url, CloseableHttpClient httpClient) {
        logger.info("url地址:"+url);
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpGet.setHeader("Accept-Encoding", "*");
        try {
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);
                logger.info("请求成功");
                // 获取返回的内容
                return getReturnContentByte(response);
            } finally {
                response.close();
                httpGet.reset();
            }
        } catch (Exception e) {
            throw new RuntimeException("HTTP通信出错", e);
        }


    }

    /**
     * HTTP GET请求
     */
    public static String doGet(String url, CloseableHttpClient httpClient) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpGet.setHeader("Accept", "*/*");

        try {
            // GET请求
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);

                // 获取返回的内容
                String backStr = getReturnContent(response);
                logger.debug(backStr);
                return backStr;
            } finally {
                response.close();
                httpGet.reset();
            }
        } catch (Exception exc) {
            throw new RuntimeException("HTTP通信出错", exc);
        }
    }


    /**
     * 获取返回信息
     *
     * @param response
     * @return
     */
    public static String parseContent(CloseableHttpResponse response) {
        String backStr;
        try {
            HttpEntity entity = response.getEntity();
            backStr = EntityUtils.toString(entity, "UTF-8");
        } catch (ParseException e) {
            throw new RuntimeException("HTTP解析返回数据异常", e);
        } catch (IOException e) {
            throw new RuntimeException("HTTP解析返回数据异常", e);
        }

        return backStr;
    }

    /**
     * 获取返回信息
     *
     * @param response
     * @return
     */
    private static String getReturnContent(CloseableHttpResponse response) {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            throw new RuntimeException("HTTP通信异常，返回状态码：" + statusCode);
        }

        String backStr;
        try {
            HttpEntity entity = response.getEntity();
            backStr = EntityUtils.toString(entity, "UTF-8");
        } catch (ParseException e) {
            throw new RuntimeException("HTTP解析返回数据异常", e);
        } catch (IOException e) {
            throw new RuntimeException("HTTP解析返回数据异常", e);
        }

        return backStr;
    }

    /**
     * 获取返回信息
     *
     * @param response
     * @return
     */
    private static byte[] getReturnContentByte(CloseableHttpResponse response) {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            throw new RuntimeException("HTTP通信异常，返回状态码：" + statusCode);
        }

        try {
            HttpEntity entity = response.getEntity();


            return EntityUtils.toByteArray(entity);
        } catch (ParseException e) {
            throw new RuntimeException("HTTP解析返回数据异常", e);
        } catch (IOException e) {
            throw new RuntimeException("HTTP解析返回数据异常", e);
        }
    }
}
