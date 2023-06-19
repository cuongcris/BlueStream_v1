/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.MovieDAO;
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
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDAO dao = new MovieDAO();
        req.setAttribute("TrendingMovie",  dao.getAllMovie());
        req.setAttribute("newReleaseMovie",  dao.getListNewReleaseMovie());
        req.setAttribute("popularMovie",  dao.getListPopularMovie());
        req.setAttribute("LiveActionMovie",  dao.getListLiveActionMovie());
        req.setAttribute("randomMovie",  dao.getListRandomMovie());

        req.getRequestDispatcher("Home.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
   
}
