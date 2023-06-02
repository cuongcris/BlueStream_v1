/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.MovieDAO;
import entity.Episodes;
import entity.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class WatchAnime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDAO dao = new MovieDAO();
        String movieID = req.getParameter("id");
        String epNumString = req.getParameter("epNum");
        int epNum = Integer.parseInt(epNumString);
        Episodes episode = dao.getEpisodes(movieID,epNum);
        req.setAttribute("epNumShow", epNum);
        req.setAttribute("episode", episode);
        req.setAttribute("totalEp", dao.getEpisodeCountByMovieId(movieID));
        req.getRequestDispatcher("WatchingAnime.jsp").forward(req, resp);
    
    }
  
   

}
