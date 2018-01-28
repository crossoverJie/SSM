package com.crossoverJie.req;

import java.io.Serializable;

public abstract class BaseRequest implements Serializable {

    private static final long serialVersionUID = 268113588289950599L;
    /**
     * 请求号
     */
    private String reqNo;

    /**
     * 当前请求的时间戳
     */
    private int timeStamp;

 
    public BaseRequest() {
        this.setTimeStamp((int)(System.currentTimeMillis() / 1000));
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "reqNo='" + reqNo + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
