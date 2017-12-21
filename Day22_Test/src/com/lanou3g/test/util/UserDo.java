package com.lanou3g.test.util;

import com.lanou3g.test.instances.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDo implements Doing {
    private SonQueryRunner runner =new SonQueryRunner();
    @Override
    public void add(User user) throws SQLException {
        String sql = "insert into hw_user(uid,uname,age,loc)values(?,?,?,?)";
    runner.update(JdbcTool.getConnection(), sql,user.getUid(), user.getUname(),user.getAge(),user.getLoc());
    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "update hw_user set uname=?,log=?,age=? where uid=?";
     runner.update(JdbcTool.getConnection(), sql, user.getUname(),user.getLoc(),user.getAge(),user.getUid());

    }



    @Override
    public void delete(int uid) throws SQLException {
        String sql = "delete from hw_user where uid=?";
     runner.update(JdbcTool.getConnection(), sql, uid);
    }

    @Override
    public User findById(int uid) throws SQLException {
        String sql = "select name,age,description from hw_user where uid=?";
        User p = runner.query(JdbcTool.getConnection(), sql, new BeanHandler<User>(User.class),uid);
            return p;

    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "select * from hw_user";
             List<User> users = runner.query(JdbcTool.getConnection(), sql, new BeanListHandler<User>(User.class));
             return users;
    }

    @Override
    public long personCount() throws SQLException {
        String sql = "select count(uid) from hw_user";
        Long query = runner.query(JdbcTool.getConnection(), sql, new ScalarHandler<Long>());

        return query;

    }
}
