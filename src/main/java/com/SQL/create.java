package com.SQL;

import java.sql.Connection;
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
            // For Integer we don't give upto ...for double we use decimal like decimal(3)
            String create_table = "CREATE TABLE " + table_name.toUpperCase()
                    + "(USERNAME varchar(20) PRIMARY KEY,MARKS integer, AGE decimal(4), DOB varchar(13) not null )";
            statement.executeUpdate(create_table);
            Thread.sleep(500);
            System.out.println(table_name + " table added sucessfully");
            input.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
