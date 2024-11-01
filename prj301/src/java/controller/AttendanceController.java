package controller;

import context.AttendanceDAO;
import entity.Attendence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name="AttendanceController", urlPatterns={"/attendance"})
public class AttendanceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        List<Attendence> attendanceList = attendanceDAO.getAll();
        request.setAttribute("attendanceList", attendanceList);
        request.getRequestDispatcher("attendance.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int attendanceId = Integer.parseInt(request.getParameter("attendanceId"));
        int schEmpId = Integer.parseInt(request.getParameter("schEmpId"));
        BigDecimal quantity = new BigDecimal(request.getParameter("quantity"));
        float alpha = Float.parseFloat(request.getParameter("alpha"));

       Attendence attendance = new Attendence(attendanceId, schEmpId, quantity, alpha);
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        attendanceDAO.add(attendance);

        // Lưu alpha vào cookie
        Cookie alphaCookie = new Cookie("alpha", String.valueOf(alpha));
        alphaCookie.setMaxAge(30 * 24 * 60 * 60); // Cookie tồn tại 30 ngày
        response.addCookie(alphaCookie);

        response.sendRedirect("attendance");
    }
}