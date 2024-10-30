/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import entity.user.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext implements IDAO<User> {
    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<User>();
        String sql = "Select * from User";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            User u = new User(rs.getString("UserName"),
                    rs.getString("password"));
            list.add(u);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void add(User user) {
        String sql = "Insert into User (UserName,password) values (?,?)";
        try {
            PreparedStatement rs = connection.prepareStatement(sql);
            rs.setString(1, user.getUserName());
            rs.setString(2, user.getPassword());
            rs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(User user) {
        String sql = "Update User set password=? where UserName=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getPassword());
            st.setString(2, user.getUserName());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User getById(int id) {
        return null;
    }
    public User getByUserName(String userName) {
        String sql = "Select * from [User] where UserName=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userName);
            ResultSet rs = st.executeQuery();
           if(rs.next()){
               User u=new User();
               u.setUserName(rs.getString("UserName"));
               u.setPassword(rs.getString("password"));
               return u;
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

