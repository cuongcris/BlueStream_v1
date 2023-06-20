/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import entity.Account;
import entity.OTP;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ForgotPassServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ForgotPassServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPassServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AccountDAO dao = new AccountDAO();
        Encode en = new Encode();

        String email_get = request.getParameter("email");

        if (dao.checkEmailExist(email_get) == true) {
            request.setAttribute("error_email", "<div class=\"Error\">\n"
                    + "                                                    <p>Email are not valid in this system!!</p>\n"
                    + "                                                </div>");
            request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
        } else {
            String newPass = request.getParameter("newpassword");
            String newPassConfirm = request.getParameter("pass_confirm");

            if (newPass.equals(newPassConfirm) == false) {
                request.setAttribute("error_pass", "<div class=\"Error\">\n"
                        + "                                                    <p>New Password and Confirm Password are different!!</p>\n"
                        + "                                                </div>");
                request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
            } else {
                try {
                    OTP otp = new OTP();
                    String otp_send = otp.getOTP();
                    
                    SendMail sm = new SendMail();
                    sm.sendMailOTP(email_get, otp_send);
                    
                    HttpSession session = request.getSession();
                    
                    session.setAttribute("otp_session", otp_send);
                    session.setAttribute("email_session", email_get);
                    session.setAttribute("pass_session", en.encode(newPass));
                    session.setAttribute("action", "resetPass");
                    
                    request.getRequestDispatcher("CheckOTP.jsp").forward(request, response);
                    
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(ForgotPassServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
