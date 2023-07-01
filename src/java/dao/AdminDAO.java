package dao;

import context.DBConnect;
import controller.Format;
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
public class AdminDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public int getTotalComment() {
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select Count(*) from \"tbComment\"";
            p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            if (re.next()) {
                int epID = re.getInt(1);
                return epID;
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
        return 0;

    }

    public int getTotalAnime() {
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select Count(*) from \"tbMovie\"";
            p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            if (re.next()) {
                int totalAnime = re.getInt(1);
                return totalAnime;
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
        return 0;

    }

    public int getTotalUser() {
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select Count(*) from \"tbAccount\"";
            p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            if (re.next()) {
                int totalAnime = re.getInt(1);
                return totalAnime;
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
        return 0;

    }

    public int getTotalMoneyADS() {
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select Sum(\"adsPrice\") From \"tbAdvertisement\"";
            p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            if (re.next()) {
                int totalAnime = re.getInt(1);
                return totalAnime;
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
        return 0;

    }

    public int getTotalMoneyPayment() {
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select Sum(\"Money\") From \"tbPayment\"";
            p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            if (re.next()) {
                int totalAnime = re.getInt(1);
                return totalAnime;
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
        return 0;

    }

    public int getRoleAdmin() {
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "SELECT  COUNT(*) FROM \"tbAccount\" where \"Role\" = 0";
            p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            if (re.next()) {
                int numberOfRole = re.getInt(1);
                return numberOfRole;
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
        return 0;

    }

    public int getRoleVIP() {
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "SELECT  COUNT(*) FROM \"tbAccount\" where \"Role\" = 1";
            p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            if (re.next()) {
                int numberOfRole = re.getInt(1);
                return numberOfRole;
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
        return 0;

    }
    
    public int getRoleUser() {
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "SELECT  COUNT(*) FROM \"tbAccount\" where \"Role\" = 2";
            p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            if (re.next()) {
                int numberOfRole = re.getInt(1);
                return numberOfRole;
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
        return 0;

    }

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        int total = dao.getTotalMoneyPayment() + dao.getTotalMoneyADS();
        Format fm = new Format();
        System.out.println(dao.getRoleAdmin());
    }

}
