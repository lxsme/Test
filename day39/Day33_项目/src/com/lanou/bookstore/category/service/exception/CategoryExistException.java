package com.lanou.bookstore.category.service.exception;

public class CategoryExistException extends CategoryAddException {
    @Override
    public String getMessage() {
        return "该类型已存在";
    }
}
