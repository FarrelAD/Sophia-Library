package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

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

    // Method to show the database
    public static void showDatabase(String sqlQuery) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + " | " + rs.getInt(5) + " | " + rs.getLong(6) + " | " + rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to update the data from database
    public static String updateDatabase(String sqlQuery, String bookId) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlQuery);

            // Query to show updated data
            String queryShowUpdatedData = "SELECT * FROM sophia_books WHERE book_id = '" + bookId + "'";
            ResultSet rs = stmt.executeQuery(queryShowUpdatedData);

            StringBuilder result = new StringBuilder();
            if (rs.next()) {
                result.append(rs.getString(1))
                .append(" | ")
                .append(rs.getString(2))
                .append(" | ")
                .append(rs.getString(3))
                .append(" | ")
                .append(rs.getString(4))
                .append(" | ")
                .append(rs.getInt(5))
                .append(" | ")
                .append(rs.getLong(6))
                .append(" | ")
                .append(rs.getString(7))
                .append("\n");
            } else {
                return "[!] THE DATA CANNOT FIND [!]";
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
