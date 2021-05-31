package com.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insert {
    public static void insert_query() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Your Name to Add Data: ");
            String username = input.next();
            Connection connection = DBConnect.Connec();
            String query = "INSERT INTO " + username.toUpperCase() + " values(sayeed, ajmal )";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.executeQuery().next()) {
                System.out.println("Done...");
            } else {
                System.out.println("not Done");

            }
            input.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
