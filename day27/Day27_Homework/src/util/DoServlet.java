package util;

import dao.GetData;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

public class DoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String uid = req.getParameter("uid");
        String loc = req.getParameter("loc");
        String age = req.getParameter("age");
//        User user=new User();
//        user.setUname(uname);
//        user.setUid(Integer.parseInt(uid));
//        user.setLoc(loc);
//        user.setAge(Integer.parseInt(age));
//        JSONObject jsonObject = JSONObject.fromObject(user);
        System.out.println(uname);
        System.out.println(uid);
        System.out.println(loc);
        System.out.println(age);



        resp.getWriter().write("INSERT SUCCESS");


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

//        String uname = req.getParameter("uname");
//        String uid = req.getParameter("uid");
//        String loc = req.getParameter("loc");
//        String age = req.getParameter("age");
//        System.out.println(req.toString());


        User user=new User();

        Map<String, String[]> map = req.getParameterMap();

        try {
            BeanUtils.populate(user,map);
//            System.out.println(user.toString());
            new GetData().update(user);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            new GetData().update(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        user.setUname(uname);
//        user.setUid(Integer.parseInt(uid));
//        user.setLoc(loc);
//        user.setAge(Integer.parseInt(age));
//        System.out.println(user.toString());
//        try {
//            new GetData().update(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        /*
        JSONObject jsonObject = JSONObject.fromObject(user);
        System.out.println(jsonObject.toString());

//        System.out.println(uname);
//        System.out.println(uid);
//        System.out.println(loc);
//        System.out.println(age);
*/
        resp.getWriter().write("INSERT SUCCESS");

    }
}
