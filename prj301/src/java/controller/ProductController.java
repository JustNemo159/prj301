/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.ProductDAO;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ProductController", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO pdao = new ProductDAO();

        String action = req.getParameter("action");
        String searchName = req.getParameter("searchName"); // Lấy tham số tìm kiếm

        // Kiểm tra hành động (edit hoặc delete)
        if ("edit".equals(action)) {
            // Chuyển tiếp đến form chỉnh sửa
            int productId = Integer.parseInt(req.getParameter("id"));
            Product product = pdao.getById(productId);
            req.setAttribute("product", product); // Sửa tên thuộc tính thành "product"
            req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);

        } else if ("delete".equals(action)) {
            // Xóa sản phẩm theo ID
            int productId = Integer.parseInt(req.getParameter("id"));
            pdao.delete(productId);
            resp.sendRedirect("product"); // Tải lại trang sau khi xóa

        } else {
            // Mặc định: hiển thị danh sách sản phẩm
            List<Product> pList;

            if (searchName != null && !searchName.trim().isEmpty()) {
                // Nếu có tham số tìm kiếm, gọi phương thức tìm kiếm
                pList = pdao.searchProdcutByName(searchName);
            } else {
                // Nếu không có tham số tìm kiếm, lấy tất cả sản phẩm
                pList = pdao.getAll();
            }

            req.setAttribute("pList", pList);
            req.getRequestDispatcher("products.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy các thông tin cần cập nhật từ request
        int productId = Integer.parseInt(req.getParameter("id"));
        String productName = req.getParameter("name");

        // Tạo đối tượng Product với các thông tin đã cập nhật
        Product updatedProduct = new Product(productId, productName);

        // Thực hiện cập nhật
        ProductDAO pdao = new ProductDAO();
        pdao.update(updatedProduct);

        // Chuyển hướng về trang danh sách sản phẩm sau khi cập nhật thành công
        resp.sendRedirect("product");
    }
}
