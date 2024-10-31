/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext implements IDAO<Product> {
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from [Product]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product u = new Product(rs.getInt(1),
                        rs.getString(2)
                        );
                products.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void add(Product product) {
        String sql="INSERT INTO [Product] VALUES (?,?)";
        try{
            PreparedStatement st= connection.prepareStatement(sql);
            st.setInt(1, product.getProductId());
            st.setString(2, product.getProductName());
            st.execute();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
    String sql="UPDATE [Product] SET [ProductName] = ? WHERE [ProductId] = ?";
    try{
        PreparedStatement st= connection.prepareStatement(sql);
        st.setString(1, product.getProductName());
        st.setInt(2, product.getProductId());
        st.execute();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    @Override
    public void delete(int id) {
    String sql="DELETE FROM [Product] WHERE [ProductId] = ?";
    try{
        PreparedStatement st= connection.prepareStatement(sql);
        st.setInt(1, id);
        st.execute();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    @Override
    public Product getById(int id) {
        String sql = "select * from [Product] where ProductID=?";
        Product product = null;
        try{
            PreparedStatement st= connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
    public List<Product> searchProdcutByName(String name) {
        List<Product> result = new ArrayList<>();
        String query = "SELECT * FROM [Product] WHERE ProductName LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "%" + name + "%"); // Tìm kiếm theo tên
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product employee = new Product();
                employee.setProductId(rs.getInt("ProductID"));
                employee.setProductName(rs.getString("ProductName"));
                result.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
