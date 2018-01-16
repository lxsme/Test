package com.lanou.bookstore.user.web.servlet;

import com.lanou.bookstore.user.service.UserService;
import com.lanou.bookstore.user.service.exception.InvalidUsernameException;
import com.lanou.bookstore.user.service.exception.PasswordNotMatchException;
import com.lanou.bookstore.user.util.BaseServlet;
import com.lanou.bookstore.user.util.C3P0Util;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Properties;

@WebServlet(name = "AdminUserServlet" ,urlPatterns = "/admLogin")
public class AdminUserServlet extends BaseServlet {

    UserService userService = new UserService();
    public String login (HttpServletRequest request, HttpServletResponse response) throws IOException {


        String adminname1 = request.getParameter("adminname");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        request.setAttribute("adminname",adminname1);
        session.setAttribute("adminname",adminname1);

        try {
            userService.adminLogin(adminname1,password);
        } catch (InvalidUsernameException e) {
            request.setAttribute("msg",e.getMessage());
            return "r:/adminjsps/login.jsp";

        } catch (PasswordNotMatchException e) {
            request.setAttribute("msg",e.getMessage());
            return "r:/adminjsps/login.jsp";

        }

        return "f:adminjsps/admin/index.jsp";
    }


}
