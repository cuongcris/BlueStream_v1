/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBConnect;
import entity.Account;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean checkUser(String user) {
        try {
            String query = "select * from \"tbAccount\" \n"
                    + "where \"UserName\" = ?";
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    public Account CheckLogin(String username, String password) {

        String query = "Select * from \"tbAccount\" \n"
                + "where \"UserName\" = ? and \"Password\" = ?";

        try {
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next()) {
                Account a = new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean checkAccountExits(String user) {

        try {
            String query = "select * from \"tbAccount\" where \"username\" = ?  ";
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return false;
            }
        } catch (Exception e) {
        }

        return true;
    }

    public void addNewAccount(Account acc) {
        try {
            String query = "insert into \"tbAccount\" ( \"UserName\", \"Password\", \"Email\", \"FullName\",\"DateOfBirth\",\"Phone\", \"Image\", \"Role\") values (?, ?, ?, ?, ?, ?,?,?)";
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc.getUserName());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getEmail());
            ps.setString(4, null);
            ps.setDate(5, (Date) acc.getDateOfBirth());
            ps.setString(6, null);
            ps.setString(7, "https://nhadepso.com/wp-content/uploads/2023/03/cap-nhat-50-hinh-anh-dai-dien-facebook-mac-dinh-dep-doc-la_17.jpg");
            ps.setInt(8, 2);
            rs = ps.executeQuery();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public boolean checkEmailExist(String email) {
        try {
            String query = "select * from \"tbAccount\" where \"Email\" = ?";
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return true;
    }

    public void updateInfor(String userName, String fName, String phone, Date dateOfBith, String avatar) {
        try {
            String query = "UPDATE \"tbAccount\" "
                    + " SET \"FullName\" = ?,"
                    + " \"dateOfBith\" = ?,"
                    + "\"Image\" = ?,"
                    + " \"Phone\" = ? "
                    + " WHERE \"UserName\" = ?";
            
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fName);
            ps.setDate(2, dateOfBith);
            ps.setString(3, avatar);
            ps.setString(4, phone);
            ps.setString(5, userName);
            
            rs = ps.executeQuery();
            
        } catch (Exception e) {

        }
    }
    
    public void updatePass(String userName, String password) {
        try {
            String query = "UPDATE \"tbAccount\" "
                    + " SET \"Password\" = ?"
                    + " WHERE \"UserName\" = ?";
            
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, userName);

            
            rs = ps.executeQuery();
            
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        AccountDAO ac = new AccountDAO();
 
        Account a = new Account("Admin", "123a","Cuongnmde160269@fpt.edu.vn");
        ac.addNewAccount(a);
 
    }

}
