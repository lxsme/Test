package com.lanou.bookstore.book.service.exception;

public class DeleteFailException extends Exception {
    @Override
    public String getMessage() {
        return "删除失败";
    }
}
