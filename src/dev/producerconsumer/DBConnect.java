package dev.producerconsumer;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {


    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
        return conn;
    }

}