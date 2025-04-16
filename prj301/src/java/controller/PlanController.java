/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import context.PlanDAO;
import entity.Plan;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PlanController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String searchName = req.getParameter("searchName");
        PlanDAO pDao = new PlanDAO();

        // Đọc cookies nếu có
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastPlanInfo")) {
                    // Giải mã thông tin từ cookie và set vào request attribute
                    String[] planInfo = cookie.getValue().split("\\|");
                    if (planInfo.length >= 4) {
                        req.setAttribute("lastPlanName", planInfo[0]);
                        req.setAttribute("lastStartDate", planInfo[1]);
                        req.setAttribute("lastEndDate", planInfo[2]);
                        req.setAttribute("lastQuantity", planInfo[3]);
                    }
                }
            }
        }

        if ("edit".equals(action)) {
            int planID = Integer.parseInt(req.getParameter("id"));
            Plan plan = pDao.getById(planID);
            req.setAttribute("plan", plan);
            req.getRequestDispatcher("editPlan.jsp").forward(req, resp);

        } else if ("delete".equals(action)) {
            int planID = Integer.parseInt(req.getParameter("id"));
            pDao.delete(planID);
            resp.sendRedirect("plan");

        } else if ("add".equals(action)) {
            Plan plan = new Plan();
            req.setAttribute("plan", plan);
            req.getRequestDispatcher("editPlan.jsp").forward(req, resp);

        } else {
            List<Plan> pList;
            if (searchName != null && !searchName.trim().isEmpty()) {
                pList = pDao.searchPlansByName(searchName);
            } else {
                pList = pDao.getAll();
            }
            req.setAttribute("pList", pList);
            req.getRequestDispatcher("Plan.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        PlanDAO pDao = new PlanDAO();

        if ("add".equals(action)) {
            // Lấy các thông tin từ form
            String planName = req.getParameter("name");
            String startDate = req.getParameter("startDate");
            String endDate = req.getParameter("endDate");
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            // Tạo cookie chứa thông tin kế hoạch vừa thêm
            String planInfo = String.format("%s|%s|%s|%d", 
                planName, startDate, endDate, quantity);
            Cookie planCookie = new Cookie("lastPlanInfo", planInfo);
            planCookie.setMaxAge(24 * 60 * 60); // Cookie tồn tại 24 giờ
            resp.addCookie(planCookie);

            // Tạo đối tượng Plan mới và thêm vào database
            Plan newPlan = new Plan();
            newPlan.setPlanName(planName);
            newPlan.setStartDate(startDate);
            newPlan.setEndDate(endDate);
            newPlan.setQuantity(quantity);
            pDao.add(newPlan);

            // Chuyển hướng về dashboard để hiển thị thông tin
            resp.sendRedirect("/plan");

        } else if ("edit".equals(action)) {
            int planID = Integer.parseInt(req.getParameter("id"));
            String planName = req.getParameter("name");
            String startDate = req.getParameter("startDate");
            String endDate = req.getParameter("endDate");
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            Plan updatedPlan = new Plan(planID, planName, startDate, endDate, quantity, 0);
            pDao.update(updatedPlan);
            resp.sendRedirect("plan");
        }
    }
}