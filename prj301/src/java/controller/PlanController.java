/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import context.PlanDAO;
import entity.Plan;
import java.io.IOException;
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
@WebServlet(name="PlanController", urlPatterns={"/plan"})
public class PlanController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String searchName = req.getParameter("searchName"); // Lấy tham số tìm kiếm
        PlanDAO pDao = new PlanDAO();

        // Kiểm tra hành động (edit hoặc delete)
        if ("edit".equals(action)) {
            // Chuyển tiếp đến form chỉnh sửa
            int planID = Integer.parseInt(req.getParameter("id"));
            Plan plan = pDao.getById(planID);
            req.setAttribute("plan", plan);
            req.getRequestDispatcher("editPlan.jsp").forward(req, resp);

        } else if ("delete".equals(action)) {
            // Xóa plan theo ID
            int planID = Integer.parseInt(req.getParameter("id"));
            pDao.delete(planID);
            resp.sendRedirect("plan"); // Tải lại trang sau khi xóa

        } else if ("add".equals(action)) {
            Plan plan = new Plan();
            req.setAttribute("plan", plan);
            req.getRequestDispatcher("editPlan.jsp").forward(req, resp);

        } else {
            // hiển thị danh sách plan
            List<Plan> pList;

            if (searchName != null && !searchName.trim().isEmpty()) {
                // Nếu có tham số tìm kiếm, gọi phương thức tìm kiếm
                pList = pDao.searchPlansByName(searchName);
            } else {
                // Nếu không có tham số tìm kiếm, lấy tất cả kế hoạch
                pList = pDao.getAll();
            }

            req.setAttribute("pList", pList);
            req.getRequestDispatcher("Plan.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy các thông tin cần cập nhật từ request
        int planID = Integer.parseInt(req.getParameter("id"));
        String planName = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        // Lấy DepartmentID hiện tại từ cơ sở dữ liệu
        PlanDAO pDao = new PlanDAO();
        Plan currentPlan = pDao.getById(planID);
        int departmentID = currentPlan.getDepartmentID();
        String checkID = String.valueOf(departmentID);
        if(checkID.equals(null)){
            departmentID=1;
        }
        // Tạo đối tượng Plan với các thông tin đã cập nhật
        Plan updatedPlan = new Plan(planID, planName, startDate, endDate, quantity, departmentID);

        // Thực hiện cập nhật
        pDao.update(updatedPlan);

        // Chuyển hướng về trang danh sách kế hoạch sau khi cập nhật thành công
        resp.sendRedirect("plan");
    }
}
