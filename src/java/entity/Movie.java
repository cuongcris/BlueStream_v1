/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Movie {
    private String movieId;
    private String movieName;
    private String movieBanner;
    private String description;
    private Date releaseDate;
    private List<String> category;
    private String author;
    private String movieStatus;
    private String movieSeason;
    private int movieView;
    private String license;

    public Movie(String movieId, String movieName, String movieBanner, String description, Date releaseDate, List<String> category, String author, String movieStatus, String movieSeason, int movieView, String license) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieBanner = movieBanner;
        this.description = description;
        this.releaseDate = releaseDate;
        this.category = category;
        this.author = author;
        this.movieStatus = movieStatus;
        this.movieSeason = movieSeason;
        this.movieView = movieView;
        this.license = license;
    }

    
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getMovieSeason() {
        return movieSeason;
    }

    public void setMovieSeason(String movieSeason) {
        this.movieSeason = movieSeason;
    }

    public int getMovieView() {
        return movieView;
    }

    public void setMovieView(int movieView) {
        this.movieView = movieView;
    }

    public String isLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieId=" + movieId + ", movieName=" + movieName + ", movieBanner=" + movieBanner + ", description=" + description + ", releaseDate=" + releaseDate + ", category=" + category + ", author=" + author + ", movieStatus=" + movieStatus + ", movieSeason=" + movieSeason + ", movieView=" + movieView + ", license=" + license + '}';
    }
    
    
    
}
