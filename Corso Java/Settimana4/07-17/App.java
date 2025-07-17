package com.example;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila"; 
        String user = "root";       
        String password = "";       

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connessione riuscita");

            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery("SELECT title FROM film LIMIT 5");

            while (rs.next()) {
                System.out.println("Film: " + rs.getString("title")); 
            }
        } catch (SQLException e) {
            System.out.println("Errore nella connessione");
            e.printStackTrace();
        }
    }
}
