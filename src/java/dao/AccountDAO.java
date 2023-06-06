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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        }finally{
           
            try {
                  conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return false;
    }

    public String getUseNameByID(String id) {
        try {
            String query = "select \"UserName\" from \"tbAccount\" where \"UserID\" = '" + id + "'";
            
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                return rs.getString(1);
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }finally{
           
            try {
                  conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return null;
    }
    
    public String getAvatarByID(String id) {
        try {
            String query = "select \"Image\" from \"tbAccount\" where \"UserID\" = '" + id + "'";
            
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                return rs.getString(1);
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }finally{
           
            try {
                  conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return null;
    }
    
    public String getRoleByID(String id) {
        try {
            String query = "select \"Role\" from \"tbAccount\" where \"UserID\" = '" + id + "'";
            
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                return rs.getString(1);
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }

        return null;
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
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10));
                return a;
            }
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }finally{
           
            try {
                  conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }finally{
           
            try {
                  conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return true;
    }

    public void addNewAccount(Account acc) {
        try {
            String query = "insert into \"tbAccount\" ( \"UserName\", \"Password\", \"Email\", \"FullName\",\"YearOfBirth\",\"Phone\", \"Image\", \"Role\") values (?, ?, ?, ?, ?, ?,?,?)";
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc.getUserName());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getEmail());
            ps.setString(4, null);
            ps.setString(5, null);
            ps.setString(6, null);
            ps.setString(7, "https://nhadepso.com/wp-content/uploads/2023/03/cap-nhat-50-hinh-anh-dai-dien-facebook-mac-dinh-dep-doc-la_17.jpg");
            ps.setInt(8, 2);
            rs = ps.executeQuery();
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
           
            try {
                  conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
           
            try {
                  conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return true;
    }

    public void updateInfor(String userName, String fName, String phone, String yearOfBirth, String avatar) {
        try {
            String query = "UPDATE \"tbAccount\" "
                    + " SET \"FullName\" = ?,"
                    + " \"YearOfBirth\" = ?,"
                    + "\"Image\" = ?,"
                    + " \"Phone\" = ? "
                    + " WHERE \"UserName\" = ?";

            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fName);
            ps.setString(2, yearOfBirth);
            ps.setString(3, avatar);
            ps.setString(4, phone);
            ps.setString(5, userName);

            rs = ps.executeQuery();
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {

        }finally{
           
            try {
                  conn.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {

        }finally{
           
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
        AccountDAO ac = new AccountDAO();

        Account a = new Account("Admin", "123a", "Cuongnmde160269@fpt.edu.vn");

        System.out.println(ac.getAvatarByID("e0457766-39cd-4bda-b7b8-1d2cb3bae9d0"));

    }

}
