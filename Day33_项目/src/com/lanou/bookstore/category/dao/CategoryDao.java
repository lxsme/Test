package com.lanou.bookstore.category.dao;

import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.user.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
  QueryRunner queryRunner = new QueryRunner();

   public List<Category> queryAll() throws SQLException {
       String sql="select * from category";
       Connection conn = C3P0Util.getConnection();
       List<Category> categoryList = queryRunner.query(conn, sql, new BeanListHandler<Category>(Category.class));
       C3P0Util.release(null,null,conn);
     return categoryList;
   }

   public String queryCnameByCid(int cid) throws SQLException {
       String sql="select cname from category where cid=?";
       Connection conn = C3P0Util.getConnection();
       String cname = queryRunner.query(conn, sql, new ScalarHandler<>(), cid);
       C3P0Util.release(null,null,conn);
       return cname;


   }


    public Category queryByCname(String cname) throws SQLException {
        String sql="select * from category where cname=?";
        Connection conn = C3P0Util.getConnection();
        Category category = queryRunner.query(conn, sql, new BeanHandler<Category>(Category.class), cname);
        C3P0Util.release(null,null,conn);
        return category;

    }

    public void deleteByCid(int cid) throws SQLException {
        String sql="delete from category where cid=?";
        Connection conn = C3P0Util.getConnection();
        queryRunner.update(conn,sql,cid);
        C3P0Util.release(null,null,conn);

    }



   public  void add(int cid,String cname) throws SQLException {
       String sql="insert into category values(?,?)";
       Connection conn = C3P0Util.getConnection();
        queryRunner.update(conn,sql,cid,cname);
       C3P0Util.release(null,null,conn);

   }


@Test
    public int maxCid() throws SQLException {
        String sql="select cid from category order by cid DESC limit 1";
        Connection conn = C3P0Util.getConnection();
        int query = Integer.parseInt(queryRunner.query(conn, sql, new ScalarHandler<>()));
        C3P0Util.release(null,null,conn);
       return query;
    }




}
