/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Format ns = new Format();
            
            Account ac = new Account();
            HttpSession session = request.getSession();
            ac = (Account) session.getAttribute("account");
            
            String userName = ac.getUserName();
            String passWord = ac.getPassword();
            
            PrintWriter pr = response.getWriter();
            String fName = ns.nameStandardization(request.getParameter("fullname"));
            String phone = request.getParameter("phone");
            String dateOfBirth = request.getParameter("DateOfBirth");
            String avatar = request.getParameter("avatar");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date dob = dateFormat.parse(dateOfBirth);
            
            AccountDAO dao = new AccountDAO();
            
            dao.updateInfor(userName, fName, phone, (java.sql.Date) dob, avatar);
            
            Account a = dao.CheckLogin(userName, passWord);
            
            session.setAttribute("account", a);
            
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ChangeProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
