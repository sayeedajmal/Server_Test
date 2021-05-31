package com.SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection Connec() throws SQLException {
        String url = "jdbc:derby:database;create=true";
        Connection connection = DriverManager.getConnection(url);
        return connection;
    }
}
