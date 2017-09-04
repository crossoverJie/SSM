package com.crossoverJie.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

/**
 * 读取配置文件工具类
 */
public class PropertyUtilExt {

	private final static Logger logger = LoggerFactory.getLogger(PropertyUtilExt.class);

    /**
     * 读取配置文件中的value值
     * @param fileName 配置文件名
     * @param key 需要获取的key
     * @return
     */
    public static String getProperty(String fileName, String key){
        String value = null;
        String rootPath = null;
        Properties properties = new Properties();
        try{
            //获取根路径
            rootPath = PropertyUtil.class.getClassLoader().getResource("").toURI().getPath();
//            rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            //拼成配置文件目录
            String path = rootPath+"/"+fileName;
            //读取配置文件
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            properties.load(fileInputStream);
            value = properties.getProperty(key);
        }catch(Exception e){
        	logger.error("读取配置文件失败！", e);
        }
        return value;
    }

    /**
     * 获取web.peoperties中的值
     * @param key
     * @return
     */
    public static String getProperty(String key){
        String filename = "web.properties";
        return getProperty(filename, key);
    }

    /**
     * 获取项目根目录
     * @return
     * @throws Exception
     */
    public static String getRootPath() throws Exception {
        return PropertyUtil.class.getClassLoader().getResource("").toURI().getPath();
    }

    /**
     * 获取项目外配置文件内容
     * @param propertyName 配置文件启动参数名
     * @param keyName 文件内key
     * @return
     */
    public static String getExtProperty(String propertyName, String keyName){
        String value = "";
        String propPath = System.getProperty(propertyName);
        if(StringUtils.isEmpty(propPath)){
            throw new NullPointerException("配置文件的地址不能为空，请在启动参数中指定");
        }

        try {
            InputStream inputestream = null;
            if(propPath.startsWith("file:")){
                URI uri = new URI(propPath);
                inputestream = new FileInputStream(new File(uri));
            }else{
                inputestream = new FileInputStream(new File(propPath));
            }
            Properties properties = new Properties();
            properties.load(inputestream);
            value = properties.getProperty(keyName);
        } catch (Exception e) {
            logger.error(String.format("加载配置文件【%s】失败。", propPath), e);
            System.exit(0);
        }
        return value;
    }
}
