package homework.web;

import homework.bean.User;
import homework.service.UserService;
import homework.service.exception.InvalidUsernameException;
import homework.service.exception.LoginException;
import homework.service.exception.PasswordNotMatchedException;
import homework.service.exception.RegisterException;
import homework.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@WebServlet(name = "UserServlet",urlPatterns ="/user")
public class UserServlet extends BaseServlet{
   private UserService userService = new UserService();
    private String path =null;

    public String login(HttpServletRequest request, HttpServletResponse response)throws SQLException{
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        User fromU = new User(uname,password);

        try {
            User fromDb = userService.login(fromU);
            HttpSession session = request.getSession();
            session.setAttribute("user",fromDb);

            Cookie username= new Cookie("uname",fromDb.getUname());
            username.setPath("/day29/123_login.jsp");
            username.setMaxAge(60*60*30*24);
            response.addCookie(username);
//            path="f:/index.jsp";
            path = "f:/showBook?method=queryBook";

        }  catch (InvalidUsernameException e) {
            request.setAttribute("errorMag1",e.getMessage());
          path="r:/123_login.jsp";
        }catch (PasswordNotMatchedException e){
            request.setAttribute("errorMag2",e.getMessage());
            path="r:/123_login.jsp";
        }

        return path;
    }

    public String register(HttpServletRequest request, HttpServletResponse response)throws SQLException{
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        User fromU = new User(uname,password);
        try {
            String s = userService.registerByMail(fromU);
                 path="f:/123_login.jsp";
        } catch (RegisterException e) {
            path="r:/123_register.jsp";
        }

        return path;
    }

}
