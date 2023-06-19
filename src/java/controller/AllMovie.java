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
public class AllMovie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDAO dao = new MovieDAO();
        List<Movie> list = dao.getAllMovie();
        int size = list.size();

        int totalItems = list.size();
        int itemsPerPage = 9;
        int currentPage = (req.getParameter("page") != null) ? Integer.parseInt(req.getParameter("page")) : 1;
        int offset = (currentPage - 1) * itemsPerPage;

        List<Movie> pageList = list.subList(offset, Math.min(offset + itemsPerPage, totalItems));
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", currentPage);

        req.setAttribute("Category", pageList);
        req.getRequestDispatcher("Categorys.jsp").forward(req, resp);
    }

}
