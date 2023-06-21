/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBConnect;
import entity.Episodes;
import entity.Favorite;
import entity.History;
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

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet re = null;
    //-------------------------------movie------------------------------------
    //get all move
    public ArrayList<Movie> getAllMovie() {

        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbMovie\"";
            ps = con.prepareStatement(stm1);
            re = ps.executeQuery();
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
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    //get list new release based date 
    public ArrayList<Movie> getListNewReleaseMovie() {
//         con = null;
        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re = null;
        try {
             con = DBConnect.makeConnection();
            String stm1 = "select *from \"tbMovie\" ORDER BY \"ReleaseDate\" DESC";
             ps = con.prepareStatement(stm1);
            re = ps.executeQuery();
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
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    //get list popular movie based view acs
    public ArrayList<Movie> getListPopularMovie() {
//         con = null;
        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re = null;
        try {
            Connection con = DBConnect.makeConnection();
            String stm1 = "select *from \"tbMovie\" ORDER BY \"View\" DESC";
            PreparedStatement ps = con.prepareStatement(stm1);
            re = ps.executeQuery();
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
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    //get list live action movie 
    public ArrayList<Movie> getListLiveActionMovie() {
//         con = null;
        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select *from \"tbMovie\" WHERE \"Category\" LIKE '%Live Action%'";
            ps = con.prepareStatement(stm1);
            re = ps.executeQuery();
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
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    //get random movie 
    public ArrayList<Movie> getListRandomMovie() {
//         con = null;
        ArrayList<Movie> result = new ArrayList<>();
        ResultSet re = null;
        try {
             con = DBConnect.makeConnection();
            String stm1 = "select *from \"tbMovie\" ORDER BY NEWID()";
             ps = con.prepareStatement(stm1);
            re = ps.executeQuery();
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
            ps.close();
            re.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    //get movie by id
    public Movie getMovieById(String id) {
        ResultSet re = null;
        try {
             con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbMovie\" where \"MovieID\" = ?";
             ps = con.prepareStatement(stm1);
            ps.setString(1, id);
            re = ps.executeQuery();
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
           
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    //get list popular movie based view acs
    public ArrayList<Movie> getSearchList(String txtSearch) {
        ArrayList<Movie> result = new ArrayList<>();
        
        try {
            con = DBConnect.makeConnection();
            String stm1 = "SELECT * FROM \"tbMovie\" WHERE LOWER(\"MovieName\") LIKE LOWER(?);";
            ps = con.prepareStatement(stm1);
            ps.setString(1, "%" + txtSearch + "%");
            re = ps.executeQuery();
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
                String License = re.getBoolean("License") ? "License" : "No License";
                result.add(new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, License));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<Movie> getAllMovie(String nameFilter, String txtSearch, String viewFilter) {
        List<Movie> result = new ArrayList<>();
        try {
            con = DBConnect.makeConnection();
            String query = "SELECT * FROM \"tbMovie\"";

            if (nameFilter != null && !nameFilter.isEmpty() || (nameFilter != null && !nameFilter.isEmpty() && viewFilter != null)) {
                query = "SELECT * FROM \"tbMovie\" ORDER BY \"MovieName\" " + nameFilter;
            }
            if (viewFilter != null && !viewFilter.isEmpty()) {
                query = "SELECT * FROM \"tbMovie\" ORDER BY \"View\" " + viewFilter;
            }
            if (txtSearch != null && !txtSearch.isEmpty()) {
                query = "SELECT * FROM \"tbMovie\" WHERE LOWER(\"MovieName\") LIKE LOWER(?);";
            }
            if (txtSearch != null && !txtSearch.isEmpty()) {
                ps = con.prepareStatement(query);
                ps.setString(1, "%" + txtSearch + "%");
                re = ps.executeQuery();
            } else {
                ps = con.prepareStatement(query);
                re = ps.executeQuery();
            }

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
                result.add(new Movie(MovieID, MovieName, movieBanner, MovieDescription, ReleaseDate, strCategory, Author, MovieStatus, MovieSeason, View, License));
            }
            re.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    //------------------------------------episodes-----------------------------
    public int numberEP(String id) {

        int numberOfEpisodes = 0;
        try {
             con = DBConnect.makeConnection();
            String stm1 = "SELECT COUNT(*)\n"
                    + "FROM \"tbEpisodes\" \n"
                    + "WHERE \"movieID\" = ?";
             ps = con.prepareStatement(stm1);
            ps.setString(1, id);
            re = ps.executeQuery();
            if (re.next()) {
                numberOfEpisodes = re.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
            return -1;
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return numberOfEpisodes;
    }

    public Episodes getEpbyID(String id) {
        Episodes episodes = null;

        try {
             con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbEpisodes\" where \"MovieID\" = ?";
             ps = con.prepareStatement(stm1);
            ps.setString(1, id);
            re = ps.executeQuery();
            while (re.next()) {
                String epId = re.getString("epId");
                String movieId = re.getString("movieId");
                int epNum = re.getInt("epNum");
                int duration = re.getInt("duration");
                String movieLink = re.getString("movieLink");
                return new Episodes(epId, movieId, epNum, duration, movieLink);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");

        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

    public Episodes getEpisodes(String movieID, int epNum) {
        
        try {
             con = DBConnect.makeConnection();
            String stm1 = "select * from \"tbEpisodes\" where \"MovieID\" = ? and \"EpNum\" = ? ";
             ps = con.prepareStatement(stm1);
            ps.setString(1, movieID);
            ps.setInt(2, epNum);
            re = ps.executeQuery();
            while (re.next()) {
                String epID = re.getString("EpID");
                String movieId = re.getString("MovieID");
                int duration = re.getInt("Duration");
                String movieLink = re.getString("MovieLink");

                // Tạo đối tượng Episode và thêm vào danh sách episodes
                Episodes episode = new Episodes(epID, movieId, epNum, duration, movieLink);              
                return episode;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

    public int getEpisodeCountByMovieId(String movieId) {
        int episodeCount = 0;
        try {
             con = DBConnect.makeConnection();
            String stm1 = "SELECT COUNT(*) AS \"episodeCount\" FROM \"tbEpisodes\" where  \"MovieID\" = ?";
             ps = con.prepareStatement(stm1);
            ps.setString(1, movieId);
            // Thực thi câu truy vấn
            re = ps.executeQuery();

            // Lấy kết quả số lượng tập phim
            if (re.next()) {
                episodeCount = re.getInt("episodeCount");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return episodeCount;
    }

    //trailer
    public String getTrailerByMovieID(String movieId) {
        String trailerLink = null;
        try {
            con = DBConnect.makeConnection();
            String stm1 = "select \"TrailerLink\" from  \"tbTrailer\" b where b.\"MovieID\" = ? ";
            ps = con.prepareStatement(stm1);
            ps.setString(1, movieId);
            re = ps.executeQuery();
            if (re.next()) {
                trailerLink = re.getString("TrailerLink");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("loi r");
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return trailerLink;
    }

    //history
    public void SaveHistory(String userID, String MovieID, int epNum) {

        try {
            String query = " insert into \"tbHistory\" (\"UserID\",\"MovieID\",\"epNum\",\"LastWatched\") values('" + userID + "',?,?,current_timestamp)";

            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, MovieID);
            ps.setInt(2, epNum);
            System.out.println("save history THANH CONG ");

            ps.executeQuery();
        } catch (Exception e) {

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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void UpdateHistory(String userID, String MovieID, int epNum) {
        
        try {
            String query = "update \"tbHistory\"\n"
                    + "SET \"epNum\" = ?, \"LastWatched\" = current_timestamp \n"
                    + "WHERE \"UserID\" = '" + userID + "' AND \"MovieID\" = ?;";

            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);

            ps.setInt(1, epNum);
            ps.setString(2, MovieID);

            System.out.println("update history THANH CONG ");

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //check history already exist or not 
    public boolean checkHistory(String userID, String movieID) {

        
        String query = "SELECT * FROM \"tbHistory\" WHERE \"UserID\" = '" + userID + "' AND \"MovieID\" = ?";

        try {
            con = new DBConnect().makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, movieID);

            re = ps.executeQuery();
            
            boolean hasHistory = re.next();

            return hasHistory;
        } catch (Exception e) {
            System.err.println(e.toString());
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<History> getUserHistory(String userID) {
        List<History> result = new ArrayList<>();
        

        try {
            con = DBConnect.makeConnection();
            String stm1 = "SELECT h.*, m.\"Banner\" ,m.\"MovieName\""
                    + "FROM \"tbHistory\" h "
                    + "JOIN \"tbMovie\" m ON h.\"MovieID\" = m.\"MovieID\" "
                    + "WHERE h.\"UserID\" = '" + userID + "'\n" + " order by \"LastWatched\" desc";
            ps = con.prepareStatement(stm1);
            re = ps.executeQuery();

            while (re.next()) {
                String historyID = re.getString("HistoryID");
                userID = re.getString("UserID");
                String movieID = re.getString("MovieID");
                int epNum = re.getInt("epNum");
                Date lastWatched = re.getDate("LastWatched");
                String movieBanner = re.getString("Banner");
                String movieName = re.getString("MovieName");

                result.add(new History(historyID, userID, movieID, epNum, lastWatched, movieBanner, movieName));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    public void deleteHistory(String movieID, String userID) {

        try {
            con = DBConnect.makeConnection();
            String query = "DELETE FROM \"tbHistory\" WHERE \"MovieID\" = ? and \"UserID\" = '" + userID + "'";
            ps = con.prepareStatement(query);
            ps.setString(1, movieID);
            ps.executeUpdate();
            System.out.println("delete history successful");
        } catch (SQLException e) {
            System.err.println(e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //favorite
    public void SaveFavorite(String userID, String movieID) {

        try {
            String query = "INSERT INTO \"tbFavorite\" (\"UserID\", \"MovieID\", \"FavDate\") VALUES ('" + userID + "', ?, current_date)";

            con = DBConnect.makeConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, movieID);
            ps.executeUpdate();
            System.out.println("Save favorite SUCCESS");
        } catch (ClassNotFoundException | SQLException e) {
            // Xử lý exception nếu cần
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Favorite> getUserFavorite(String userID) {
        List<Favorite> result = new ArrayList<>();

        try {
            con = DBConnect.makeConnection();
            String stm1 = "SELECT f.*, m.\"Banner\", m.\"MovieName\"\n"
                    + "FROM \"tbFavorite\" f\n"
                    + "JOIN \"tbMovie\" m ON f.\"MovieID\" = m.\"MovieID\"\n"
                    + "WHERE f.\"UserID\" = '" + userID + "'\n"
                    + "ORDER BY f.\"FavDate\" DESC";
            ps = con.prepareStatement(stm1);
            re = ps.executeQuery();

            while (re.next()) {
                String favoriteID = re.getString("FavoriteID");
                userID = re.getString("UserID");
                String movieID = re.getString("MovieID");
                Date favDate = re.getDate("FavDate");
                String movieBanner = re.getString("Banner");
                String movieName = re.getString("MovieName");

                result.add(new Favorite(favoriteID, userID, movieID, movieBanner, movieName, favDate));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    public void deleteFavorite(String userID,String movieID ) {

        try {
            con = DBConnect.makeConnection();
            String query = "DELETE FROM \"tbFavorite\" WHERE \"MovieID\" = ? AND \"UserID\" = '"+userID+"'";
            ps = con.prepareStatement(query);
            ps.setString(1, movieID);
            ps.executeUpdate();
            System.out.println("Delete favorite successful");
        } catch (SQLException e) {
            System.err.println(e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean checkFavorite(String userID, String movieID) {

        try {
            con = DBConnect.makeConnection();
            String query = "SELECT * FROM \"tbFavorite\" WHERE \"UserID\" = '"+userID+"' AND \"MovieID\" = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, movieID);

            re = ps.executeQuery();

            boolean hasFavorite = re.next();

            return hasFavorite;
        } catch (SQLException e) {
            System.err.println(e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return false;
    }
    
    
    public void increaseView(String movieID) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet re = null;

        try {
            con = DBConnect.makeConnection();
            String query = "update \"tbMovie\" \n"
                    + "set \"View\" = \"View\" + 1\n"
                    + "where \"MovieID\" = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, movieID);
            ps.executeUpdate();
            System.out.println("Increase view successful");
        } catch (SQLException e) {
            System.err.println(e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) {
        MovieDAO dao = new MovieDAO();
        System.out.println(dao.getUserFavorite("c48ca6d8-0e7f-4087-a72f-968c6c82d0fb").toString());
        dao.deleteFavorite("c48ca6d8-0e7f-4087-a72f-968c6c82d0fb","KYB201");
        System.out.println(dao.getUserFavorite("c48ca6d8-0e7f-4087-a72f-968c6c82d0fb").toString());
    }
}

