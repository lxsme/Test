package com.lanou.bookstore.order.service.exception;

public class StateNotSendException extends Exception {
    @Override
    public String getMessage() {
        return "卖家还未发货,不能收货哦";
    }
}
