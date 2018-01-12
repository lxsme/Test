package com.lanou.bookstore.category.service.exception;

public class CategoryNotExistException extends DeleteException {
    @Override
    public String getMessage() {
        return "该类型不存在";
    }
}
