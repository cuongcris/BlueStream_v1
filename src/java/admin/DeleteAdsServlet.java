/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import dao.AdsDao;
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
public class DeleteAdsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_del = req.getParameter("del_id");
        AdsDao dao = new AdsDao();
        dao.deleteAds(id_del);
        HttpSession sess = req.getSession();
        sess.setAttribute("deleteMess", "        <script type=\"text/javascript\">       \n"
                        + "            alert(\"Delete successfully!!\");\n"
                        + "        </script>");
        resp.sendRedirect("AdsList");
    }

}
