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

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet re = null;

    public List<Comment> GetlistComment(String epID) {
        List<Comment> list = new ArrayList<>();
        try {

            String query = "select \"CommentID\", a.\"UserID\", \"EpID\", \"CommentContent\", \"time\", \"Image\", \"UserName\", \"Role\"\n"
                    + "from \"tbComment\" a, \"tbAccount\" b \n"
                    + "where a.\"UserID\" = b.\"UserID\" and a.\"EpID\" = '" + epID + "'";
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            re = ps.executeQuery();
            while (re.next()) {
                list.add(new Comment(re.getString(1), re.getString(2), re.getString(3),
                        re.getString(4), re.getDate(5), re.getString(6), re.getString(7), re.getInt(8)));
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {

            try {
                if (re != null) {
                    re.close();
                }
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }  catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return list;
    }

    //set time
    public long caculDiffDay(Date commentDay) {
        LocalDate currentDate = LocalDate.now();
        String dateString = "" + commentDay;
        LocalDate specificDate = LocalDate.parse(dateString);
        long daysDifference = specificDate.until(currentDate, ChronoUnit.DAYS);
        return daysDifference;
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
            System.out.println("Error in delete comment: " + e);
        }finally {

            try {
                if (re != null) {
                    re.close();
                }
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }  catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println("Error in getEpsID: " + e);
        } finally {

            try {
                if (re != null) {
                    re.close();
                }
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }  catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, content);
            ps.setDate(2, sqlDate);
            re = ps.executeQuery();

        } catch (Exception e) {
            System.err.println(e);
        } finally {

            try {
                if (re != null) {
                    re.close();
                }
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }  catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    //Cout all comment each movie
    public int getCommentCount(String movieID) {
    int commentCount = 0;

    try {
        String query = "SELECT COUNT(\"CommentID\") AS \"CommentCount\" FROM \"tbComment\" " +
                       "INNER JOIN \"tbEpisodes\" ON \"tbComment\".\"EpID\" = \"tbEpisodes\".\"EpID\" " +
                       "WHERE \"tbEpisodes\".\"MovieID\" = ?";
        con = new DBConnect().makeConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, movieID);
        re = ps.executeQuery();

        if (re.next()) {
            commentCount = re.getInt("CommentCount");
        }
    } catch (Exception e) {
        System.err.println(e);
    } finally {

            try {
                if (re != null) {
                    re.close();
                }
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }  catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    return commentCount;
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
    public static void main(String[] args) {
        CommentDAO cm = new CommentDAO();
        System.out.println(cm.getCommentCount("DBS1809"));
    }

}
