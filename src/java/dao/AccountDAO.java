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

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet re = null;

    public boolean checkUser(String user) {
        try {
            String query = "select * from \"tbAccount\" \n"
                    + "where \"UserName\" = ?";
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            re = ps.executeQuery();
            while (re.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("error in checkuser");
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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return false;
    }

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> list = new ArrayList<>();

        String query = "select * from \"tbAccount\"";

        try {

            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);

            re = ps.executeQuery();

            while (re.next()) {
                Account a = new Account(
                        re.getString(1),
                        re.getString(2),
                        re.getString(3),
                        re.getString(4),
                        re.getString(5),
                        re.getString(6),
                        re.getString(7),
                        re.getString(8),
                        re.getInt(9),
                        re.getString(10));
                list.add(a);
            }
        } catch (Exception e) {
            System.out.println("error check login");
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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return list;
    }

    public Account CheckLogin(String username, String password) {

        String query = "Select * from \"tbAccount\" \n"
                + "where \"UserName\" = ? and \"Password\" = ?";

        try {
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            re = ps.executeQuery();

            while (re.next()) {
                Account a = new Account(
                        re.getString(1),
                        re.getString(2),
                        re.getString(3),
                        re.getString(4),
                        re.getString(5),
                        re.getString(6),
                        re.getString(7),
                        re.getString(8),
                        re.getInt(9),
                        re.getString(10));
                return a;
            }
        } catch (Exception e) {
            System.out.println("eror check login");
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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public boolean checkAccountExits(String user) {

        try {
            String query = "select * from \"tbAccount\" where \"username\" = ?  ";
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            re = ps.executeQuery();
            while (re.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("error checkacount exist");
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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return true;
    }

    public void addNewAccount(Account acc) {
        try {
            String query = "insert into \"tbAccount\" ( \"UserName\", \"Password\", \"Email\", \"FullName\",\"YearOfBirth\",\"Phone\", \"Image\", \"Role\") values (?, ?, ?, ?, ?, ?,?,?)";
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, acc.getUserName());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getEmail());
            ps.setString(4, null);
            ps.setString(5, null);
            ps.setString(6, null);
            ps.setString(7, "https://nhadepso.com/wp-content/uploads/2023/03/cap-nhat-50-hinh-anh-dai-dien-facebook-mac-dinh-dep-doc-la_17.jpg");
            ps.setInt(8, 2);
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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public boolean checkEmailExist(String email) {
        try {
            String query = "select * from \"tbAccount\" where \"Email\" = ?";
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            re = ps.executeQuery();
            while (re.next()) {
                return false;
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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
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

            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, fName);
            ps.setString(2, yearOfBirth);
            ps.setString(3, avatar);
            ps.setString(4, phone);
            ps.setString(5, userName);

            re = ps.executeQuery();

        } catch (Exception e) {
            System.out.println("error updateInfo");
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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void updatePass(String userName, String password) {
        try {
            String query = "UPDATE \"tbAccount\" "
                    + " SET \"Password\" = ?"
                    + " WHERE \"UserName\" = ?";

            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, userName);

            re = ps.executeQuery();
        } catch (Exception e) {

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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    //check login google

    public ArrayList checkLogin(String userIDGoogle) {
        ArrayList<Account> ul = new ArrayList<>();
        String query = "select * from \"tbAccount\" where \"user_id_google\"= ?";

        try {
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, userIDGoogle);
            re = ps.executeQuery();
            while (re.next()) {
                Account a = new Account();
                a.setUserID(re.getString("userID"));
                a.setUserName(re.getString("userName"));
                a.setPassword(re.getString("password"));
                a.setEmail(re.getString("email"));
                a.setYearOfBirth(re.getString("yearOfBirth"));
                a.setPhone(re.getString("phone"));
                a.setImage(re.getString("image"));
                a.setRole(re.getInt("role"));
                a.setUser_id_google(re.getString("user_id_google"));
                ul.add(a);
            }
        } catch (Exception e) {
            System.out.println("Error user: " + e.getMessage());
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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

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
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);

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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void updateRoleToVip(String userID) {
        try {
            String query = "UPDATE \"tbAccount\"\n"
                    + "SET \"Role\" = 1 \n"
                    + "WHERE \"UserID\" = '" + userID + "'";

            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
            System.out.println("thanh cong");

        } catch (Exception e) {
            System.out.println(e);
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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void InsertPayment(String userID, int money, String type) {
        try {
            String query = "insert into \"tbPayment\" (\"UserID\",\"Money\",\"PaymentDate\",\"PaymentType\") values('" + userID + "',?,current_timestamp,?)";

            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, money);
            ps.setString(2, type);
            System.out.println("INSERT THANH CONG ");

            ps.executeQuery();
        } catch (Exception e) {

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
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        AccountDAO ac = new AccountDAO();
//        ac.InsertPayment("17a24030-d261-44b0-82d1-1f7005974a81", 500000, "UpVip");
        ArrayList <Account> list = ac.getAllAccount();
        for (Account account : list) {
            System.out.println(account.toString());
        }
    }
}
