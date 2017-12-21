package test.tool;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCtool {
    static {
        Properties ps = new Properties();
        try {
            ps.load(new FileReader("src/jdbc.properties"));
            String driverName = ps.getProperty("driverName");
            url = ps.getProperty("url");
            database = ps.getProperty("database");
            user = ps.getProperty("user");
            possword = ps.getProperty("possword");

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
    private static String possword;


    public static Connection getConnection(){
        try {

            Connection conn = DriverManager.getConnection(url+database,user,possword);
            return conn;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }







    public static void execute1(ExecuteInter e) throws SQLException {

        Connection connection = DriverManager.getConnection(url, user, possword);

        Statement execute = e.execute(connection);
        execute.close();
        connection.close();


    }







}
