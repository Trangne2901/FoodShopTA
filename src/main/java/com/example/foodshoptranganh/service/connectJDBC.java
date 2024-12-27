package com.example.foodshoptranganh.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/spicynoodles";
    private static final String USER = "root";
    private static final String PASSWORD = "Fangxing38";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không thể tải lớp trình điều khiển JDBC", e);
        }
    }
}
