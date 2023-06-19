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

/**
 *
 * @author ADMIN
 */
public class CheckOTPChangePass extends HttpServlet {

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
            out.println("<title>Servlet CheckOTPChangePass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOTPChangePass at " + request.getContextPath() + "</h1>");
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

        if (otp_send.equals(otp_get)) {
            
            String pass = (String) session.getAttribute("newPass");
            String username = (String) session.getAttribute("username");

            AccountDAO dao = new AccountDAO();
            
            dao.updatePass(username, pass);

            Account a = dao.CheckLogin(username, pass);

            session.setAttribute("account", a);

            request.setAttribute("finish_messe", "<div class=\"col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-12 col-xs-12 finish_mess\">\n"
                            + "                                    <Center>\n"
                            + "                                        <h4>Change Password successfully!!</h4>\n"
                            + "                                    </Center>\n"
                            + "                                </div>");

                    request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        }else{
            request.setAttribute("error_Code", "<div class=\"error-text\">Error!!Wrong OTP code.</div>");
            request.getRequestDispatcher("CheckOTP.jsp").forward(request, response);
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
