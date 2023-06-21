/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.MovieDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        
        req.getRequestDispatcher("DetailAnime.jsp").forward(req, resp);
    }
    
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       MovieDAO dao =new MovieDAO();
       PrintWriter pw = resp.getWriter();
       String movieID = req.getParameter("id");
        HttpSession session = req.getSession();
        Account acc = (Account) session.getAttribute("account");
        if(dao.checkFavorite(acc.getUserID(), movieID)==true){
            pw.print("   <div id=\"success-message\" style=\" position: fixed;\n" +
"                     top: 20px;\n" +
"                     right: 20px;\n" +
"                     padding: 10px;\n" +
"                     background-color: #42b983;\n" +
"                     color: #fff;\n" +
"                     display: none;\" class=\"notification\">You have already save this anime</div>");
        }else
            dao.SaveFavorite(acc.getUserID(), movieID);
        doGet(req, resp);
    }
   
   
}
