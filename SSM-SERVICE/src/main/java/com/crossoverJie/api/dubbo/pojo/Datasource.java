package com.crossoverJie.api.dubbo.pojo;

import java.io.Serializable;

public class Datasource implements Serializable {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Datasource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}