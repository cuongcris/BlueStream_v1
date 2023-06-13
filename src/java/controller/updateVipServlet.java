/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class updateVipServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AccountDAO dao = new AccountDAO();
//        long amount = Integer.parseInt(req.getParameter("amount"));
        Account acc = (Account) session.getAttribute("account");
        dao.updateRoleToVip(acc.getUserID());
//        dao.InsertPayment(acc.getUserName(),amount,1);
        Account a = dao.CheckLogin(acc.getUserName(), acc.getPassword());
        session.setAttribute("account", a);
        resp.sendRedirect("home");
    }
   
    
}
