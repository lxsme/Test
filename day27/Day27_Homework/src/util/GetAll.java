package util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetData;
import net.sf.json.JSONArray;
import domain.User;

public class GetAll extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			List<User> users = new GetData().queryBeanList();

			User[] userarray = users.toArray(new User[users.size()]);
		    JSONArray jsonArray = JSONArray.fromObject(userarray);
		    resp.getWriter().write(jsonArray.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
