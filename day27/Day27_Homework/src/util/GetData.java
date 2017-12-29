package util;

import data.User;
import data.WhQueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GetData {

    @Test
    public List<User> queryBeanList() throws SQLException {
        String sql = "select * from hw_user";
        List<User> users = new WhQueryRunner().query(JdbcUtil.getConnection(),sql,new BeanListHandler<User>(User.class));
        System.out.println(users);

        return users;
    }

    public void update(User user) throws SQLException {
        String sql = "update hw_user set uname=?,log=?,age=? where uid=?";
        new WhQueryRunner().update(JdbcUtil.getConnection(), sql, user.getUname(),user.getLoc(),user.getAge(),user.getUid());

    }






}
