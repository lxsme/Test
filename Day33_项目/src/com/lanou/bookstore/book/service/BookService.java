package com.lanou.bookstore.book.service;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.exception.BookFailAddException;
import com.lanou.bookstore.book.service.exception.DeleteFailException;

import java.sql.SQLException;

public class BookService {
    BookDao bookDao = new BookDao();

    public String addBook(Book book) throws SQLException, BookFailAddException {
        int bid = bookDao.maxCid()+1;
        book.setBid(bid);
        bookDao.insert(book);
        Book byBid1 = bookDao.findByBid(bid);
        if (byBid1 ==null){
            throw new BookFailAddException();
        }

        return "success";
    }

    public String delBook(int bid) throws SQLException, DeleteFailException {
        bookDao.updateDel(bid);
        Book byBid = bookDao.findByBid(bid);
        if (byBid != null){
            throw new DeleteFailException();
        }
         return "success";

    }


}
