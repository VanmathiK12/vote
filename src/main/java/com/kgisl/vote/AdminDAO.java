package com.kgisl.vote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class AdminDAO {
    private static String jdbcURL;
    private static String jdbcUsername;
    private static String jdbcPassword;
    private Connection jdbcConnection;
    private static AdminDAO adminDAO;
    private AdminDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    public static AdminDAO getInstance(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        if (adminDAO == null) {
            adminDAO = new AdminDAO(jdbcURL, jdbcUsername, jdbcPassword);
        }
        return adminDAO;
    }
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public List<Admin> getAdminEmailPass() throws SQLException {
        String sql = "SELECT email,password FROM admin";
        connect();
        List<Admin> UserList = new ArrayList<Admin>();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String admin_email = resultSet.getString("admin_email");
            String admin_password = resultSet.getString("admin_password");
            Admin admin = new Admin(admin_email, admin_password);
            UserList.add(admin);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return UserList;
    }
    
}
