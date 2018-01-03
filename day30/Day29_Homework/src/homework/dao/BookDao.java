package homework.dao;

import homework.bean.Book;
import homework.bean.User;
import homework.util.JdbcUtil;
import homework.util.WhQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    public List<Book> queryBeanList() throws SQLException {
        String sql = "select * from book";
        List<Book> books = new WhQueryRunner().query(JdbcUtil.getConnection(),sql,new BeanListHandler<Book>(Book.class));
//        System.out.println(books);

        return books;
    }


    public  Book queryBeanByUname(String bname) throws SQLException {
        String sql = "select * from book where bname=?";
        Book book = new WhQueryRunner().query(JdbcUtil.getConnection(),sql,new BeanHandler<Book>(Book.class),bname);
        return book;
    }

    public void update(Book book) throws SQLException {


        String sql = "insert into book (bid,bname,author,price)value(null,?,?,?)";
        Connection conn = JdbcUtil.getConnection();
        new WhQueryRunner().update(conn,sql,book.getBname(),book.getAuthor(),book.getPrice());

    }


}
