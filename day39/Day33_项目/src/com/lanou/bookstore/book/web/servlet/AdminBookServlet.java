package com.lanou.bookstore.book.web.servlet;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.book.service.exception.BookFailAddException;
import com.lanou.bookstore.book.service.exception.DeleteFailException;
import com.lanou.bookstore.category.dao.CategoryDao;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.user.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "AdminBookServlet",urlPatterns = "/aBook")
public class AdminBookServlet extends BaseServlet {
    BookDao bookDao = new BookDao();
    CategoryDao categoryDao = new CategoryDao();
    BookService bookService = new BookService();
    public String findAllBook(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Book> bookList = bookDao.finAll();
        HttpSession session = request.getSession();
        session.setAttribute("bookList",bookList);
        return "f:/adminjsps/admin/book/list.jsp";
    }

    public String findBook(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int bid = Integer.parseInt(request.getParameter("bid"));
        Book book = bookDao.findByBid(bid);
        HttpSession session = request.getSession();
        session.setAttribute("book",book);
        List<Category> categories = categoryDao.queryAll();
        session.setAttribute("categories",categories);
        return "f:/adminjsps/admin/book/desc.jsp";
    }


    public String showBookCategories(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<Category> categories = categoryDao.queryAll();
        HttpSession session = request.getSession();
        session.setAttribute("categories",categories);

        return "f:/adminjsps/admin/book/add.jsp" ;
    }

    public  String addBook(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String bname= request.getParameter("bname");
        System.out.println("name---"+bname);
        String image = request.getParameter("image");
        System.out.println("image---"+image);
//        double price = Double.parseDouble(request.getParameter("price"));
        String price = request.getParameter("price");
        System.out.println("price---"+price);

//        String author = request.getParameter("author");
//        int cid = Integer.parseInt(request.getParameter("cid"));
//        Book book = new Book(0,bname,price,author,image,cid);
//
//        System.out.println("tututut"+image);
//        System.out.println("cid------"+cid);
//        HttpSession session = request.getSession();
//        try {
//            bookService.addBook(book);
//        } catch (BookFailAddException e) {
//           session.setAttribute("msg",e.getMessage());
//            return "f:/adminjsps/admin/book/add.jsp" ;
//        }
//
//        session.setAttribute("msg","添加成功");
        return "f:/adminjsps/admin/book/add.jsp" ;
    }



    public String delBook(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int bid = Integer.parseInt(request.getParameter("bid"));
        HttpSession session = request.getSession();

        try {
            bookService.delBook(bid);
        }  catch (DeleteFailException e) {
            session.setAttribute("msg",e.getMessage());
            return "f:/adminjsps/admin/book/desc.jsp";
        }


        return "f:/aBook?method=findAllBook" ;
    }











}
