package homework.web;

import homework.dao.GetData;
import homework.mainDao.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/rs")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");

        try {
            User user = GetData.queryBeanByUname(uname);
            System.out.println("uname:"+uname);
            System.out.println(""+user);
            if (user!=null){
                RequestDispatcher rs = request.getRequestDispatcher("/123_register.html");
                rs.forward(request,response);
            }else{
                user = new User();
                user.setPassword(password);
                user.setUname(uname);
                GetData.update(user);
                response.sendRedirect("http://localhost:8080/123_login.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
