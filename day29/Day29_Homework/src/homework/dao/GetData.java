package homework.dao;


import homework.mainDao.User;
import homework.util.JdbcUtil;
import homework.util.WhQueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GetData {


    public static List<User> queryBeanList() throws SQLException {
        String sql = "select * from user";
        List<User> users = new WhQueryRunner().query(JdbcUtil.getConnection(),sql,new BeanListHandler<User>(User.class));
        System.out.println(users);

        return users;
    }


    public static void update(User user) throws SQLException {


        String sql = "insert into user (uid,uname,password)value(null,?,?)";
        Connection conn = JdbcUtil.getConnection();
        new WhQueryRunner().update(conn,sql,user.getUname(),user.getPassword());

    }









}
