package com.lanou.bookstore.order.domain;

import java.math.BigDecimal;

public class Orderltem {
    private int iid;
    private int count;
    private String oid;
    private int bid;
    private BigDecimal subtotal;

    @Override
    public String toString() {
        return "Orderltem{" + "iid=" + iid + ", count=" + count + ", oid=" + oid + ", bid=" + bid + ", subtotal=" + subtotal + '}';
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Orderltem() {

    }
}
