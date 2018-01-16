package com.lanou.bookstore.order.web;

import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.service.OrderService;
import com.lanou.bookstore.order.web.servlet.ShowOrder;
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
        String s = request.getParameter("state");
        System.out.println("s=="+s);
        int state = Integer.parseInt(s);

        List<ShowOrder> showOrders = orderService.showOrder(state);
        HttpSession session = request.getSession();
        session.setAttribute("Orders",showOrders);

        return "f:/adminjsps/admin/order/list.jsp";
    }

    public String changeState(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String oid = request.getParameter("oid");
        int state = orderService.changeAdminState(oid);
        if (state==4){
            System.out.println("发货失败了");
            return "";
        }

        return "f:/aos?method=find&state="+state;

    }




}
