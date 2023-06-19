/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Episodes {
    private String epId;
    private String movieId;
    private int epNum;
    private int duration;
    private String movieLink;

    public Episodes(String epId, String movieId, int epNum, int duration, String movieLink) {
        this.epId = epId;
        this.movieId = movieId;
        this.epNum = epNum;
        this.duration = duration;
        this.movieLink = movieLink;
    }

    public String getEpId() {
        return epId;
    }

    public void setEpId(String epId) {
        this.epId = epId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getEpNum() {
        return epNum;
    }

    public void setEpNum(int epNum) {
        this.epNum = epNum;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMovieLink() {
        return movieLink;
    }

    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

    @Override
    public String toString() {
        return "Episodes{" + "epId=" + epId + ", movieId=" + movieId + ", epNum=" + epNum + ", duration=" + duration + ", movieLink=" + movieLink + '}';
    }
    
    
}
