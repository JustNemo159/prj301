/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import java.sql.*;
import java.util.Vector;
import model.Categories;

public class CategoryDAO extends DBContext {

    public Vector<Categories> getAllCategories(String sql) {
        Vector<Categories> vector = new Vector<>();
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Categories c = new Categories();
                c.setCategoryID(rs.getString("categoryID"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setDescribe(rs.getString("describe"));
                
                vector.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        CategoryDAO cDAO = new CategoryDAO();
        String sql = "SELECT * FROM [dbo].[tblCategories]";
        Vector<Categories> vector = cDAO.getAllCategories(sql);
        for (Categories c : vector) {
            System.out.println(c);
        }
    }
}