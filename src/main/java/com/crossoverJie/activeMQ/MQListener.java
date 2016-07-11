package com.crossoverJie.activeMQ;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/11.
 */
public class MQListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            String text = ((TextMessage) message).getText();
            System.out.println("收到的信息是"+text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
