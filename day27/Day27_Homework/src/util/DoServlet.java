package util;

import data.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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
        String uname = req.getParameter("uname");
        String uid = req.getParameter("uid");
        String loc = req.getParameter("loc");
        String age = req.getParameter("age");
        System.out.println(req.toString());
        User user=new User();
        user.setUname(uname);
        user.setUid(Integer.parseInt(uid));
        user.setLoc(loc);
        user.setAge(Integer.parseInt(age));
        try {
            new GetData().update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
