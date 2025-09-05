package com.multi.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/boarddb";
    private static final String USER = "jdbctest";
    private static final String PASSWORD = "jdbctest";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
