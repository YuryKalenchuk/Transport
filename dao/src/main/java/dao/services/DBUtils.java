package dao.services;

import java.sql.*;

public class DBUtils {
    public static final String DB_URL = "jdbc:mysql://localhost/mydbtest?useUnicode=true&serverTimezone=UTC&useSSL=false";
    public static final String DB_USER = "root";
    public static final String DB_USER_PSW = "кщще";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PSW);
            System.out.println("Connection is open - " + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}


