package org.sber.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String PASS = "postgres";
    public static final String USER = "postgres";

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
