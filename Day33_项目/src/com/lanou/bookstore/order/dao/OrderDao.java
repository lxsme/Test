package com.lanou.bookstore.order.dao;

import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.Orderltem;
import com.lanou.bookstore.user.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    QueryRunner queryRunner = new QueryRunner();
    public void insertOrder(Order order) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "insert into orders values(?,?,?,?,?,?)";
        queryRunner.update(conn, sql,order.getOid(),order.getOrdertime(),order.getTotal()
                            ,order.getState(),order.getUid(),order.getAddress());
        C3P0Util.release(null,null,conn);

    }

    public void insert(Orderltem orderltem) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "insert into orderitem values(?,?,?,?,?)";
        queryRunner.update(conn, sql,orderltem.getIid(),orderltem.getCount(),orderltem.getSubtotal(),
                           orderltem.getOid(),orderltem.getBid() );
        C3P0Util.release(null,null,conn);

    }




    public List<Orderltem>  queryAll() throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "select * from orderitem";
        List<Orderltem> orderList = queryRunner.query(conn, sql, new BeanListHandler<Orderltem>(Orderltem.class));
        C3P0Util.release(null,null,conn);
        return orderList;

    }

    public List<Order>  queryAllOrder() throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "select * from orders";
        List<Order> orderList = queryRunner.query(conn, sql, new BeanListHandler<Order>(Order.class));
        C3P0Util.release(null,null,conn);
        return orderList;

    }



    public List<Order> queryByUid(String uid) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "select * from orders where uid=?";
        List<Order> orderList = queryRunner.query(conn, sql, new BeanListHandler<Order>(Order.class),uid);
        C3P0Util.release(null,null,conn);
        return orderList;

    }


    public Order queryOrderByOid(String oid) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "select * from orders where oid=?";
        Order order = queryRunner.query(conn, sql, new BeanHandler<Order>(Order.class), oid);
        C3P0Util.release(null,null,conn);
        return order;
    }

    public List<Object[]> queryBookByOid(String oid) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "select count,bid from orders a inner join orderitem b on a.oid=b.oid where a.oid=?";
        List<Object[]> list = queryRunner.query(conn, sql, new ArrayListHandler(), oid);
        C3P0Util.release(null,null,conn);
        return list;

    }


    public void updateState(int state,String oid) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "update orders set state=? where oid=?";
        queryRunner.update(conn,sql,state,oid);
        C3P0Util.release(null,null,conn);
    }

    public int getState(String oid) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "select state from orders where oid=?";
        Integer state = queryRunner.query(conn, sql, new ScalarHandler<Integer>(), oid);
        C3P0Util.release(null,null,conn);
        return state;

    }

    public String getAddress(String oid) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "select address from orders where oid=?";
        String address = queryRunner.query(conn, sql, new ScalarHandler<String>(), oid);
        C3P0Util.release(null,null,conn);
        return address;

    }


    public void updateAddress(String address,String oid) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "update orders set address=? where oid=?";
        queryRunner.update(conn,sql,address,oid);
        C3P0Util.release(null,null,conn);
    }

    public List<Order> queryByState(int state) throws SQLException {
        Connection conn = C3P0Util.getConnection();
        String sql = "select * from orders where state=?";
        List<Order> orders = queryRunner.query(conn, sql, new BeanListHandler<Order>(Order.class),state);
        C3P0Util.release(null,null,conn);
        return orders;

    }

}
