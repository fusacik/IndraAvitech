package dev.producerconsumer;

import java.sql.Connection;

import java.sql.*;

public class SQLiteManagement {
    public static void createTable(String tablename) {
        Connection con = DBConnect.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE "    +     tablename   +
                    "(USER_ID INT PRIMARY KEY      NOT NULL," +
                    "USER_GUID TEXT 			   NOT NULL," +
                    "USER_NAME TEXT    		       NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }


    public static void deleteTable(String tablename) {
        Connection con = DBConnect.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "DROP TABLE " + tablename.toUpperCase();
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table droped successfully");
    }

    public static void add(int userId, String userGuid, String userName) {
        Connection con = DBConnect.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO SUSERS (USER_ID,USER_GUID,USER_NAME) " +
                    "VALUES ("+ userId + ",'" + userGuid +"','"+ userName + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Insert was succesfull");
    };


    public static void add(User user) {
        Connection con = DBConnect.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO SUSERS (USER_ID,USER_GUID,USER_NAME) " +
                    "VALUES ("+ user.getUserId() + ",'" + user.getUserGuid() +"','"+ user.getUserName() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Insert was succesfull");
    }

    public static void selectStatement(int id) {
        Connection con = DBConnect.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM SUSERS WHERE USER_ID =" + id + ";" );

            while ( rs.next() ) {
                int userId = rs.getInt("user_id");
                String  userGuid = rs.getString("user_guid");
                String userName  = rs.getString("user_name");

                User user = new User(userId, userGuid, userName);
                System.out.printf( "UserId = %d, UserGuid = %s, userName = %s", user.getUserId(), user.getUserGuid(), user.getUserName());
                System.out.println();
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select was succesfull");
    }

    public static void printAll() {
        Connection con = DBConnect.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM SUSERS;" );

            while ( rs.next() ) {
                int userId = rs.getInt("user_id");
                String userGuid = rs.getString("user_guid");
                String userName  = rs.getString("user_name");

                User user = new User(userId, userGuid, userName);
                System.out.printf( "UserId = %d, UserGuid = %s, userName = %s", user.getUserId(), user.getUserGuid(), user.getUserName());
                System.out.println();
            }
            if (rs.getRow() == 0) {System.out.println("Table is empty");}
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("PrintAll was succesfull");
    }


    public static void deleteAll() {
        Connection con = DBConnect.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String sql = "DELETE from SUSERS";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("DeleteAll was succesfull");
    }


}
