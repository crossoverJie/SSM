package com.crossoverJie.pojo;

import java.math.BigDecimal;

public class Price {
    private Integer id;

    private BigDecimal total;

    private BigDecimal front;

    private BigDecimal end;

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

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", total=" + total +
                ", front=" + front +
                ", end=" + end +
                '}';
    }
}