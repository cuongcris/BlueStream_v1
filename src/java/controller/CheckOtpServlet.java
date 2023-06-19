/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Admin
 */
public class CheckOtpServlet extends HttpServlet {
   
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter pr = response.getWriter();
        String otp1_get = request.getParameter("otp1");
        String otp2_get = request.getParameter("otp2");
        String otp3_get = request.getParameter("otp3");
        String otp4_get = request.getParameter("otp4");
        String otp5_get = request.getParameter("otp5");
        String otp6_get = request.getParameter("otp6");

        String otp_get = "" + otp1_get + otp2_get + otp3_get + otp4_get + otp5_get + otp6_get;

        HttpSession session = request.getSession();
        String otp_send = (String) session.getAttribute("otp_session");
        String email_session = (String) session.getAttribute("email_session");
        String username_session = (String) session.getAttribute("username_session");
        String pass_session = (String) session.getAttribute("pass_session");
        
        if (otp_get.equals(otp_send)) {
            Encode en = new Encode();
            try {
                String encodePass = en.encode(pass_session);
                Account acc = new Account(username_session, encodePass, email_session, null, null, null, null, 2, null);
                
                AccountDAO ac = new AccountDAO();
                ac.addNewAccount(acc);
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex);
            }
            session.removeAttribute("otp_session");
            session.removeAttribute("email_session");
            session.removeAttribute("username_session");
            session.removeAttribute("pass_session");
            
            request.setAttribute("regis_sucsess", "<h2>Sign Up Success</h2>");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            request.setAttribute("error_Code", "<div class=\"error-text\">Error!!Wrong OTP code.</div>");
            request.getRequestDispatcher("CheckOTP.jsp").forward(request, response);
        }
    }
}
