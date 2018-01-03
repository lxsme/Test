package homework.web;

import homework.bean.Book;
import homework.dao.BookDao;
import homework.dao.UserDao;
import homework.bean.User;
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
    private BookDao bookDao = new BookDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        try {
            List<Book> books = bookDao.queryBeanList();
            Book[] books1 = books.toArray(new Book[books.size()]);
            JSONArray jsonArray = JSONArray.fromObject(books1);
            System.out.println(""+jsonArray);
            response.getWriter().write(""+jsonArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
