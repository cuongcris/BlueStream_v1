/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.MovieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class DetailAnime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDAO dao = new MovieDAO();
        String id = req.getParameter("id");
        
        req.setAttribute("M", dao.getMovieById(id));
        req.setAttribute("totalEp", dao.getEpisodeCountByMovieId(id));
        req.setAttribute("trailerLink", dao.getTrailerByMovieID(id));
        System.out.println( dao.getTrailerByMovieID(id));
        req.getRequestDispatcher("DetailAnime.jsp").forward(req, resp);
    }
   
   
   
}
