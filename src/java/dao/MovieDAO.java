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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MovieDAO {

    //-------------------------------movie------------------------------------
    //get all move
    public ArrayList<Movie> getAllMovie() {
//         con = null;
        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbMovie\"";
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
                String License = re.getBoolean("License") == true ? "License" : "No License";
                result.add(new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, License));
            }
            re.close();
            con.close();
            p1.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //get list new release based date 
    public ArrayList<Movie> getListNewReleaseMovie() {
//         con = null;
        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select *from \"tbMovie\" ORDER BY \"ReleaseDate\" DESC";
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
                String License = re.getBoolean("License") == true ? "License" : "No License";
                result.add(new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, License));
            }
            con.close();
            p1.close();
            re.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //get list popular movie based view acs
    public ArrayList<Movie> getListPopularMovie() {
//         con = null;
        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select *from \"tbMovie\" ORDER BY \"View\" DESC";
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
                String License = re.getBoolean("License") == true ? "License" : "No License";
                result.add(new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, License));
            }
            con.close();
            p1.close();
            re.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //get list live action movie 
    public ArrayList<Movie> getListLiveActionMovie() {
//         con = null;
        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select *from \"tbMovie\" WHERE \"Category\" LIKE '%Live Action'";
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
                String License = re.getBoolean("License") == true ? "License" : "No License";
                result.add(new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, License));
            }
            con.close();
            p1.close();
            re.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //get random movie 
    public ArrayList<Movie> getListRandomMovie() {
//         con = null;
        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select *from \"tbMovie\" ORDER BY NEWID()";
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
                String License = re.getBoolean("License") == true ? "License" : "No License";
                result.add(new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, License));
            }
            con.close();
            p1.close();
            re.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //get movie by id
    public Movie getMovieById(String id) {
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbMovie\" where \"MovieID\" = ?";
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
                String License = re.getBoolean("License") == true ? "License" : "No License";
                return new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, License);
            }
            con.close();
            p1.close();
            re.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
        }
        return null;
    }

    //------------------------------------episodes-----------------------------
    public int numberEP(String id) {

        ResultSet re;
        int numberOfEpisodes = 0;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "SELECT COUNT(*)\n"
                    + "FROM \"tbEpisodes\" \n"
                    + "WHERE \"movieID\" = ?";
            PreparedStatement p1 = con.prepareStatement(stm1);
            p1.setString(1, id);
            re = p1.executeQuery();
            if (re.next()) {
                numberOfEpisodes = re.getInt(1);
            }
            con.close();
            p1.close();
            re.close();
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
            String stm1 = "select * from \"tbEpisodes\" where \"MovieID\" = ?";
            PreparedStatement p1 = con.prepareStatement(stm1);
            p1.setString(1, id);
            re = p1.executeQuery();
            while (re.next()) {
                String epId = re.getString("epId");
                String movieId = re.getString("movieId");
                int epNum = re.getInt("epNum");
                int duration = re.getInt("duration");
                String movieLink = re.getString("movieLink");
                return new Episodes(epId, movieId, epNum, duration, movieLink);

            }
            con.close();
            p1.close();
            re.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");

        }
        return null;

    }

    public Episodes getEpisodes(String movieID, int epNum) {
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbEpisodes\" where \"MovieID\" = ? and \"EpNum\" = ? ";
            PreparedStatement p1 = con.prepareStatement(stm1);
            p1.setString(1, movieID);
            p1.setInt(2, epNum);
            re = p1.executeQuery();
            while (re.next()) {
                String epID = re.getString("EpID");
                String movieId = re.getString("MovieID");
                int duration = re.getInt("Duration");
                String movieLink = re.getString("MovieLink");

                // Tạo đối tượng Episode và thêm vào danh sách episodes
                Episodes episode = new Episodes(epID, movieId, epNum, duration, movieLink);
                con.close();
                p1.close();
                re.close();
                return episode;

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
        }
        return null;

    }

    public int getEpisodeCountByMovieId(String movieId) {
        int episodeCount = 0;
        ResultSet re;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "SELECT COUNT(*) AS \"episodeCount\" FROM \"tbEpisodes\" where  \"MovieID\" = ?";
            PreparedStatement p1 = con.prepareStatement(stm1);
            p1.setString(1, movieId);
            // Thực thi câu truy vấn
            re = p1.executeQuery();

            // Lấy kết quả số lượng tập phim
            if (re.next()) {
                episodeCount = re.getInt("episodeCount");
            }

            // Đóng các tài nguyên
            con.close();
            p1.close();
            re.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return episodeCount;
    }

    //trailer
    public String getTrailerByMovieID(String movieId) {
        String trailerLink = null;
        ResultSet re = null;
        Connection con = null;
        PreparedStatement p1 = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select \"TrailerLink\" from  \"tbTrailer\" b where b.\"MovieID\" = ? ";
            p1 = con.prepareStatement(stm1);
            p1.setString(1, movieId);
            re = p1.executeQuery();
            if (re.next()) {
                trailerLink = re.getString("TrailerLink");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
        } finally {
            try {
                con.close();
                p1.close();
                re.close();
            } catch (SQLException ex) {
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return trailerLink;
    }

    public static void main(String[] args) {
        MovieDAO dao = new MovieDAO();
        System.out.println(dao.getTrailerByMovieID("DBS1809"));
//        System.out.println(m.ge.toString());

    }

}
