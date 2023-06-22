/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AdsDao;
import entity.Advertisement;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class AddAdsServlet extends HttpServlet {

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
            out.println("<title>Servlet AddAdsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddAdsServlet at " + request.getContextPath() + "</h1>");
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
        String adsID = request.getParameter("adsID");
        String adsEmail = request.getParameter("adsEmail");
        String adsType = request.getParameter("adsType");
        int adsPrice = Integer.parseInt(request.getParameter("adsPrice"));
        String linkTo = request.getParameter("linkTo");
        String linkShow = request.getParameter("linkShow");
        String DayStart = request.getParameter("DayStart");
        String DayEnd = request.getParameter("DayEnd");

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date startDateUtil = dateFormat.parse(DayStart);
            java.util.Date endDateUtil = dateFormat.parse(DayEnd);

            Date startDate = new Date(startDateUtil.getTime());
            Date endDate = new Date(endDateUtil.getTime());

            Advertisement ads = new Advertisement(adsID, adsEmail, adsType, adsPrice, linkTo, linkShow, startDate, endDate);
            AdsDao dao = new AdsDao();

            boolean addNewResult = dao.addNewAds(ads);

            if (addNewResult == true) {
                request.setAttribute("errorMessage", "        <script type=\"text/javascript\">       \n"
                        + "            alert(\"Add successfully!!\");\n"
                        + "        </script>");
            } else {
                request.setAttribute("errorMessage", "        <script type=\"text/javascript\">       \n"
                        + "            alert(\"Error dayStart and dayEnd\");\n"
                        + "        </script>");
            }

            request.getRequestDispatcher("AddAds.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
