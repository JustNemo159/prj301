/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.Vector;
import model.Orders;

public class OrderDAO extends DBContext {

    public Vector<Orders> getAllOrders(String sql) {
        Vector<Orders> vector = new Vector<>();
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Orders o = new Orders();
                o.setOrderID(rs.getInt("orderID"));
                o.setOrderDate(rs.getDate("orderDate"));
                o.setTotal(rs.getDouble("total"));
                o.setUserID(rs.getString("userID"));
                
                vector.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        OrderDAO oDAO = new OrderDAO();
        String sql = "SELECT * FROM [dbo].[tblOrders]";
        Vector<Orders> vector = oDAO.getAllOrders(sql);
        for (Orders o : vector) {
            System.out.println(o);
        }
    }
}