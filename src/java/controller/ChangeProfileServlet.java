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
public class ChangeProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Format ns = new Format();
        Account ac = new Account();
        HttpSession session = request.getSession();
        ac = (Account) session.getAttribute("account");
        String userName = ac.getUserName();
        String passWord = ac.getPassword();
        PrintWriter pr = response.getWriter();
        String fName = ns.nameStandardization(request.getParameter("fullname"));
        String phone = request.getParameter("phone");
        String yearOfBirth = request.getParameter("yearOfBirth");
        String avatar = request.getParameter("avatar");
        AccountDAO dao = new AccountDAO();
        dao.updateInfor(userName, fName, phone, yearOfBirth, avatar);
        Account a = dao.CheckLogin(userName, passWord);
        session.setAttribute("account", a);
        request.setAttribute("finish_messe", "<div class=\"col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-12 col-xs-12 finish_mess\">\n"
                + "                                    <Center>\n"
                + "                                        <h4>Change Profile successfully!!</h4>\n"
                + "                                    </Center>\n"
                + "                                </div>");
        request.getRequestDispatcher("profile.jsp").forward(request, response);

    }

}
