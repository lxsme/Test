package com.lanou.bookstore.cart.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Cartltem> cart = new ArrayList<>();

    public List<Cartltem> getCart() {
        return cart;
    }

    public void setCart(List<Cartltem> cart) {
        this.cart = cart;
    }
}
