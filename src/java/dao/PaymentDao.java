/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBConnect;
import entity.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class PaymentDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet re = null;

    public ArrayList<Payment> getAllPayment() {
        ArrayList<Payment> list = new ArrayList<>();
        String query = "select * from \"tbPayment\"";
        try {
            con = new DBConnect().makeConnection();

            ps = con.prepareStatement(query);
            re = ps.executeQuery();
            while (re.next()) {
                Payment payment = new Payment(
                        re.getString(1),
                        re.getString(2),
                        re.getInt(3),
                        re.getDate(4),
                        re.getString(5)
                );
                list.add(payment);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);

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

    public static void main(String[] args) {
        PaymentDao paymentDao = new PaymentDao();
        ArrayList<Payment> list = paymentDao.getAllPayment();
        for (Payment payment : list) {
            System.out.println(payment.toString());
        }
    }
}
