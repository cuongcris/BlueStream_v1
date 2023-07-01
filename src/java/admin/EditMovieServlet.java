/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import dao.MovieDAO;
import entity.Episodes;
import entity.Movie;
import java.io.IOException;
import java.io.PrintWriter;
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
public class EditMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("mid");
        String epNumString = request.getParameter("epNum");
        int epNum = 0;
        if (epNumString != null) {
            try {
                epNum = Integer.parseInt(epNumString);
            } catch (NumberFormatException e) {
                System.out.println("loi r" + e);
            }
        }
        MovieDAO dao = new MovieDAO();
        Episodes episode = dao.getEpisodes(id, epNum);
        Movie detail = dao.getMovieById(id);

        request.setAttribute("episode", episode);
        try {
            request.setAttribute("totalEp", dao.getEpisodeCountByMovieId(id));
            System.out.println(dao.getEpisodeCountByMovieId(id));
        } catch (Exception ex) {
            Logger.getLogger(EditMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("detail", detail);
        request.getRequestDispatcher("./admin/EditMovie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mId = request.getParameter("movieID");
        String mName = request.getParameter("movieName");
        String mDescription = request.getParameter("description");
        String mCategoryMain = request.getParameter("mainCategory");
        String mCategorySub = request.getParameter("subCategory");
        String strSplit = mCategoryMain + "," + mCategorySub;
        ArrayList<String> strCategory = new ArrayList<String>(Arrays.asList(strSplit));
        Boolean mLicense = (request.getParameter("license")).equals("0") ? false : true;
        String mMovieBanner = request.getParameter("movieBanner");

        String mreleasedate = request.getParameter("releaseDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = dateFormat.parse(mreleasedate);
        } catch (ParseException ex) {
            Logger.getLogger(EditMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date releaseDate;
//        Date date;
//        try {
//            date = (Date) dateFormat.parse(mreleasedate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return;
//        }
        releaseDate = new java.sql.Date(utilDate.getTime());

        String mAuthor = request.getParameter("author");
        Boolean mMoviestatus = (request.getParameter("movieStatus")).equals("0") ? false : true;
        
        String mMovieSeason = request.getParameter("movieSeason");
        MovieDAO dao = new MovieDAO();
        try {
            dao.updateMovie(mId, mName, mMovieBanner, mDescription, releaseDate, strCategory, mAuthor, mMoviestatus, mMovieSeason, mLicense);
            response.sendRedirect("MovieManagement");
        } catch (ParseException ex) {
            Logger.getLogger(EditMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
