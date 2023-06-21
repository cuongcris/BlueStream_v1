/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Payment {
    private String paymentID;
    private String userID;
    private int money;
    private Date paymentDate;
    private String paymentType;

    public Payment(String paymentID, String userID, int money, Date paymentDate, String paymentType) {
        this.paymentID = paymentID;
        this.userID = userID;
        this.money = money;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", userID=" + userID + ", money=" + money + ", paymentDate=" + paymentDate + ", paymentType=" + paymentType + '}';
    }
    
    
}
