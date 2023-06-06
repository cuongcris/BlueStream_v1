/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CommentDAO;
import dao.MovieDAO;
import entity.Account;
import entity.Comment;
import entity.Episodes;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class addCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        String epID = cmDAO.getEpsID(movieID, epNum);

        ArrayList<Comment> list = (ArrayList<Comment>) cmDAO.GetlistComment(epID);
        req.setAttribute("list", list);

        //get eps
        Episodes episode = dao.getEpisodes(movieID, epNum);
        req.setAttribute("episode", episode);

        //add Comment
        String commentContent = req.getParameter("content");

        Account a = (Account) session.getAttribute("account");
        if (a != null) {
            String accountID = a.getUserID();
            cmDAO.addcomment(epID, accountID, commentContent);

        }
        
        req.setAttribute("commentList", cmDAO.GetlistComment(epID));

        req.setAttribute("totalEp", dao.getEpisodeCountByMovieId(movieID));
        req.getRequestDispatcher("WatchingAnime.jsp").forward(req, resp);
        
        
        //Xin chao
    }
   
   

}
