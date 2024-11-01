/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import context.EmployeeDAO;
import entity.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EmployeeController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet EmployeeController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String searchName = req.getParameter("searchName"); // Lấy tham số tìm kiếm
        EmployeeDAO eDao = new EmployeeDAO();

        // Kiểm tra hành động (edit hoặc delete)
        if ("edit".equals(action)) {
            // Chuyển tiếp đến form chỉnh sửa
            int employeeID = Integer.parseInt(req.getParameter("id"));
            Employee employee = eDao.getById(employeeID);
            req.setAttribute("employee", employee);
            req.getRequestDispatcher("EditEmployee.jsp").forward(req, resp);
             req.getRequestDispatcher("AddEmployee.jsp").forward(req, resp);

        } else if ("delete".equals(action)) {
            // Xóa công nhân theo ID
            int employeeID = Integer.parseInt(req.getParameter("id"));
            eDao.delete(employeeID);
            resp.sendRedirect("employee"); // Tải lại trang sau khi xóa

        } else {
            // Mặc định: hiển thị danh sách công nhân
            List<Employee> eList;

            if (searchName != null && !searchName.trim().isEmpty()) {
                // Nếu có tham số tìm kiếm, gọi phương thức tìm kiếm
                eList = eDao.searchEmployeesByName(searchName);
            } else {
                // Nếu không có tham số tìm kiếm, lấy tất cả công nhân
                eList = eDao.getAll();
            }

            req.setAttribute("eList", eList);
            req.getRequestDispatcher("employee.jsp").forward(req, resp);
        }
    }

    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    EmployeeDAO eDao = new EmployeeDAO();

    if ("add".equals(action)) {
        // Xử lý thêm nhân viên mới
        String employeeName = req.getParameter("name");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        String address = req.getParameter("address");
        String dob = req.getParameter("dob");
        int roleID = Integer.parseInt(req.getParameter("roleID"));
        int departmentID = Integer.parseInt(req.getParameter("departmentID"));
        long salary = Long.parseLong(req.getParameter("salary"));

        // Tạo đối tượng Employee mới
        Employee newEmployee = new Employee(0, employeeName, gender, address, dob, roleID, departmentID, salary);

        // Thêm nhân viên mới vào database
        eDao.add(newEmployee);

        // Chuyển hướng về trang danh sách nhân viên
        resp.sendRedirect("employee");
        
    } else if ("edit".equals(action)) {
        // Xử lý cập nhật thông tin nhân viên
        int employeeID = Integer.parseInt(req.getParameter("id"));
        String employeeName = req.getParameter("name");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        String address = req.getParameter("address");
        String dob = req.getParameter("dob");
        long salary = Long.parseLong(req.getParameter("salary"));

        // Lấy RoleID và DepartmentID hiện tại từ cơ sở dữ liệu
        Employee currentEmployee = eDao.getById(employeeID);
        int roleID = currentEmployee.getRoleID();
        int departmentID = currentEmployee.getDepartmentID();

        // Tạo đối tượng Employee với các thông tin đã cập nhật
        Employee updatedEmployee = new Employee(employeeID, employeeName, gender, address, dob, roleID, departmentID, salary);

        // Thực hiện cập nhật
        eDao.update(updatedEmployee);

        // Chuyển hướng về trang danh sách công nhân sau khi cập nhật thành công
        resp.sendRedirect("employee");
    } else {
        // Xử lý trường hợp không có action hoặc action không hợp lệ
        resp.sendRedirect("employee");
    }
}
}

