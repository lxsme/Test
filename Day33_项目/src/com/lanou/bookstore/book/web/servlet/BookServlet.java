package com.lanou.bookstore.book.web.servlet;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.user.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet" ,urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookDao bookDao = new BookDao();
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {


        List<Book> books = bookDao.finAll();
        request.setAttribute("bookList",books);
        return "r:/jsps/book/list.jsp";


    }

    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Book> books = bookDao.findByCategory(cid);
        request.setAttribute("bookList",books);
        return "r:/jsps/book/list.jsp";
    }


    public String load(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int bid = Integer.parseInt(request.getParameter("bid"));
        Book book = bookDao.findByBid(bid);
        request.setAttribute("book",book);
        return "r:/jsps/book/desc.jsp";


    }




}
