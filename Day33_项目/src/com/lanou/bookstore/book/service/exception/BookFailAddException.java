package com.lanou.bookstore.book.service.exception;

public class BookFailAddException extends AddBookException {
    @Override
    public String getMessage() {
        return "本书添加失败";
    }
}
