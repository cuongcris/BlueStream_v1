/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import dao.AccountDAO;
import dao.AdsDao;
import entity.Advertisement;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class UpdateAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String update_id = req.getParameter("update_id");
        AccountDAO dao = new AccountDAO();
        req.setAttribute("account_update", dao.getAccountByID(update_id));
        req.getRequestDispatcher("./admin/UpdateAccount.jsp").forward(req, resp);
    }
    
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userId_get = req.getParameter("userID");
        int account_role = Integer.parseInt(req.getParameter("account_role"));
        
        AccountDAO ac = new AccountDAO();
        ac.updateRole(userId_get, account_role);
        resp.sendRedirect("AccountManagement");
        
//         PrintWriter pr = resp.getWriter();
//         pr.print("123" + " " + account_role);
    } 
}
