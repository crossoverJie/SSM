package com.crossoverJie.cxf.impl;

import com.crossoverJie.cxf.HelloWorld;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

	public static void main(String[] args) {
		System.out.println("web service 启动中。。。");
		HelloWorld implementor= new HelloWorldImpl();
		/**修改为自己电脑的IP**/
		String address="http://192.168.1.19:9000/helloWorld";
		JaxWsServerFactoryBean factoryBean=new JaxWsServerFactoryBean();
		factoryBean.setAddress(address); // 设置地址
		factoryBean.setServiceClass(HelloWorld.class); // 接口类
		factoryBean.setServiceBean(implementor); // 设置实现类
		factoryBean.create(); // 创建webservice接口
		System.out.println("web service 启动成功。。");
	}
}
