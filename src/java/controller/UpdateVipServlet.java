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
public class UpdateVipServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AccountDAO dao = new AccountDAO();
        int amount = Integer.parseInt(req.getParameter("vnp_Amount"));
        Account acc = (Account) session.getAttribute("account");
        if (session.getAttribute("payment").equals("sUpVip")) {
            dao.updateRoleToVip(acc.getUserID());
            dao.InsertPayment(acc.getUserID(), amount, "UpVip");
            Account a = dao.CheckLogin(acc.getUserName(), acc.getPassword());
            session.setAttribute("account", a);
            resp.sendRedirect("home");
        }else if(session.getAttribute("payment").equals("sDonate")){
            dao.InsertPayment(acc.getUserID(), amount, "Donate");
            Account a = dao.CheckLogin(acc.getUserName(), acc.getPassword());
            session.setAttribute("account", a);
            resp.sendRedirect("Blog.jsp");
        }else{
            resp.sendRedirect("BlogDetail.jsp");
        }
    }
}
