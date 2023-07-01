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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class EditEpisodesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MovieDAO dao = new MovieDAO();
        String id = request.getParameter("mid");
        Movie detail = dao.getMovieById(id);
        Episodes episodes = dao.getEpisodes(id, 0);

        try {
            int nextEpNum = dao.getEpisodeCountByMovieId(id);
            System.out.println(nextEpNum);
            request.setAttribute("nextEp", nextEpNum);
        } catch (Exception ex) {
            Logger.getLogger(EditEpisodesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("detail", detail);
        request.getRequestDispatcher("./admin/EditEpisodes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String movieId = request.getParameter("movieId");
        String epNum = request.getParameter("epNum");
        int epNumCast = Integer.parseInt(epNum);
        String duration = request.getParameter("duration");
        int durationCast = Integer.parseInt(duration);
        String movieLink = request.getParameter("movieLink");

        MovieDAO dao = new MovieDAO();

        dao.updateEpisodes(movieId, epNumCast, durationCast, movieLink);
        response.sendRedirect("MovieManagement");
    }

}
