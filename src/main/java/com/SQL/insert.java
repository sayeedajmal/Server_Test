package com.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insert {
    public static void insert_query() throws SQLException {
        DBConnect.Connec();
        try {
            Connection connection = DBConnect.Connec();
            System.out.println("Enter Yourname for Inserting Record: ");
            Scanner input = new Scanner(System.in);
            String table_name = input.next();
            Thread.sleep(500);
            String create_insert = "insert into " + table_name.toUpperCase() + " values(?,?,?,?)";
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
            System.out.println("Enter Your Date of Birth Date: ");
            /* Data type for Adding Date in SQL */
            String Date = input.next();
            preparedStatement.setString(4, Date);
            preparedStatement.executeUpdate();
            System.out.println("Added Your Name");
            System.out.println("<==================================================>");
            input.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
