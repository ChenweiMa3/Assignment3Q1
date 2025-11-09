package com.example.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection
 * ------------------
 * Provides a single method to connect to the PostgreSQL database.
 * Update the URL, USER, and PASSWORD as needed for your environment.
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    /**
     * Establishes and returns a new connection to the database.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
