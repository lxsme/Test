package com.lanou.bookstore.order.service.exception;

public class StateErrorException extends Exception {
    @Override
    public String getMessage() {
        return "状态修改失败";
    }
}
