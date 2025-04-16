/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Vector;
import model.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext {

    public Vector<Products> getAllProduct(String sql) {
        Vector<Products> vector = new Vector<>();
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategoryID(rs.getString("categoryID"));
                p.setImportDate(rs.getDate("importDate"));
                p.setUsingDate(rs.getDate("usingDate"));
                p.setStatus(rs.getInt("status"));
          
                vector.add(p);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return vector;
    }

   
public int insertProduct(Products p) {
        String sql = "INSERT INTO [dbo].[tblProducts]\n"
                + "           ([productName]\n"
                + "           ,[image]\n"
                + "           ,[price]\n"
                + "           ,[quantity]\n"
                + "           ,[categoryID]\n"
                + "           ,[importDate]\n"
                + "           ,[usingDate]\n"
                + "           ,[status])\n"
                + "     VALUES(?,?,?,?,?,?,?,?)";

        int n = 0;
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, p.getProductName());
            ptm.setString(2, p.getImage());
            ptm.setDouble(3, p.getPrice());
            ptm.setInt(4, p.getQuantity());
            ptm.setString(5, p.getCategoryID());
            ptm.setDate(6, p.getImportDate());
            ptm.setDate(7, p.getUsingDate());
            ptm.setInt(8, p.getStatus());
            n = ptm.executeUpdate();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return n;
    }
 public static void main(String[] args) {
        ProductDAO pDAO = new ProductDAO();
        String sql = "SELECT *\n"
                + "  FROM [dbo].[tblProducts]";
        pDAO.getAllProduct(sql);
        Vector<Products> vector = pDAO.getAllProduct(sql);
        for (Products p : vector) {
            System.out.println(p);
        }
    }
}
