/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.MovieDAO;
import entity.Movie;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AllMovie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDAO dao = new MovieDAO();
        req.setAttribute("Category", dao.getAllMovie());
        req.getRequestDispatcher("Categorys.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDAO dao = new MovieDAO();
        PrintWriter pw = resp.getWriter();

        String txtSearch = req.getParameter("txtSearch");
        String nameFilter = req.getParameter("nameFilter");
        String licenseFilter = req.getParameter("licenseFilter");
        String viewFilter = req.getParameter("viewFilter");
        String search = req.getParameter("txtSearch");

        List<Movie> list = dao.getAllMovie(nameFilter, txtSearch, viewFilter);

//        req.setAttribute("txtSearch", txtSearch);
        int totalSize = list.size();
        int itemOfPage = 12;

        //Lấy tổng số trang dựa trên dữ liệu hiện có rồi truyền lên jsp
        int totalPage = (int) Math.ceil((double) totalSize / itemOfPage);

        //Lấy page hiện tại và truyền lên jsp
        String page = req.getParameter("page");
        int curPage = (page != null) ? Integer.parseInt(page) : 1;

        //Lấy id bắt đầu trang rồi truyền lên jsp
        int start = (curPage - 1) * itemOfPage;

        //Lấy id kết thúc trang rồi truyền lên jsp
        int end = Math.min(curPage * itemOfPage, totalSize);

        String btnPrev = (curPage > 1) ? "onclick=\"filter(" + (curPage - 1) + ")\"" : "disabled";
        String btnNext = (curPage < totalPage) ? "onclick=\"filter(" + (curPage + 1) + ")\"" : "disabled";

        Format format = new Format();

        for (int i = start; i < end; i++) {
            Movie movie = list.get(i);
            pw.write(" <div class=\"col-lg-4 col-md-6 col-sm-6 \">\n"
                    + "                                        <div style=\"position: relative;\" class=\"product__item\">\n"
                    + "                                            <a href=\"DetailAnime?id=" + movie.getMovieId() + "\">\n"
                    + "                                                <div style=\"cursor: pointer;margin-bottom:20px;\" class=\"product__item__pic set-bg\" data-setbg= " + movie.getMovieBanner() + " >\n"
                    + "                                                    <div style=\"font-size: 13px;\n"
                    + "    color: #ffffff;\n"
                    + "    background: #e53637;\n"
                    + "    display: inline-block;\n"
                    + "    padding: 2px 12px;\n"
                    + "    border-radius: 4px;\n"
                    + "    position: absolute;\n"
                    + "    left: 10px;\n"
                    + "    top: 10px;\" class=\"ep\">" + movie.getMovieStatus() + "</div>\n"
                    + "                                                    <div style=\"    font-size: 13px;\n"
                    + "    color: #ffffff;\n"
                    + "    background: #3d3d3d;\n"
                    + "    display: inline-block;\n"
                    + "    padding: 2px 10px;\n"
                    + "    border-radius: 4px;\n"
                    + "    position: absolute;\n"
                    + "    right: 10px;\n"
                    + "    bottom: 10px;\"  class=\"view\"><i class=\"fa fa-eye\"></i> " + format.formatNumber(movie.getMovieView()) + " </div>\n"
                    + "                                                </div>\n"
                    + "                                                <div style=\"padding :0px 0px 20px 0px;margin-bottom:0px;\" class=\"product__item__text\">\n"
                    + "                                                    <ul>\n"
                    + "                                                        <li> " + movie.getCategory().get(0) + "</li>\n"
                    + "                                                        <li> " + movie.getCategory().get(1) + "</li>\n"
                    + "                                                    </ul>\n"
                    + "                                                    <h5 style=\"color:#79797980;\"><a href=\"DetailAnime?id=" + movie.getMovieId() + "\">" + format.nameStandardization(movie.getMovieName()) + "</a></h5>\n"
                    + "                                                </div>\n"
                    + "                                            </a>\n"
                    + "                                        </div>\n"
                    + "                                    </div>");
        }
        pw.write("<div class=\"col-md-5 col-12\">\n"
                + "                                            <div class=\"paging\">\n"
                + "                                                <button type=\"button\" class=\"paging-btn\" id=\"paging-prev\" " + btnPrev + "><i class=\"fas fa-angle-left\"></i></button>\n"
                + "                                                <input type=\"number\" step=\"1\" min=\"1\" class=\"paging-num\" value=\"" + curPage + "\" name=\"page\" readonly>\n"
                + "                                                <span>/ " + totalPage + "</span>\n"
                + "                                                <button type=\"button\" class=\"paging-btn\" id=\"paging-prev\"" + btnNext + "\"><i class=\"fas fa-angle-right\"></i></button>\n"
                + "                                            </div>\n"
                + "                                        </div>\n");

    }

}
