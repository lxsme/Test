package com.lanou.bookstore.category.service.exception;

public class CategoryFailAddException extends CategoryAddException {
    @Override
    public String getMessage() {
        return "该类型添加失败";
    }
}
