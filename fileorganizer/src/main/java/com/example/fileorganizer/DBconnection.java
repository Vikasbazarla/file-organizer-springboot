package com.example.fileorganizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/fileorganizerdb"; // replace with your DB name
        String username = "root"; // replace with your DB username
        String password = "@Got7781"; // replace with your DB password

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("✅ Connection to MySQL successful!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}
