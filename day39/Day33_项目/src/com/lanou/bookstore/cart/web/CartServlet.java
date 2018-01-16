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
        double sumMoney = (double) session.getAttribute("sumMoney");
        int bid = Integer.parseInt(request.getParameter("bid"));

        BookDao bookDao = new BookDao();
        Book book1 = bookDao.findByBid(bid);
        int count = Integer.parseInt(request.getParameter("count"));
        sumMoney = sumMoney + count * book1.getPrice();
        session.setAttribute("sumMoney",sumMoney);
        if (cart !=null){
            for (Cartltem cartltem : cart) {
                if (cartltem.getBook().getBid()==bid){

                    count=cartltem.getCount()+count;
                    cartltem.setCount(count);

                    return "f:jsps/cart/list.jsp";
                }
            }

        }else {
            sumMoney=0;
            cart = new ArrayList<>();
            sumMoney = sumMoney + count * book1.getPrice();
            session.setAttribute("sumMoney",sumMoney);

        }
        Cartltem cartltem = new Cartltem(book1,count);
        cart.add(cartltem);







        session.setAttribute("cart", cart);

        return "f:jsps/cart/list.jsp";

    }


    public String clear(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        double sumMoney = (double) session.getAttribute("sumMoney");
        sumMoney=0;
        session.setAttribute("sumMoney",sumMoney);
        cart.clear();
        return "f:jsps/cart/list.jsp";


    }

    public String delete(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        int bid = Integer.parseInt(request.getParameter("bid"));
        BookDao bookDao = new BookDao();
        Book book = bookDao.findByBid(bid);
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        double sumMoney = (double) session.getAttribute("sumMoney");
        for (int i = 0; i < cart.size(); i++) {
            if(cart.get(i).getBook().getBid()==bid){
                int count = cart.get(i).getCount();
                cart.remove(i);
                sumMoney=sumMoney-book.getPrice()*count;
            }
        }

        if (sumMoney<0){
            sumMoney=0;
        }
        session.setAttribute("cart",cart);
        session.setAttribute("sumMoney",sumMoney);
        return "r:jsps/cart/list.jsp";
    }



}
