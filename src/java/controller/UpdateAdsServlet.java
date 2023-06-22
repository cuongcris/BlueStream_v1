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
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class UpdateAdsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String update_id = req.getParameter("update_id");
        AdsDao dao = new AdsDao();
        req.setAttribute("ads_update", dao.getAdsByID(update_id));
        req.getRequestDispatcher("UpdateADS.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adsId_get = req.getParameter("adsID");
        String ownerEmail_get = req.getParameter("adsEmail");
        String adsType_get = req.getParameter("adsType");
        int adsPrice_get = Integer.parseInt(req.getParameter("adsPrice"));
        String linkTo_get = req.getParameter("linkTo");
        String linkShow_get = req.getParameter("linkShow");
        String DayStart = req.getParameter("DayStart");
        String DayEnd = req.getParameter("DayEnd");
        
         try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date startDateUtil = dateFormat.parse(DayStart);
            java.util.Date endDateUtil = dateFormat.parse(DayEnd);

            Date startDate = new Date(startDateUtil.getTime());
            Date endDate = new Date(endDateUtil.getTime());

            Advertisement ads = new Advertisement(adsId_get, ownerEmail_get, adsType_get, adsPrice_get, linkTo_get, linkShow_get, startDate, endDate);
            AdsDao dao = new AdsDao();

            boolean UpdateResult =  dao.updateAds(ads);
            
            HttpSession sess = req.getSession();
            if (UpdateResult == true) {
                sess.setAttribute("errorUpdate", "        <script type=\"text/javascript\">       \n"
                        + "            alert(\"Update successfully!!\");\n"
                        + "        </script>");
            } else {
                sess.setAttribute("errorUpdate", "        <script type=\"text/javascript\">       \n"
                        + "            alert(\"Error dayStart and dayEnd\");\n"
                        + "        </script>");
            }
            
            resp.sendRedirect("adsList");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    
        
}
