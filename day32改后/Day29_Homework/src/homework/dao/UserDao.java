package homework.dao;


import homework.bean.User;
import homework.util.JdbcUtil;
import homework.util.WhQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {


    public List<User> queryBeanList() throws SQLException {
        String sql = "select * from user";
        List<User> users = new WhQueryRunner().query(JdbcUtil.getConnection(),sql,new BeanListHandler<User>(User.class));
        System.out.println(users);

        return users;
    }


    public  User queryBeanByUname(String uname) throws SQLException {
        String sql = "select * from user where uname=?";
        User user = new WhQueryRunner().query(JdbcUtil.getConnection(),sql,new BeanHandler<User>(User.class),uname);
        return user;
    }

    public void update(User user) throws SQLException {


        String sql = "insert into user (uid,uname,password)value(null,?,?)";
        Connection conn = JdbcUtil.getConnection();
        new WhQueryRunner().update(conn,sql,user.getUname(),user.getPassword());

    }









}
