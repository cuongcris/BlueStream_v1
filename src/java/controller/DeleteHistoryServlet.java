
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
public class DeleteHistoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDAO dao = new MovieDAO();
        HttpSession session = req.getSession();
         Account acc = (Account) session.getAttribute("account");
        String movieID = req.getParameter("movieID");
        dao.deleteHistory(movieID, acc.getUserID());
        resp.sendRedirect("History");
    }
    
    
}
