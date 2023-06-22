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
public class Favorite {
    private String favoriteID;
    private String userID;
    private String movieID;
    private String movieBanner;
    private String movieName;
    private Date favDate;

    public Favorite(String favoriteID, String userID, String movieID, String movieBanner, String movieName, Date favDate) {
        this.favoriteID = favoriteID;
        this.userID = userID;
        this.movieID = movieID;
        this.movieBanner = movieBanner;
        this.movieName = movieName;
        this.favDate = favDate;
    }

    public String getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(String favoriteID) {
        this.favoriteID = favoriteID;
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

    public String getMovieBanner() {
        return movieBanner;
    }

    public void setMovieBanner(String movieBanner) {
        this.movieBanner = movieBanner;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getFavDate() {
        return favDate;
    }

    public void setFavDate(Date favDate) {
        this.favDate = favDate;
    }

    @Override
    public String toString() {
        return "Favorite{" + "favoriteID=" + favoriteID + ", userID=" + userID + ", movieID=" + movieID + ", movieBanner=" + movieBanner + ", movieName=" + movieName + ", favDate=" + favDate + '}';
    }
    
}
