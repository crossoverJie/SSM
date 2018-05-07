package com.crossoverjie.kafka.orderconsumer.dto;

import java.io.Serializable;

/**
 * @author crossoverJie
 */
public class Stock implements Serializable{
    private static final long serialVersionUID = -8437012513227627973L;

    /**
     * @type : com.crossoverJie.seconds.kill.pojo.Stock
     * count : 10
     * id : 1
     * name : null
     * sale : 2
     * version : 2
     */

    private int count;
    private int id;
    private Object name;
    private int sale;
    private int version;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}