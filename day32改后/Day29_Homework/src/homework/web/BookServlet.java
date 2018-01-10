package homework.web;

import homework.bean.Book;
import homework.dao.BookDao;
import homework.service.BookService;
import homework.service.exception.BookExistException;
import homework.service.exception.BookNotFindException;
import homework.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShowBooksServlet",urlPatterns = "/showBook")
public class BookServlet extends BaseServlet {

    BookService bookService=new BookService();
   BookDao bookDao = new BookDao();


    public String queryBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        List<Book> books = bookDao.queryBeanList();
        HttpSession session = request.getSession();
        session.setAttribute("books", books);

        return "f:/index.jsp";
    }


    public String queryBookBybname(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String bname = request.getParameter("bname");
        Book book=null;
        try {
            book  = bookService.queryBookBybname(bname);
        } catch (BookNotFindException e) {
            request.setAttribute("findBookerrorMsg",e.getMessage());
            return "r:/index.jsp";
        }
        HttpSession session = request.getSession();
        session.setAttribute("book", book);
        return "f:/showBook.jsp";
    }

    public String insetBook(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String bname = request.getParameter("bname");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        String path = request.getParameter("path");
        Book book = new Book(bname,author,price,path);
        try {
            bookService.insetBook(book);
        } catch (BookExistException e) {
            request.setAttribute("addBookerrorMsg",e.getMessage());
            return "";
        }

        return "";
    }








}
