package com.register.core;

import java.sql.*;
import java.util.List;

public class DatabasePersistence {

    String url = "jdbc:mysql://localhost:3306/registerdb";
    String user = "root";
    String password = "root";

    Connection conn = DriverManager.getConnection(url, user, password);


    int registerUser(UserEntity user) throws SQLException {
        String query = "INSERT INTO user_entity (email, firstname, password, profession, lastname, username) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getFirstname());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getProfession());
        statement.setString(5, user.getLastname());
        statement.setString(6, user.getUsername());
        return statement.executeUpdate(query);
    }

    boolean getUserByEmailOrUsername(String data) throws SQLException {
        String query = "SELECT * FROM user_entity where username=? or email=?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, data);
        statement.setString(2, data);
        ResultSet rs = statement.executeQuery(query);
        return rs.next();
    }


    public DatabasePersistence() throws SQLException {
    }
}
