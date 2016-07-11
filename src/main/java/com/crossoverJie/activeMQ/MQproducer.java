package com.crossoverJie.activeMQ;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/11.
 */
public class MQproducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER ;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD ;
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL ;
    private static final int NUM = 10 ;

    public static void main(String args[]){
        ConnectionFactory connectionFactory ;//连接工厂
        Connection connection = null;//连接
        Session session ;//会话
        Destination destination ;//消息的目的地
        MessageProducer messageProducer ;//消息的生产者

        //创建会话工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKERURL) ;
        try {
            connection = connectionFactory.createConnection() ;
            connection.start(); //启动连接
            //AUTO_ACKNOWLEDGE 常用的接收方式
            session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE) ;
            destination= session.createQueue("queueDemo"); // 创建消息队列
            messageProducer = session.createProducer(destination) ;
            sendMsg(session,messageProducer);//发送消息
            //因为开了事务的，所以需要提交事务
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sendMsg(Session session,MessageProducer messageProducer){
        for (int i =0 ;i< NUM;i++){
            try {
                TextMessage textMessage = session.createTextMessage("发送消息" + i);
                System.out.println("发送消息第"+i);
                messageProducer.send(textMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
