package dao;

import domain.User;
import util.WhQueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GetData {

    @Test
    public List<User> queryBeanList() throws SQLException {
        String sql = "select * from user";
        List<User> users = new WhQueryRunner().query(JdbcUtil.getConnection(),sql,new BeanListHandler<User>(User.class));
        System.out.println(users);

        return users;
    }

    @Test
    public void update(User user) throws SQLException {


        String sql = "insert into user (uid,uname,age,loc)value(null,?,?,?)";
        Connection conn = JdbcUtil.getConnection();
        new WhQueryRunner().update(conn,sql,user.getUname(),user.getAge(),user.getLoc());

    }









}
