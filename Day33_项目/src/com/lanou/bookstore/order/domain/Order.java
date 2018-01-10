package com.lanou.bookstore.order.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private int oid;
    private Timestamp ordertime;
    private BigDecimal total;
    private int state;
    private int uid;
    private String address;

    @Override
    public String toString() {
        return "Order{" + "oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", uid=" + uid + ", address='" + address + '\'' + '}';
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order() {

    }
}
