package com.lanou.bookstore.cart.web;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.domain.Cartltem;
import com.lanou.bookstore.user.util.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartServlet",urlPatterns = "/car")
public class CartServlet extends BaseServlet{

    public String addCartltem(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, SQLException {
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        int bid = Integer.parseInt(request.getParameter("bid"));
        BookDao bookDao = new BookDao();
        Book book1 = bookDao.findByBid(bid);
        int count = Integer.parseInt(request.getParameter("count"));

        for (Cartltem cartltem : cart) {
            if (cartltem.getBook().getBid()==bid){
                cartltem.setCount(cartltem.getCount()+count);

                return "f:jsps/cart/list.jsp";
            }
        }

        Cartltem cartltem = new Cartltem(book1,count);
        cart.add(cartltem);
        int sum= ;
        session.setAttribute("sum",);
        session.setAttribute("cart", cart);

        return "f:jsps/cart/list.jsp";

    }


    public String clear(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        cart.clear();
        return "f:jsps/cart/list.jsp";


    }

    public String delete(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        int bid = Integer.parseInt(request.getParameter("bid"));
        BookDao bookDao = new BookDao();
        Book book = bookDao.findByBid(bid);
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");

        for (int i = 0; i < cart.size(); i++) {
            if(cart.get(i).getBook().getBid()==bid){
                cart.remove(i);
            }
        }

        session.setAttribute("cart",cart);

        return "r:jsps/cart/list.jsp";
    }



}
