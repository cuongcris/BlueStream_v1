/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CommentDAO;
import entity.Comment;
import dao.MovieDAO;
import entity.Account;
import entity.Episodes;
import entity.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class WatchAnime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
        HttpSession session = req.getSession(true);
        
        MovieDAO dao = new MovieDAO();
        CommentDAO cmDAO = new CommentDAO();
        //get param
        String movieID = req.getParameter("id");
        String epNumString = req.getParameter("epNum");
        
        
        int epNum = Integer.parseInt(epNumString);
        req.setAttribute("epNumShow", epNum);


        //set sesion
        session.setAttribute("epNum", epNum);
        session.setAttribute("movieID", movieID);

        //list comment
        //get eps
        Episodes episode = dao.getEpisodes(movieID, epNum);
        req.setAttribute("episode", episode);

        //add Comment
        String commentContent = req.getParameter("content");

//        Account a = (Account) session.getAttribute("account");
//        if (a != null) {
//            String accountID = a.getUserID();
        String epID = cmDAO.getEpsID(movieID, epNum);

        ArrayList<Comment> list = (ArrayList<Comment>) cmDAO.GetlistComment(epID);
        req.setAttribute("list", list);

//            cmDAO.addcomment(epID, accountID, commentContent);
//
//        }
        
        req.setAttribute("commentList", cmDAO.GetlistComment(epID));

        req.setAttribute("totalEp", dao.getEpisodeCountByMovieId(movieID));
        req.getRequestDispatcher("WatchingAnime.jsp").forward(req, resp);

    }

}
