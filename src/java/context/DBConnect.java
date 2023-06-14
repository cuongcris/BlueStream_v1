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

    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        try {
            //bluestream1
//       String url = "jdbc:postgresql://db.fncwirfhmyudeqvocfyh.supabase.co:5432/postgres";

//bluestseam2            
            String url = "jdbc:postgresql://db.owsuwykdxwxkmkcrvlvb.supabase.co:5432/postgres";
            String username = "postgres";
            String password = "Bluestream123@";

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connect Successful.");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
