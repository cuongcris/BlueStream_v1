/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Account {

    private String userID;
    private String userName;
    private String password;
    private String email;
    private String yearOfBirth;
    private String phone;
    private String fullName;
    private String image;
    private int role;
    private String user_id_google;

    public Account() {
    }

    public Account(String userName, String password,String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Account(String userName, String password, String email, String yearOfBirth, String phone, String fullName, String image, int role, String user_id_google) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
        this.phone = phone;
        this.fullName = fullName;
        this.image = image;
        this.role = role;
        this.user_id_google = user_id_google;
    }

    public Account(String userID, String userName, String password, String email, String fullName, String yearOfBirth, String phone, String image, int role, String user_id_google) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.phone = phone;
        this.image = image;
        this.role = role;
        this.user_id_google = user_id_google;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    

   

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUser_id_google() {
        return user_id_google;
    }

    public void setUser_id_google(String user_id_google) {
        this.user_id_google = user_id_google;
    }

    @Override
    public String toString() {
        return "Account{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email + ", yearOfBirth=" + yearOfBirth + ", phone=" + phone + ", fullName=" + fullName + ", image=" + image + ", role=" + role + ", user_id_google=" + user_id_google + '}';
    }

}
