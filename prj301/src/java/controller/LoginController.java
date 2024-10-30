/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import context.AccountDAO;
import entity.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("c_login.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("c_login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("email");
        String password = req.getParameter("pass");
        String remember = req.getParameter("rem");
        Cookie cu=new Cookie("cuser",username);
        Cookie cp=new Cookie("cpass",password);
        Cookie cr=new Cookie("crem",remember);
        if(remember!=null){
            cu.setMaxAge(60*60*24*7);
            cp.setMaxAge(60*60*24*7);
            cr.setMaxAge(60*60*24*7);
        }else{
            cu.setMaxAge(0);
            cp.setMaxAge(0);
            cr.setMaxAge(0);
        }
        resp.addCookie(cu);
        resp.addCookie(cp);
        resp.addCookie(cr);
        AccountDAO dao = new AccountDAO();
        User loginuser=dao.getByUserName(username);
        if(loginuser==null){
            req.setAttribute("msg","sai tên đăng nhập");
            req.getRequestDispatcher("c_login.jsp").forward(req,resp);
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("account",loginuser);
            resp.sendRedirect("home");

        }
    }
}

