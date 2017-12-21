package com.lanou3g.study;

import com.lanou3g.utils.JdbcUtil;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class WhQueryRunnerTest {
    /*
        根据需求结果的类型,
            选择ResultSetHandler的实现类
        如果结果集为单行单列:ScalarHandler
        如果想要一个对象的集合:BeanListHandler
        如果想要一个对象:BeanHandler
        如果想要一个Map:MapHandler
        如果想要一个Map的集合:MapListHandler
        如果想要一个数组:ArrayHandler
        如果想要一个数组的集合:ArrayListHandler

     */

    //ArrayHandler  数组
    @Test
    public  void  queryByparams() throws SQLException {
        Object[] query = new WhQueryRunner().query(JdbcUtil.getConnection(), "select * from hw_user where uname=?", new ArrayHandler(), "李小龙");

        System.out.println(Arrays.toString(query));



    }


    // ArrayListHandler 数组的集合
    @Test
    public  void  queryByparams1() throws SQLException {
        List<Object[]> query = new WhQueryRunner().query(JdbcUtil.getConnection(), "select * from hw_user", new ArrayListHandler());

        for (Object[] objects : query) {
            System.out.println(Arrays.toString(objects));
        }




    }



    // ScalarHandler 单行单列
    @Test
    public  void  queryByparams2() throws SQLException {
        Long query = new WhQueryRunner().query(JdbcUtil.getConnection(), "select count(*) from hw_user", new ScalarHandler<Long>());

        //Number类
        // 可以接收任何数值类型的值
        // Number类中有获取各种整形值的方法
        Number number = query;
        // 获得int值
        int i= number.intValue();

        System.out.println(query);

    }



    // BeanHandler 对象
    @Test
    public  void  queryBean() throws SQLException {
        User user= new WhQueryRunner().query(JdbcUtil.getConnection(), "select * from hw_user", new BeanHandler<User>(User.class));


        System.out.println(user);

    }


    // BeanListHandler 对象集合
    @Test
    public  void  queryBean1() throws SQLException {
        List<User> users = new WhQueryRunner().query(JdbcUtil.getConnection(), "select * from hw_user", new BeanListHandler<User>(User.class));

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println(users);

    }



    // MapHandler
    @Test
    public  void  queryMap() throws SQLException {
        Map<String, Object> objectMap = new WhQueryRunner().query(JdbcUtil.getConnection(), "select * from hw_user", new MapHandler());

        System.out.println(objectMap.toString());

    }
}