package com.crossoverjie.kafka.orderconsumer.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "stock_order")
public class StockOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 库存ID
     */
    private Integer sid;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取库存ID
     *
     * @return sid - 库存ID
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * 设置库存ID
     *
     * @param sid 库存ID
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}