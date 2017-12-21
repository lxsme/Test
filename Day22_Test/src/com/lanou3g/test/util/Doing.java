package com.lanou3g.test.util;

import com.lanou3g.test.instances.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface Doing {

    // 添加对象
    public void add(User user) throws SQLException;

   // 修改
   public void update(User user) throws SQLException;

   // 删除方法
   public void delete(int id) throws SQLException;

   // 查找方法
   public User findById(int id) throws SQLException;

   // 查找所有
   public List<User> findAll() throws SQLException;

   // 查询有几条记录
   public long personCount() throws SQLException;




}
