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

/**
 *
 * @author ADMIN
 */
public class ChangePassServlet extends HttpServlet {

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
            out.println("<title>Servlet ChangePassServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePassServlet at " + request.getContextPath() + "</h1>");
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

        try {
            Encode en = new Encode();
            String cur_pass = en.encode(request.getParameter("cur_pass"));
            String new_pass = request.getParameter("new_pass");
            String new_pass1 = request.getParameter("new_pass1");

            Account ac = new Account();
            HttpSession session = request.getSession();
            ac = (Account) session.getAttribute("account");
            String old_pass_sess = ac.getPassword();
            String username = ac.getUserName();

            if (cur_pass.equals(old_pass_sess) == false) {
                request.setAttribute("error_mess1", "<div class=\"Error\">\n"
                        + "                                                    <p>Wrong current Password</p>\n"
                        + "                                                </div>");
                request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
            } else {
                if (new_pass.equals(new_pass1) == false) {
                    request.setAttribute("error_mess", "<div class=\"Error\">\n"
                            + "                                                    <p>New Password and Confirm Password are different!!</p>\n"
                            + "                                                </div>");
                    request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
                } else {
                    String email = ac.getEmail();

                    OTP otp = new OTP();
                    String otp_send = otp.getOTP();

                    SendMail sm = new SendMail();
                    sm.sendMailOTP(email, otp_send);

                    String pass_encode = en.encode(new_pass);
                    session.setAttribute("otp_session", otp_send);
                    session.setAttribute("newPass", pass_encode);
                    session.setAttribute("username", username);

                    request.getRequestDispatcher("CheckOTPChangePass.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {

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
