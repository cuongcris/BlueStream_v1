/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class LoginControl extends HttpServlet {
   
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = (HttpSession) request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            response.sendRedirect(request.getContextPath());
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String user = request.getParameter("username");
            String pre_endcode_pass = request.getParameter("password");
            
            AccountDAO loginDAO = new AccountDAO();
            
            Encode en = new Encode();
            String pass = en.encode(pre_endcode_pass);
            
            if (!loginDAO.checkUser(user)) {
                request.setAttribute("error", "Account not existed");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }

            Account a = loginDAO.CheckLogin(user, pass);
            
            if (a == null) {
                request.setAttribute("error", "Wrong password");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                Cookie userCookie = new Cookie("name", user);
                Cookie passwordCookie = new Cookie("pass", pass);
                //dat time ton tai
                userCookie.setMaxAge(60 * 60 * 24);
                passwordCookie.setMaxAge(60 * 60 * 24);
                //add browser cua nguoi dung
                response.addCookie(userCookie);
                response.addCookie(passwordCookie);
            }

                HttpSession session = request.getSession();
                session.setAttribute("account", a);
                response.sendRedirect("home");
          
    } catch (Exception e) {
        }
    }
}
