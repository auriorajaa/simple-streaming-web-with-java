package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

    private final String dbUrl = "jdbc:mysql://localhost:3307/moviex_db";
    private final String dbUname = "root";
    private final String dbPass = "";
    private final String dbDriver = "com.mysql.cj.jdbc.Driver";

    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUname, dbPass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

    public String insert(Member member) {
        loadDriver(dbDriver);
        Connection con = getConnection();

        String result = "Data entered successfully";
        String userSql = "INSERT INTO tbl_users (email, username, password) VALUES (?, ?, ?)";
        String subscriptionSql = "INSERT INTO tbl_subs (user_email, type_subs) VALUES (?, ?)";

        try (PreparedStatement psUser = con.prepareStatement(userSql);
             PreparedStatement psSubscription = con.prepareStatement(subscriptionSql)) {
            // Insert user data
            psUser.setString(1, member.getEmail());
            psUser.setString(2, member.getUname());
            psUser.setString(3, member.getPassword());
            int rowsAffected = psUser.executeUpdate();

            // If user data inserted successfully, insert subscription data
            if (rowsAffected > 0) {
                psSubscription.setString(1, member.getEmail()); // Use user's email as foreign key
                psSubscription.setString(2, member.getSubscription());
                psSubscription.executeUpdate();
            } else {
                result = "Data not entered";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Data not entered";
        }

        return result;
    }


}
