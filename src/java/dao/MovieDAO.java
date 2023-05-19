/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBConnect;
import entity.Episodes;
import entity.Movie;
import java.sql.Connection;
import java.sql.Date;
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
 * @author Admin
 */
public class MovieDAO {

    private ArrayList<Movie> result = new ArrayList<>();

    public ArrayList<Movie> getAllMovie() {
//         con = null;

        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select *from tbMovie";
            PreparedStatement p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            while (re.next()) {
                String MovieID = re.getString("MovieID");
                String MovieName = re.getString("MovieName");
                String movieBanner = re.getString("Banner");
                String MovieDescription = re.getString("Description");
                Date ReleaseDate = re.getDate("ReleaseDate");
                String Category = re.getString("Category");
                String[] strSplit = Category.trim().split(",");
                ArrayList<String> strCategory = new ArrayList<String>(Arrays.asList(strSplit));
                String Author = re.getString("Author");
                String MovieStatus = re.getBoolean("MovieStatus") ? "Finish" : "Not Yet";
                String MovieSeason = re.getString("MovieSeason");
                int View = re.getInt("View");
                String License = re.getString("License");
                result.add(new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, License));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Movie getMovieById(String id) {
        Movie movie = null;
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select * from tbMovie where MovieID = ?";
            PreparedStatement p1 = con.prepareStatement(stm1);
            p1.setString(1, id);
            re = p1.executeQuery();
            while (re.next()) {
                String MovieID = re.getString("MovieID");
                String MovieName = re.getString("MovieName");
                String movieBanner = re.getString("Banner");
                String MovieDescription = re.getString("Description");
                Date ReleaseDate = re.getDate("ReleaseDate");
                String Category = re.getString("Category");
                String[] strSplit = Category.trim().split(",");
                ArrayList<String> strCategory = new ArrayList<>(Arrays.asList(strSplit));
                String Author = re.getString("Author");
                String MovieStatus = re.getBoolean("MovieStatus") ? "Finish" : "Not Yet";
                String MovieSeason = re.getString("MovieSeason");
                int View = re.getInt("View");
                return new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, MovieName);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
        }
        return null;
    }

    public int numberEP(String id) {

        ResultSet re;
        int numberOfEpisodes = 0;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "SELECT COUNT(*)\n"
                    + "FROM tbEpisodes\n"
                    + "WHERE movieID = ?";
            PreparedStatement p1 = con.prepareStatement(stm1);
            p1.setString(1, id);
            re = p1.executeQuery();
            if (re.next()) {
                numberOfEpisodes = re.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
            return -1;
        }
        return numberOfEpisodes;
    }

    public Episodes getEpbyID(String id) {
        Episodes episodes = null;
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select * from tbEpisodes where MovieID= ?";
            PreparedStatement p1 = con.prepareStatement(stm1);
            p1.setString(1, id);
            re = p1.executeQuery();
            while (re.next()) {
                String epId = re.getString("epId");
                String movieId = re.getString("movieId");
                int epNum = re.getInt("epNum");
                int duration = re.getInt("duration");
                String movieLink = re.getString("movieLink");
                return new Episodes(epNum, movieId, epNum, duration, movieLink);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");

        }
        return null;

    }

    public static void main(String[] args) {
        MovieDAO dao = new MovieDAO();
        Episodes m = dao.getEpbyID("DBS1809");
        System.out.println(m.getMovieLink());

    }

}
