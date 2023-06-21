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
    PreparedStatement ps = null;

    public ArrayList<Advertisement> getAllAds() {
//         con = null;
        ArrayList<Advertisement> result = new ArrayList<>();
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbAdvertisement\"";
            ps = con.prepareStatement(stm1);
            re = ps.executeQuery();
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
            Logger.getLogger(AdsDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AdsDao.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = con.prepareStatement(stm1);
            ps.setDate(1, date);
            ps.setDate(2, date);
            re = ps.executeQuery();
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
                Logger.getLogger(AdsDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public static void main(String[] args) throws ParseException {
        AdsDao adsDao = new AdsDao();
        List<Advertisement> list = new ArrayList<>();
//        list = adsDao.getAllAds();
        LocalDate lc = LocalDate.now();

        String dateNow = " " + lc;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date endDateUtil = dateFormat.parse(dateNow);

        Date startDate = new Date(endDateUtil.getTime());

        list = adsDao.getAdsByDate();

        System.out.println(list.get(0).toString());

    }
}
