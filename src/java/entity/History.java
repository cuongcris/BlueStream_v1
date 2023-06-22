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
public class History {
    private String historyID;
    private String userID;
    private String movieID;
    private String movieBanner;
    private String movieName;
    private int epNum;
    private Date lastWatched;

    public History(String historyID, String userID, String movieID, int epNum, Date lastWatched,String movieBanner,String movieName) {
        this.historyID = historyID;
        this.userID = userID;
        this.movieID = movieID;
        this.movieBanner = movieBanner;
        this.movieName = movieName;
        this.epNum = epNum;
        this.lastWatched = lastWatched;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieBanner() {
        return movieBanner;
    }

    public void setMovieBanner(String movieBanner) {
        this.movieBanner = movieBanner;
    }

    public String getHistoryID() {
        return historyID;
    }

    public void setHistoryID(String historyID) {
        this.historyID = historyID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public int getEpNum() {
        return epNum;
    }

    public void setEpNum(int epNum) {
        this.epNum = epNum;
    }

    public Date getLastWatched() {
        return lastWatched;
    }

    public void setLastWatched(Date lastWatched) {
        this.lastWatched = lastWatched;
    }

    @Override
    public String toString() {
        return "History{" + "historyID=" + historyID + ", userID=" + userID + ", movieID=" + movieID + ", epNum=" + epNum + ", lastWatched=" + lastWatched + '}';
    }
    
    
}
