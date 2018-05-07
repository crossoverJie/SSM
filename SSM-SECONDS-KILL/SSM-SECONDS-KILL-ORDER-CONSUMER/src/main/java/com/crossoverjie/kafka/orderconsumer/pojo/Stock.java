package com.crossoverjie.kafka.orderconsumer.pojo;

import javax.persistence.*;

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 库存
     */
    private Integer count;

    /**
     * 已售
     */
    private Integer sale;

    /**
     * 乐观锁，版本号
     */
    private Integer version;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取库存
     *
     * @return count - 库存
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置库存
     *
     * @param count 库存
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取已售
     *
     * @return sale - 已售
     */
    public Integer getSale() {
        return sale;
    }

    /**
     * 设置已售
     *
     * @param sale 已售
     */
    public void setSale(Integer sale) {
        this.sale = sale;
    }

    /**
     * 获取乐观锁，版本号
     *
     * @return version - 乐观锁，版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置乐观锁，版本号
     *
     * @param version 乐观锁，版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}