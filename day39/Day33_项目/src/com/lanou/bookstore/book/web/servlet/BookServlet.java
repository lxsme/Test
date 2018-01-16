package com.lanou.bookstore.book.web.servlet;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.book.service.BookService;
import com.lanou.bookstore.user.util.BaseServlet;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet" ,urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookDao bookDao = new BookDao();

    public void findByCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String cid1 = request.getParameter("cid");

        List<Book> books;

        if (cid1 ==null ||cid1.equals("")){
           books = bookDao.finAll();

        }else{
            int cid = Integer.parseInt(cid1);
            books = bookDao.findByCategory(cid);
        }

//        request.setAttribute("bookList",books);
//        return "r:/jsps/book/list.jsp";
//
        JSONArray jsonObject = JSONArray.fromObject(books);
        response.getWriter().write(jsonObject.toString());
        response.getWriter().close();
    }


    public String load(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int bid = Integer.parseInt(request.getParameter("bid"));
        Book book = bookDao.findByBid(bid);
        request.setAttribute("book",book);
        return "r:/jsps/book/desc.jsp";


    }




}
