package com.SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Retrive {
    public static void Retrive_data() throws SQLException {
        DBConnect.Connec();
        try {
            Connection connection = DBConnect.Connec();
            Statement statement = connection.createStatement();
            System.out.println("Enter Yourname to Retrive Data: ");
            Scanner input = new Scanner(System.in);
            String table_name = input.next();
            System.out.println("<==================================================>");
            String select = "Select * from " + table_name.toUpperCase();
            statement.executeQuery(select);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("marks"));
                System.out.println(resultSet.getDouble("age"));
                System.out.println(resultSet.getString("dob"));
            }
            input.close();
        } catch (SQLException e) {
            System.out.println("Table Not Exists:! Please Create Your Table: Through Create.java");
        }
    }
}
