/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import dao.AdsDao;
import entity.Advertisement;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class AddAdsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./admin/AddAds.jsp").forward(request, response);
    }

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
            HttpSession sess = request.getSession();
            if (addNewResult == true) {
                sess.setAttribute("errorMessage", "        <script type=\"text/javascript\">       \n"
                        + "            alert(\"Add successfully!!\");\n"
                        + "        </script>");
            } else {
                sess.setAttribute("errorMessage", "        <script type=\"text/javascript\">       \n"
                        + "            alert(\"Error dayStart and dayEnd\");\n"
                        + "        </script>");
            }

            response.sendRedirect("AdsList");
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
