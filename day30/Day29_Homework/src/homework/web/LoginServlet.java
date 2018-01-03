package homework.web;

import homework.dao.UserDao;
import homework.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
//            System.out.println("uname:"+uname);
//            System.out.println(""+user);
            if (user!=null&&user.getPassword().equals(password)){
                getServletContext().setAttribute("user",user);
                HttpSession session = request.getSession();
                session.setAttribute("uname",uname);
                session.setAttribute("password",password);
                RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
                rs.forward(request,response);
            }else{
                response.sendRedirect("http://localhost:8080/day29/123_login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
