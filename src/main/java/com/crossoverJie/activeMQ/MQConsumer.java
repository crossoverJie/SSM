package com.crossoverJie.activeMQ;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import sun.reflect.generics.tree.VoidDescriptor;

import javax.jms.*;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/11.
 */
public class MQConsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER ;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD ;
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL ;

    public static void main(String args[]){
        ConnectionFactory connectionFactory ;//连接工厂
        Connection connection ;//连接
        Session session ;//会话
        Destination destination ;//消息的目的地
        MessageConsumer messageConsumer ;//消息的生产者

        //创建会话工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKERURL) ;
        try {
            connection = connectionFactory.createConnection() ;
            connection.start(); //启动连接
            //AUTO_ACKNOWLEDGE 常用的接收方式
            session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE) ;
            destination= session.createQueue("queueDemo"); // 获得消息队列
            messageConsumer = session.createConsumer(destination) ;
            messageConsumer.setMessageListener(new MQListener());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
