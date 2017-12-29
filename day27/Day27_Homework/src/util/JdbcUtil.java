package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/JdbcUtil.properties"));
            String driverName = properties.getProperty("driverName");
            url = properties.getProperty("url");
            database = properties.getProperty("database");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
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
            Connection connection = DriverManager.getConnection(url+database,user,password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }





}
