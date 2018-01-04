package homework.web;

import homework.dao.UserDao;
import homework.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/rs")
public class RegisterServlet extends HttpServlet {
   private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");

        try {
            User user = userDao.queryBeanByUname(uname);

            if (user!=null){
                RequestDispatcher rs = request.getRequestDispatcher("/123_register.html");
                rs.forward(request,response);
            }else{
//                boolean isMatched;
//                if(isMatched = Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", uname){
                    user = new User();
                    user.setPassword(password);
                    user.setUname(uname);
                userDao.update(user);
                    response.sendRedirect("http://localhost:8080/day29/123_login.jsp");
//                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
