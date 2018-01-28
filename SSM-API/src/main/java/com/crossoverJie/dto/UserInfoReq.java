package com.crossoverJie.dto;

import java.io.Serializable;

public class UserInfoReq implements Serializable {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserInfoReq{" +
                "id=" + id +
                '}';
    }
}