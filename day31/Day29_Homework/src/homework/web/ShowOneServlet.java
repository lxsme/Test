package homework.web;

import homework.bean.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowOneServlet",urlPatterns = "/showone")
public class ShowOneServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        User user = (User) getServletContext().getAttribute("user");

        JSONObject jsonObject = JSONObject.fromObject(user);

        response.getWriter().write(jsonObject.toString());

    }
}
