/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBConnect;
import entity.Advertisement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdsDao {

    ResultSet re = null;
    Connection con = null;
    PreparedStatement pe = null;

    public ArrayList<Advertisement> getAllAds() {
//         con = null;
        ArrayList<Advertisement> result = new ArrayList<>();
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbAdvertisement\"";
            pe = con.prepareStatement(stm1);
            re = pe.executeQuery();
            while (re.next()) {
                String adsID = re.getString(1);
                String adsOwnerEmail = re.getString(2);
                String adsType = re.getString(3);
                int adsPrice = re.getInt(4);
                String adsLinkTo = re.getString("adsLinkTo");
                String adsLinkShow = re.getString("adsLinkShow");
                Date dayStart = re.getDate("dayStart");
                Date dayEnd = re.getDate("dayEnd");

                result.add(new Advertisement(adsID, adsOwnerEmail, adsType, adsPrice, adsLinkTo, adsLinkShow, dayStart, dayEnd));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                re.close();
                con.close();
                pe.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public ArrayList<Advertisement> getAdsByDate() {
//         con = null;
        ArrayList<Advertisement> result = new ArrayList<>();

        try {
            LocalDate lc = LocalDate.now();

            String dateNow = " " + lc;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date endDateUtil = dateFormat.parse(dateNow);

            Date date = new Date(endDateUtil.getTime());

            con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbAdvertisement\" where \"dayStart\" <= ? and \"dayEnd\" >= ?";
            pe = con.prepareStatement(stm1);
            pe.setDate(1, date);
            pe.setDate(2, date);
            re = pe.executeQuery();
            while (re.next()) {
                String adsID = re.getString(1);
                String adsOwnerEmail = re.getString(2);
                String adsType = re.getString(3);
                int adsPrice = re.getInt(4);
                String adsLinkTo = re.getString("adsLinkTo");
                String adsLinkShow = re.getString("adsLinkShow");
                Date dayStart = re.getDate("dayStart");
                Date dayEnd = re.getDate("dayEnd");

                result.add(new Advertisement(adsID, adsOwnerEmail, adsType, adsPrice, adsLinkTo, adsLinkShow, dayStart, dayEnd));
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdsDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                re.close();
                con.close();
                pe.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public boolean addNewAds(Advertisement ads) {
        try {
            String query = "insert into \"tbAdvertisement\" ( \"adsOwnerEmail\", "
                    + "\"adsType\", \"adsPrice\", \"dayStart\", \"dayEnd\""
                    + ", \"adsLinkTo\", \"adsLinkShow\")\n"
                    + "values (?,?,?,?,?,?,?)";

            con = new DBConnect().makeConnection();
            pe = con.prepareStatement(query);
            pe.setString(1, ads.getOwnerEmail());
            pe.setString(2, ads.getType());
            pe.setInt(3, ads.getPrice());
            pe.setDate(4, (java.sql.Date) ads.getDayStart());
            pe.setDate(5, (java.sql.Date) ads.getDayEnd());
            pe.setString(6, ads.getLinkTo());
            pe.setString(7, ads.getLinkShow());
            re = pe.executeQuery();

            return true;
        } catch (Exception e) {
            if (e.toString().equals("org.postgresql.util.PSQLException: No results were returned by the query.")) {
                return true;
            }
            System.err.println(e);
        } finally {

            try {
                if (re != null) {
                    re.close();
                }
                if (con != null) {
                    con.close();
                }
                if (pe != null) {
                    pe.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public boolean updateAds(Advertisement ads) {
        try {
            String query = "update \"tbAdvertisement\"\n"
                    + "set \"adsOwnerEmail\" = ?,"
                    + " \"adsType\" = ?,\n"
                    + "\"adsPrice\" = ?, "
                    + "\"dayStart\" = ?, "
                    + "\"dayEnd\" = ?,\n"
                    + "\"adsLinkTo\" = ?, "
                    + "\"adsLinkShow\" = ?\n"
                    + "where \"adsID\" = '"+ ads.getId() +"'";

            con = new DBConnect().makeConnection();
            pe = con.prepareStatement(query);
            pe.setString(1, ads.getOwnerEmail());
            pe.setString(2, ads.getType());
            pe.setInt(3, ads.getPrice());
            pe.setDate(4, (java.sql.Date) ads.getDayStart());
            pe.setDate(5, (java.sql.Date) ads.getDayEnd());
            pe.setString(6, ads.getLinkTo());
            pe.setString(7, ads.getLinkShow());
            
            pe.executeUpdate();

            return true;
        } catch (Exception e) {
            if (e.toString().equals("org.postgresql.util.PSQLException: No results were returned by the query.")) {
                return true;
            }
            System.err.println(e);
        } finally {

            try {
                if (re != null) {
                    re.close();
                }
                if (con != null) {
                    con.close();
                }
                if (pe != null) {
                    pe.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }
    
    public void deleteAds(String adsID){
        try {
            String query = "delete from \"tbAdvertisement\""
                    + "where \"adsID\" = '"+ adsID +"'";

            con = new DBConnect().makeConnection();
            pe = con.prepareStatement(query);
            
            pe.executeUpdate();

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
                if (pe != null) {
                    pe.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void main(String[] args) throws ParseException {
        AdsDao dao = new AdsDao();

        String startDateString = "2040-01-01";
        String endDateString = "2043-01-01";


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            java.util.Date startDateUtil = dateFormat.parse(startDateString);
            java.util.Date endDateUtil = dateFormat.parse(endDateString);

            Date startDate = new Date(startDateUtil.getTime());
            Date endDate = new Date(endDateUtil.getTime());

            Advertisement ad = new Advertisement("52e1086f-c8ab-4cbf-b280-ad027e8b643b", "Video", "Video", 13120000, endDateString, endDateString, startDate, endDate);
            
            
//            boolean executed = dao.addNewAds(ad);
//            if(executed == true){
//                System.out.println("Khong loi");
//            }else{
//                System.out.println("Loi");
//            }

              dao.deleteAds("8dc6e6a5-93b3-46ca-b706-9a909366bda7");
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
