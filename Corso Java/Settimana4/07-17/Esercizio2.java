package com.example;

import java.sql.*;
import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);

                // Inizializzazione dello scanner
                Scanner scanner = new Scanner(System.in);) {
            System.out.println("Connessione riuscita");

            // Variabile per il menu
            boolean menu = true;

            // while per il controllo del ciclo del menu
            while (menu) {
                System.out.println("--- MENU ---");
                System.out.println("1. Mostra tutti i clienti che iniziano con la lettera A");
                System.out.println("2. Conta quanti clienti sono registrati in ogni città");
                System.out.println("3. Mostra i 5 clienti più recenti");
                System.out.println("4. Ordine clienti");
                System.out.println("0. Esci");
                System.out.print("Inserisci cosa vuoi cercare: ");

                // Scelta dell'utente
                int scelta = scanner.nextInt();

                // Gestiamo la scelta dell'utente con uno switch
                switch (scelta) {
                    case 1:
                        // Chiamo il metodo per mostrare i clienti che iniziano con A
                        mostraINomiCheInizianoConLaA(conn);
                        break;
                    case 2:
                        // Chiamo il metodo che mostra il totale dei clienti in ogni città
                        numeroClientiInOgniCitta(conn);
                        break;
                    case 3:
                        // Chiamo il metodo che mostra 5 clienti più recenti
                        mostra5Clienti(conn);
                        break;
                    case 4:
                        // Chiamo il metodo che ordina i clienti
                        nomeUtentePiuVecchio(conn);
                        break;
                    case 0:
                        menu = false;
                        System.out.println("Programma chiuso. Buona giornata.");
                        break;
                    default:
                        System.out.println("Scelta non valida. Inserire un numero giusto.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Errore nella connessione");
            e.printStackTrace();
        }
    }

    // Metodo che mostra i clienti che iniziano per A
    private static void mostraINomiCheInizianoConLaA(Connection conn) throws SQLException {

        // Query
        String query = """
                SELECT
                customer.FIRST_NAME AS Nome
                FROM
                customer
                WHERE customer.FIRST_NAME LIKE 'A%';
                                """;
        // Crea un oggetto Statement per eseguire la query
        try (
                Statement stmt = conn.createStatement();

                // Esegue la query e ottiene un ResultSet con i risultati
                ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("--- I nomi che iniziano con la lettera A sono: ---");

            // Scorre tutte le righe del result-set
            while (rs.next()) {

                // Recupera i nomi
                String nome = rs.getString("Nome");

                System.out.println(nome);
            }
        }
    }

    // Metodo che conta quanti clienti ci sono in ogni città
    private static void numeroClientiInOgniCitta(Connection conn) throws SQLException {

        // Query
        String query = """
                SELECT
                city.city AS Città,
                COUNT(customer.customer_id) AS NumeroClienti
                FROM customer
                JOIN address ON customer.address_id = address.address_id
                JOIN city ON address.city_id = city.city_id
                GROUP BY city.city
                ORDER BY NumeroClienti DESC;
                                """;
        // Crea un oggetto Statement per eseguire la query
        try (
                Statement stmt = conn.createStatement();

                // Esegue la query e ottiene un ResultSet con i risultati
                ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("--- Il totale degli utenti in ogni città è: ---");

            // Scorre tutte le righe del result-set
            while (rs.next()) {

                // Recupero il nome delle città
                String nomeCittà = rs.getString("Città");

                // Recupero il totale
                int totale = rs.getInt("NumeroClienti");

                System.out.println("La città è: " + nomeCittà + ". Il totale è: " + totale);
            }
        }
    }

    // Metodo che mostra i 5 nomi dei clienti più recenti
    private static void mostra5Clienti(Connection conn) throws SQLException {

        // Query
        String query = """
                SELECT
                customer.first_name AS Nome,
                customer.last_name AS Cognome,
                customer.create_date AS DataCreazione
                FROM
                customer
                ORDER BY customer.create_date DESC
                LIMIT 5;

                                                """;
        // Crea un oggetto Statement per eseguire la query
        try (
                Statement stmt = conn.createStatement();

                // Esegue la query e ottiene un ResultSet con i risultati
                ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("--- Ecco i 5 utenti più recenti: ---");

            // Scorre tutte le righe del result-set
            while (rs.next()) {

                // Recupero il nome dell'utente
                String nome = rs.getString("Nome");

                // Recupero il cognome dell'utente
                String cognome = rs.getString("Cognome");

                // Recupero la data di creazione
                String data = rs.getString("DataCreazione");

                System.out.println(
                        "Il nome è: " + nome + ". Il cognome è: " + cognome + ". La Data di creazione è: " + data);
            }
        }
    }

    // Metodo che ordina i clienti dal iù vecchio al più recente e visualizza nome e
    // data
    private static void nomeUtentePiuVecchio(Connection conn) throws SQLException {

        // query
        String query = """
                SELECT
                customer.FIRST_NAME AS Nome,
                customer.LAST_NAME AS Cognome,
                customer.CREATE_DATE AS DataCreazione
                FROM
                customer
                ORDER BY
                customer.CREATE_DATE ASC;
                                """;
  
    try (
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query)
    ) {
        System.out.println("--- Tutti i clienti ordinati dal più vecchio al più recente: ---");

        while (rs.next()) {
            String nome = rs.getString("Nome");
            String cognome = rs.getString("Cognome");
            Timestamp data = rs.getTimestamp("DataCreazione");

            System.out.println(nome + " " + cognome + " : creato il " + data);
        }
    }
}
}