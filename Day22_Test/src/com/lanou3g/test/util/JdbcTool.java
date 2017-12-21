package com.lanou3g.test.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTool {
    static {
        Properties ps = new Properties();
        try {
            ps.load(new FileReader("src/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driverName= ps.getProperty("driverName");
        url = ps.getProperty("url");
        database = ps.getProperty("database");
        user = ps.getProperty("user");
        password = ps.getProperty("password");

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String url;
    private static String database;
    private static String user;
    private static String password;

    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(url + database, user, password);
            return conn;
        } catch (SQLException e) {
            System.out.println("没有连接");

        }

        return null;
    }







//
//    public static void exeture(Doing e) throws SQLException {
//        Connection conn = DriverManager.getConnection(url + database, user, password);
//        e.dos(conn).close();
//        conn.close();
//
//    }




}
