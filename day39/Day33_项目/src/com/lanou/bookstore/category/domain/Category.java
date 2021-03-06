package com.lanou.bookstore.category.domain;

public class Category {
    private int cid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    private String cname;

    @Override
    public String toString() {
        return "Category{" + "cid=" + cid + ", cname='" + cname + '\'' + '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Category() {

    }

    public Category(String cname) {
        this.cname = cname;

    }
}
