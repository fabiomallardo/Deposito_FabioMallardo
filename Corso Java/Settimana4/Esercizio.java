package com.example;

import java.sql.*;
import java.util.Scanner;

public class Esercizio {
    public static void main(String[] args) {

        // URL della connessione al database
        String url = "jdbc:mysql://localhost:3306/sakila";

        // Nome utente per accedere al database
        String user = "root";

        // Password per accedere al database
        String password = "";

        
        try (

            // Oggetto Connection per collegarsi al database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Inizializzo lo scanner per l'input
            Scanner scanner = new Scanner(System.in)
        ) {

            System.out.println("Connessione riuscita al database Sakila!");

            // Variabile di controllo per il ciclo del menu
            boolean running = true;

            // Ciclo del menu, finché l’utente non sceglie di uscire
            while (running) {
                System.out.println("--- MENU ---");
                System.out.println("1. Mostra i 10 film più noleggiati");
                System.out.println("2. Mostra tutti i film ordinati dal meno al più noleggiato");
                System.out.println("0. Esci");
                System.out.print("Scelta: ");

                int scelta = scanner.nextInt();

                // Switch per gestire la scelta dell’utente
                switch (scelta) {

                    // Se sceglie 1 chiama metodo per mostrare i 10 film più noleggiati
                    case 1 -> mostraTop10FilmNoleggiati(conn);

                    // Se sceglie 2 chiama metodo per ordinare tutti i film in base al numero di noleggi
                    case 2 -> mostraFilmDalMenoAlPiuNoleggiato(conn);

                    // Se sceglie 0 termina il ciclo e quindi esce dal programma
                    case 0 -> running = false;

                    
                    default -> System.out.println("Scelta non valida. Riprova.");
                }
            }

        
        } catch (SQLException e) {
            System.out.println("Errore nella connessione o esecuzione SQL");
            e.printStackTrace(); 
        }
    }

    // Metodo che esegue una query per recuperare i 10 film più noleggiati
    private static void mostraTop10FilmNoleggiati(Connection conn) throws SQLException {

        // Query SQL per selezionare i titoli dei film e il numero di noleggi, ordinati dal più al meno noleggiato
        String query = """
            SELECT 
            film.title, COUNT(*) AS Noleggi
            FROM rental 
            JOIN inventory  ON rental.inventory_id = inventory.inventory_id
            JOIN film  ON inventory.film_id = film.film_id
            GROUP BY film.film_id
            ORDER BY noleggi DESC
            LIMIT 10
        """;

        // Crea un oggetto Statement per eseguire la query
        try (
            Statement stmt = conn.createStatement();

            // Esegue la query e ottiene un ResultSet con i risultati
            ResultSet rs = stmt.executeQuery(query)
        ) {
            System.out.println("--- I 10 film più noleggiati ---");

            // Scorre tutte le righe del result-set
            while (rs.next()) {

                // Recupera il titolo del film dalla colonna "title"
                String titolo = rs.getString("title");

                // Recupera il numero di noleggi dalla colonna "noleggi"
                int count = rs.getInt("noleggi");

                System.out.println(titolo + " - " + count + " noleggi");
            }
        }
    }

    // Metodo che esegue una query per mostrare tutti i film dal meno al più noleggiato
    private static void mostraFilmDalMenoAlPiuNoleggiato(Connection conn) throws SQLException {

        // Query SQL per selezionare tutti i film con conteggio dei noleggi, inclusi quelli mai noleggiati (grazie a LEFT JOIN)
        String query = """
            SELECT film.title, COUNT(rental.rental_id) AS Noleggi
            FROM film 
            LEFT JOIN inventory  ON film.film_id = inventory.film_id
            LEFT JOIN rental  ON inventory.inventory_id = rental.inventory_id
            GROUP BY film.film_id
            ORDER BY noleggi ASC
        """;

        // Crea lo Statement per eseguire la query
        try (
            Statement stmt = conn.createStatement();

            // Esegue la query e ottiene il result-set
            ResultSet rs = stmt.executeQuery(query)
        ) {
            System.out.println("--- Tutti i film ordinati dal meno al più noleggiato ---");

            // Scorre tutti i risultati
            while (rs.next()) {

                // Recupera il titolo del film
                String titolo = rs.getString("title");

                // Recupera il numero di noleggi
                int count = rs.getInt("noleggi");

                System.out.println(titolo + count + " noleggi");
            }
        }
    }
}
