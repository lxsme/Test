package com.lanou.bookstore.book.dao;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.user.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
  private QueryRunner queryRunner = new QueryRunner();
  public List<Book> finAll() throws SQLException {
      Connection conn = C3P0Util.getConnection();
      String sql="select * from book where del=0";
      List<Book> bookList = queryRunner.query(conn, sql, new BeanListHandler<Book>(Book.class));
      C3P0Util.release(null,null,conn);
      return bookList;
  }

  public List<Book> findByCategory(int cid) throws SQLException {
      Connection conn = C3P0Util.getConnection();
      String sql = "select * from book where cid=? and del=0";
      List<Book> bookList = queryRunner.query(conn, sql, new BeanListHandler<Book>(Book.class), cid);
      C3P0Util.release(null,null,conn);
    return bookList;
  }

  public Book findByBid(int bid) throws SQLException {
      Connection conn = C3P0Util.getConnection();
      String sql="select * from book where bid=? and del=0";
      Book book = queryRunner.query(conn, sql, new BeanHandler<Book>(Book.class), bid);
      C3P0Util.release(null,null,conn);
      return book;

  }

public void insert(Book book) throws SQLException {
    Connection conn = C3P0Util.getConnection();
    String sql="insert into book values(?,?,?,?,?,?,0)";
    queryRunner.update(conn,sql,book.getBid(),book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),book.getCid());
    C3P0Util.release(null,null,conn);
}

    public int maxCid() throws SQLException {
        String sql="select bid from book order by bid DESC limit 1";
        Connection conn = C3P0Util.getConnection();
        int query = Integer.parseInt(queryRunner.query(conn, sql, new ScalarHandler<>()));
        C3P0Util.release(null,null,conn);
        return query;
    }


    public void updateDel(int bid) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql="update book set del=1 where bid=?";
        queryRunner.update(conn,sql,bid);
        C3P0Util.release(null,null,conn);

    }

}
