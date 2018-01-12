package com.lanou.bookstore.category.service.exception;

public class CategoryFailDeleteException extends DeleteException {
    @Override
    public String getMessage() {
        return "该类型删除失败";
    }
}
