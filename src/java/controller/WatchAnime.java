
package controller;

import dao.CommentDAO;
import entity.Comment;
import dao.MovieDAO;
import entity.Episodes;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

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

        String epID = cmDAO.getEpsID(movieID, epNum);

        ArrayList<Comment> list = (ArrayList<Comment>) cmDAO.GetlistComment(epID);
        req.setAttribute("list", list);
        
        req.setAttribute("commentList", cmDAO.GetlistComment(epID));
        req.setAttribute("totalEp", dao.getEpisodeCountByMovieId(movieID));
        req.getRequestDispatcher("WatchingAnime.jsp").forward(req, resp);

    }

}
