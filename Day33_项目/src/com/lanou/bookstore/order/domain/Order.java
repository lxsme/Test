package com.lanou.bookstore.order.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private String oid;
    private Timestamp ordertime;
    private double total;
    private int state;
    private String uid;
    private String address;

    @Override
    public String toString() {
        return "Order{" + "oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", uid=" + uid + ", address='" + address + '\'' + '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
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
