package com.lanou.bookstore.order.web;

import com.lanou.bookstore.cart.domain.Cartltem;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.service.OrderService;
import com.lanou.bookstore.order.service.exception.AddressNotChangeException;
import com.lanou.bookstore.order.service.exception.StateErrorException;
import com.lanou.bookstore.order.service.exception.StateNotSendException;
import com.lanou.bookstore.order.web.servlet.ShowOrder;
import com.lanou.bookstore.user.domain.User;
import com.lanou.bookstore.user.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
   OrderService orderService = new OrderService();

    public String add( HttpServletRequest request, HttpServletResponse response) throws SQLException {

        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        double sumMoney = (double) session.getAttribute("sumMoney");
        String address = request.getParameter("address");
        int orderCount = (int) session.getAttribute("orderCount");

        if(cart==null){
            cart= (List<Cartltem>) session.getAttribute("newCart");
        }
        Order order = orderService.add(address, cart, user,orderCount,sumMoney);
        orderCount++;
        session.setAttribute("order",order);
        session.setAttribute("newCart",cart);
        session.setAttribute("cart",null);
        session.setAttribute("orderCount",orderCount);


    return "f:/jsps/order/desc.jsp";


    }

    public String myOrders( HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String code = user.getCode();
        List<Order> byUid = orderService.findByUid(code);
        List<ShowOrder> showOrders = new ArrayList<>();

        List<Order> byUid1=new ArrayList<>();
        int j =0;
        for (int i =byUid.size()-1; i >=0 ; i--) {
            byUid1.add(j,byUid.get(i));
            j++;

        }

        for (Order order : byUid1) {
            showOrders.add(new ShowOrder(order));
        }


        session.setAttribute("myOrders",showOrders);
        return "f:/jsps/order/list.jsp";
    }

public String load(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    String oid = request.getParameter("oid");
    Order order = orderService.queryOrderByOid(oid);
    List<Cartltem> newCart = orderService.load(oid);

    HttpSession session = request.getSession();
    session.setAttribute("newCart",newCart);
    session.setAttribute("order",order);

    return "f:/jsps/order/desc.jsp";
}


public String payment(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    String oid = request.getParameter("oid");
    String address = request.getParameter("address");
    HttpSession session = request.getSession();

    try {
        orderService.updateOrder(address,oid);
    } catch (StateErrorException e) {
        request.setAttribute("msg", e.getMessage());
        return "r:/jsps/order/msg.jsp";
    } catch (AddressNotChangeException e) {
        request.setAttribute("msg", e.getMessage());
        return "r:/jsps/order/msg.jsp";
    }

    return "f:/jsps/order/list.jsp";
}

public String confirm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    String oid = request.getParameter("oid");
    HttpSession session = request.getSession();

    try {
        orderService.confirm(oid);
    }catch (StateErrorException e) {
        request.setAttribute("msg", e.getMessage());
        return "r:/jsps/order/msg.jsp";
    } catch (StateNotSendException e) {
        request.setAttribute("msg", e.getMessage());
        return "r:/jsps/order/msg.jsp";
    }

    session.setAttribute("msg", "交易成功");
    return "f:/order?method=myOrders";
}







}
