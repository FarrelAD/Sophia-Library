package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class data {
    static String DB_URL = "jdbc:mysql://localhost:3306/sophia_library";
    static String DB_USER = "root";
    static String DB_PASS = "";
    static Connection conn;
    static Statement stmt;

    // Make connection to the MySQL database
    public static void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // For monitoring - CONNECTION [!]
            // System.out.println("CONNECTION TO THE DATABASE SUCCESSFULLY!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to add new data to the database
    public static void addToDatabase(String sqlQuery) {
        try (Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sqlQuery);

            // For monitoring - ADD NEW DATA [!]
            // System.out.println("TRY TO ADD NEW DATA!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
