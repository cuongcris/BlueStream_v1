/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBConnect;
import entity.Comment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CommentDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Comment> GetlistComment(String epID) {
        List<Comment> list = new ArrayList<>();
        try {

            String query = "select \"CommentID\", a.\"UserID\", \"EpID\", \"CommentContent\", \"time\", \"Image\", \"UserName\", \"Role\"\n"
                    + "from \"tbComment\" a, \"tbAccount\" b \n"
                    + "where a.\"UserID\" = b.\"UserID\" and a.\"EpID\" = '" + epID + "'";
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {

            try {
                conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return list;
    }

    //set time
    public String printDiffDay(Date commentDay) {
        LocalDate currentDate = LocalDate.now();
        String dateString = "" + commentDay;
        LocalDate specificDate = LocalDate.parse(dateString);
        long daysDifference = specificDate.until(currentDate, ChronoUnit.DAYS);
        if(daysDifference <= 0) return "Today!";
        else return daysDifference + " day ago!";
    }

    public void deleteComment(String id) {
        
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "delete from \"tbComment\" where \"CommentID\" = '" + id +"'";
            p1 = con.prepareStatement(stm1);
            p1.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
        } finally {
            try {
                con.close();
                p1.close();
            } catch (SQLException ex) {

            }

        }
    }

    public String getEpsID(String movieID, int epsNum) {
        String epID = null;
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select \"EpID\" from \"tbEpisodes\" where \"EpNum\" = ? and \"MovieID\" = ? ";
            p1 = con.prepareStatement(stm1);
            p1.setInt(1, epsNum);
            p1.setString(2, movieID);
            re = p1.executeQuery();
            if (re.next()) {
                epID = re.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
        } finally {
            try {
                con.close();
                p1.close();
                re.close();
            } catch (SQLException ex) {

            }

        }
        return epID;

    }

    public void addcomment(String epsID, String useID, String content) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        LocalDate date = LocalDate.parse(formattedDate, formatter);
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        try {
            String query = "insert into \"tbComment\" (\"UserID\", \"EpID\",\"CommentContent\",\"time\" ) values ('" + useID + "','" + epsID + "'  , ?, ?)";
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, content);
            ps.setDate(2, sqlDate);
            rs = ps.executeQuery();

        } catch (Exception e) {
            System.err.println(e);
        } finally {

            try {
                conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void main(String[] args) {
        CommentDAO cm = new CommentDAO();
        List<Comment> list = new ArrayList<>();
        list = cm.GetlistComment("57f9d9d4-f11c-4441-b3b1-0bb436b7c9d9");
        
        cm.deleteComment("57b1dfa8-8b94-4613-84a3-04106e015966");
        System.out.println(list.get(0));
    }

}
