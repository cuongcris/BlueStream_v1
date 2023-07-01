/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import entity.OTP;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String pass_confirm = request.getParameter("pass_confirm");

        AccountDAO ac = new AccountDAO();

        if (ac.checkEmailExist(email) == false) {
            request.setAttribute("error_email", "<div class=\"error-text\">Email are exist!!</div>");
            request.setAttribute("user_input", userName);
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        } 
        
        else if(ac.checkAccountExits(userName) == false){
            request.setAttribute("error_username", "<div class=\"error-text\">Username are exist!!</div>");
            request.setAttribute("email_input", email);
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
        
        else {
            if (pass.equals(pass_confirm) == false) {
                request.setAttribute("error_pass", "<div class=\"error-text\">Password and Confirm password are different</div>");
                request.setAttribute("user_input", userName);
                request.setAttribute("email_input", email);
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            } else {
                OTP otp = new OTP();
                String otp_send = otp.getOTP();

                SendMail sm = new SendMail();
                sm.sendMailOTP(email, otp_send);

                HttpSession session = request.getSession();
                session.setAttribute("otp_session", otp_send);
                session.setAttribute("email_session", email);
                session.setAttribute("username_session", userName);
                session.setAttribute("pass_session", pass);
                session.setAttribute("action", "signUp");
                request.getRequestDispatcher("CheckOTP.jsp").forward(request, response);
            }
        }

    }
}
