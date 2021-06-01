package com.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {
    public static void update_table() {
        try {
            Connection connection = DBConnect.Connec();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Your TableName for Update: ");
            String table_name = input.next();
            System.out.println("Enter Your Marks For Identification: ");
            String valid_marks = input.next();
            String Query = "update " + table_name.toUpperCase() + " set username=?, dob=?,marks=? WHERE marks="
            + valid_marks.toLowerCase();
            System.out.println(Query);
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            System.out.println("Enter New Username to Add in the DataBase of " + table_name);
            String username = input.next();
            System.out.println("Enter Your Date of Birth: ");
            String dob = input.next();
            System.out.println("Enter Your marks: ");
            int marks = input.nextInt();
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, dob);
            preparedStatement.setInt(3, marks);
            if (!preparedStatement.execute()) {
                System.out.println("Done!");
            } else {
                System.out.println("Something Wrong");
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}