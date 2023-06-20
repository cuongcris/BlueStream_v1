/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBConnect;
import controller.Encode;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            conn.close();
            ps.close();
            rs.close();
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

        }
    }
    
    public void updatePassByEmail(String email, String password) {
        try {
            String query = "UPDATE \"tbAccount\" "
                    + " SET \"Password\" = ?"
                    + " WHERE \"Email\" = ?";

            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, email);

            rs = ps.executeQuery();
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {

        }
    }
    //check login google

    public ArrayList checkLogin(String userIDGoogle) {
        ArrayList<Account> ul = new ArrayList<>();
        String query = "select * from \"tbAccount\" where \"user_id_google\"= ?";

        try {
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userIDGoogle);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setUserID(rs.getString("userID"));
                a.setUserName(rs.getString("userName"));
                a.setPassword(rs.getString("password"));
                a.setEmail(rs.getString("email"));
                a.setYearOfBirth(rs.getString("yearOfBirth"));
                a.setPhone(rs.getString("phone"));
                a.setImage(rs.getString("image"));
                a.setRole(rs.getInt("role"));
                a.setUser_id_google(rs.getString("user_id_google"));
                ul.add(a);
            }
        } catch (Exception e) {
            System.out.println("Error user: " + e.getMessage());
        }

        return ul;
    }

    //funtion add user with account google
    public void insertWithIDGoogle(Account a) throws Exception {
        String query = "INSERT INTO \"tbAccount\"\n"
                + "           (\"UserName\"\n"
                + "           ,\"Email\"\n"
                + "           ,\"user_id_google\",\"Role\", \"Password\", \"Image\")\n"
                + "           VALUES (?,?,?,?,?,?);";
        try {
            Encode ec = new Encode();
            String pass = ec.encode("Nolove2@123");
            conn = new DBConnect().makeConnection();
            ps = conn.prepareStatement(query);

            List<String> listUserName = Arrays.asList(a.getEmail().split("@"));
            String email = listUserName.get(0);
            String userName1 = email.substring(0, Math.min(email.length(), 10));
//            String email = a.getEmail();
//            String userName = email.substring(0, Math.min(email.length(), 5));

            ps.setString(1, userName1);
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getUser_id_google());
            ps.setInt(4, 2);
            ps.setString(5, pass);
            ps.setString(6, "https://nhadepso.com/wp-content/uploads/2023/03/cap-nhat-50-hinh-anh-dai-dien-facebook-mac-dinh-dep-doc-la_17.jpg");

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        AccountDAO ac = new AccountDAO();

        Account a = new Account("Admin", "123a", "Cuongnmde160269@fpt.edu.vn");

    }

}
