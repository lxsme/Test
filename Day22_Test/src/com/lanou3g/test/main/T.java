package com.lanou3g.test.main;

import com.lanou3g.test.instances.User;
import com.lanou3g.test.util.UserDo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class T {

    private UserDo user;

    @Test
    public void find () throws SQLException {
        // 查找全部
        user = new UserDo();
        List<User> all = user.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }

    }

    @Test
    public void add() throws SQLException {
        // 添加
        User user2=new User("王二狗",500,"武汉",35);
        user.add(user2);
    }






}
