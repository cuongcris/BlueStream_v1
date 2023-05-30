/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class OTP {
    String OTP;

    public OTP() {
    }

    public OTP(String OTP) {
        this.OTP = OTP;
    }
    
    public static String randomOTP(){
        String OTP = "";
        for (int i = 1; i <= 6; i++) {
            Random rand = new Random();
            int ranNum = (int) rand.nextInt(9);
            OTP += ranNum;
        }
        return OTP;
    }

    public String getOTP() {
        return randomOTP();
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }
    
    public static void main(String[] args) {
        OTP ot = new OTP();
        System.out.println(ot.getOTP());
    }
}
