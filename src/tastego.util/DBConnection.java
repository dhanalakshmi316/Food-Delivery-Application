package com.tastego.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/tastego";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";   // Change to your MySQL password

    private static Connection connection;

    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(
                        URL,
                        USERNAME,
                        PASSWORD
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;

    }

}
