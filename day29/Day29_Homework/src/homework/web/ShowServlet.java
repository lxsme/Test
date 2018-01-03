package homework.web;

import homework.dao.GetData;
import homework.mainDao.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<User> users = GetData.queryBeanList();
            User[] users1 = users.toArray(new User[users.size()]);
            JSONArray jsonArray = JSONArray.fromObject(users1);
            System.out.println(""+jsonArray);
            response.getWriter().write(""+jsonArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
