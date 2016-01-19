package databaseconnection;

/**
 *
 * @author ajh3
 */
import java.sql.*;  // for standard JDBC programs
import java.math.*; // for BigDecimal and BigInteger support

public class DatabaseConnection {

    //Just some methods i will update to show how to return/insert and delete info
    public void insert() {
        
    }
    public void getInfo(){
        
    }

    public static void main(String[] args) {
        //Change cs1.ucc.ie to your own server
        //Change 3306 to a port number 
        String url = "jdbc:mysql://cs1.ucc.ie:3306/";
        //Change this to the database name NOT THE DATABASE TABLE NAME
        String dbName = "2016_ajh3";
        
        String driver = "com.mysql.jdbc.Driver";
        //insert username that you would use to connect to the database 
        String userName = "";
        //insert password that you would use to connect to the database
        String password = "";

        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  WinLoss");
            while (res.next()) {
                int id = res.getInt("UserID");
                int gamesPlayed = res.getInt("GamesPlayed");
                int wins = res.getInt("Win");
                int losses = res.getInt("Loss");

                System.out.println(id + "\t" + gamesPlayed + "\t" + wins + "\t" + losses);
            }
//  always close the connection
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
