/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import dao.MovieDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class AddMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("./admin/AddMovie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mid = request.getParameter("movieID");
        String mname = request.getParameter("movieName");
        String mdescription = request.getParameter("description");
        String mcategorymain = request.getParameter("mainCategory");
        String mcategorysub = request.getParameter("subCategory");
        String strSplit = mcategorymain + "," + mcategorysub;
        ArrayList<String> strCategory = new ArrayList<String>(Arrays.asList(strSplit));
        String mlicense = request.getParameter("license");
        Boolean license = Boolean.parseBoolean(mlicense);
        String mimage = request.getParameter("image");

        String mreleasedate = request.getParameter("releaseDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = dateFormat.parse(mreleasedate);
        } catch (ParseException ex) {
            Logger.getLogger(AddMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date releaseDate = new java.sql.Date(utilDate.getTime());
//        Date date;
//        try {
//            date = (Date) dateFormat.parse(mreleasedate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return;
//        }
        String mauthor = request.getParameter("author");
        String mmoviestatus = request.getParameter("movieStatus");
        Boolean moviestatus = Boolean.parseBoolean(mmoviestatus);
        String mmovieSeason = request.getParameter("movieSeason");

        MovieDAO dao = new MovieDAO();
        if (dao.getMovieByIdAdmin(mid) == null) {
            try {
                dao.insertMovie(mid, mname, mimage, mdescription, releaseDate, strCategory, mauthor, moviestatus, mmovieSeason, license);
            } catch (ParseException ex) {
                Logger.getLogger(AddMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("MovieManagement");
        } else {
            request.setAttribute("errorMessage", "        <script type=\"text/javascript\">       \n"
                    + "            alert(\"Movie ID already Exists!!\");\n"
                    + "        </script>");
            doGet(request, response);
        }
    }

}
