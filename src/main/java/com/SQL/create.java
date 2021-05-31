package com.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class create {
    public static void create_table() throws SQLException {
        DBConnect.Connec();
        try {
            Connection connection = DBConnect.Connec();
            Statement statement = connection.createStatement();
            System.out.println("Enter Yourname for Creating Table");
            Scanner input = new Scanner(System.in);
            String table_name = input.next();
            /*
             * For Integer we don't give upto ...for double we use decimal like decimal(3)
             */
            String create_table = "CREATE TABLE " + table_name.toUpperCase()
                    + "(username varchar(20) PRIMARY KEY,marks integer, age decimal(4))";
            statement.executeUpdate(create_table);
            Thread.sleep(500);
            System.out.println(table_name + " table added sucessfully");
            String create_insert = "insert into " + table_name.toUpperCase() + " values(?,?,?)";
            System.out.println("Enter Your Name to Add!: ");
            PreparedStatement preparedStatement = connection.prepareStatement(create_insert);
            String USERNAME = input.next();
            preparedStatement.setString(1, USERNAME);
            System.out.println("Enter Your Marks to Add!: ");
            int MARKS = input.nextInt();
            preparedStatement.setInt(2, MARKS);
            System.out.println("Enter Your Age: ");
            double AGE = input.nextDouble();
            preparedStatement.setDouble(3, AGE);
            preparedStatement.executeUpdate();
            System.out.println("Added Your Name");
            System.out.println("<==================================================>");
            Thread.sleep(500);
            String select = "Select * from " + table_name.toUpperCase();
            statement.executeQuery(select);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("marks"));
                System.out.println(resultSet.getDouble("age"));
            }
            input.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
