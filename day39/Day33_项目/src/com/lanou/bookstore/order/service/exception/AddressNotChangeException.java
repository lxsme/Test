package com.lanou.bookstore.order.service.exception;

public class AddressNotChangeException extends Exception  {
    @Override
    public String getMessage() {
        return "地址没保存成功";
    }
}
