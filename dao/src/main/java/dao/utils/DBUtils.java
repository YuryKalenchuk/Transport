package dao.utils;

import java.sql.*;

public class DBUtils {
    public static final String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
    public static final String DB_USER = "postgres";
    public static final String DB_USER_PSW = "root";

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


