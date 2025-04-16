/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void addUser (User user) throws SQLException {
        String sql = "INSERT INTO tblUsers (userID, fullName, password, roleID, address, phone, email, activate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getUserID());
            stmt.setString(2, user.getFullName());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getRoleID());
            stmt.setString(5, user.getAddress());
            stmt.setString(6, user.getPhone());
            stmt.setString(7, user.getEmail());
            stmt.setBoolean(8, user.isActivate());
            stmt.executeUpdate();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM tblUsers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getString("userID"));
                user.setFullName(rs.getString("fullName"));
                user.setPassword(rs.getString("password"));
                user.setRoleID(rs.getInt("roleID"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setActivate(rs.getBoolean("activate"));
                users.add(user);
            }
        }
        return users;
    }
    
}
