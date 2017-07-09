package com.crossoverJie.pojo;

import java.math.BigDecimal;

public class PriceVersion {
    private Integer id;

    private BigDecimal total;

    private BigDecimal front;

    private BigDecimal end;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getFront() {
        return front;
    }

    public void setFront(BigDecimal front) {
        this.front = front;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public void setEnd(BigDecimal end) {
        this.end = end;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}