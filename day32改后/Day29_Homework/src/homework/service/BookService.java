package homework.service;

import homework.bean.Book;
import homework.dao.BookDao;
import homework.service.exception.BookExistException;
import homework.service.exception.BookNotFindException;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookDao bookDao= new BookDao();

    public Book queryBookBybname(String bname) throws SQLException, BookNotFindException {
        Book book = bookDao.queryBeanByBname(bname);
        if (book==null){
            throw new BookNotFindException();
        }
        return book;
    }

    public void insetBook(Book book) throws SQLException, BookExistException {
        Book formDB = bookDao.queryBeanByBname(book.getBname());
        if (formDB !=null){
            throw new BookExistException();
        }
       bookDao.insert(book);
    }



}
