package homework.web;

import homework.dao.UserDao;
import homework.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/qs")
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");



//        User user1 = new User();
//        Map<String, String[]> map = request.getParameterMap();
//        try {
//            BeanUtils.populate(user1,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }




        try {
            User user = userDao.queryBeanByUname(uname);

            if (user!=null&&user.getPassword().equals(password)){
                // 通过设置全局变量来显示用户信息
//                getServletContext().setAttribute("user",user);

                // 通过session储存用户信息
                HttpSession session = request.getSession();
                session.setAttribute("user",user);

                Cookie username= new Cookie("uname",user.getUname());
                username.setPath("/day29/123_login.jsp");
                username.setMaxAge(60*60*30*24);
                response.addCookie(username);
                response.sendRedirect("http://localhost:8080/day29/index.jsp");
                // 重定向到主页
//                RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
//                rs.forward(request,response);
            }else{
                response.sendRedirect("http://localhost:8080/day29/123_login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");


    }
}
