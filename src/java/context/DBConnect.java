/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBConnect {
    
    public static Connection makeConnection() throws ClassNotFoundException {

        try {
            String serverName = "localhost";
            String databaseName = "QL_BlueStream";
            String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName + ";encrypt=false";
            String username = "sa";
            String password = "sa";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = (Connection) DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException e) {
            e.getMessage();
            return null;
        }

    }
}
