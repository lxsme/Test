package com.lanou.bookstore.order.service.web;

import com.lanou.bookstore.order.service.OrderService;
import com.lanou.bookstore.order.service.web.servlet.ShowOrder;
import com.lanou.bookstore.user.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminOrderServlet" ,urlPatterns = "/aos")
public class AdminOrderServlet extends BaseServlet {
        OrderService orderService = new OrderService();
    public String find(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int state = Integer.parseInt(request.getParameter("state"));
        List<ShowOrder> showOrders = orderService.showOrder(state);
        HttpSession session = request.getSession();
        session.setAttribute("Orders",showOrders);

        return "f:/adminjsps/admin/order/list.jsp";
    }


}
