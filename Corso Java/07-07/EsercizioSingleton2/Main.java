package EsercizioSingleton2; 


import java.util.Scanner; 

public class Main { 

    public static void main(String[] args) { 

        // Crea uno scanner per leggere input 
        Scanner scanner = new Scanner(System.in); 
        
        // Variabile di controllo per il ciclo del menu
        boolean menu = true; 

        // Ottiene l'istanza singleton di DatabaseManager
        DatabaseManager databaseManager = DatabaseManager.getInstanza(); 

        // Ciclo principale del menu
        while (menu) { 

            // Stampa il titolo del menu
            System.out.println("\n--- MENU PRINCIPALE: --- "); 
            
            // Opzione 1: crea elemento
            System.out.println("1. CREA"); 
            
            // Opzione 2: usa elemento
            System.out.println("2. USA"); 
            
            // Opzione 3: cancella elemento
            System.out.println("3. CANCELLA"); 
            
            // Opzione 4: mostra stato connessioni
            System.out.println("4. STATO CONNESSIONI"); 
            
            // Opzione 5: esci dal programma
            System.out.println("5. ESCI"); 
            
            // Chiede all'utente di selezionare un'opzione
            System.out.print("Seleziona: "); 

            String scelta = scanner.nextLine(); 


            // Gestisce la scelta tramite switch
            switch (scelta) { 

                case "1":
                // Verifica la connessione
                    if (checkConnection()) { 
                    
                        // Chiama il metodo per creare elemento
                        creaElemento(databaseManager); 
                        
                    } else {
                        // Messaggio di errore se connessione assente
                        System.out.println("Errore: connessione assente. Riprova più tardi."); 
                    }
                    break;

                case "2":
                // Verifica la connessione
                    if (checkConnection()) { 
                    
                        // Chiama il metodo per usare elemento
                        usaElemento(databaseManager); 
                        
                    } else {
                        // Messaggio di errore se connessione assente
                        System.out.println("Errore: connessione assente. Impossibile usare l’elemento."); 
                    }
                    break;

                case "3":
                // Verifica la connessione
                    if (checkConnection()) { 
                    
                        // Chiama il metodo per cancellare elemento
                        cancellaElemento(databaseManager); 
                        
                    } else {
                        // Messaggio di errore se connessione assente
                        System.out.println("Errore: connessione assente. Impossibile cancellare."); 
                    }
                    break;

                case "4":
                // Chiama il metodo per stampare lo stato delle connessioni
                    stampaStato(databaseManager); 
                    break;

                case "5":
                // Messaggio di uscita
                    System.out.println("Uscita in corso..."); 
                    
                    // Imposta menu a false per uscire dal ciclo
                    menu = false; 
                    break;

                default:
                // Messaggio per opzione non valida
                    System.out.println("Opzione non valida, riprova."); 
                    break;
            }
        }

        // Chiude lo scanner 
        scanner.close(); 
    }

    // Metodo per verificare la connessione 
    private static boolean checkConnection() { 

        // Personalizza qui la logica reale di connessione
        return false; 
    }

    // Metodo per creare un elemento
    private static void creaElemento(DatabaseManager db) { 

        // Simula la connessione al database
        db.connect(); 
        
        // Messaggio di conferma
        System.out.println("Elemento creato con successo."); 
    }

    // Metodo per usare un elemento
    private static void usaElemento(DatabaseManager db) { 

        // Simula la connessione al database
        db.connect(); 
        
        // Messaggio di conferma
        System.out.println("Elemento usato con successo."); 
    }

    // Metodo per cancellare un elemento
    private static void cancellaElemento(DatabaseManager db) { 

        // Simula la connessione al database
        db.connect(); 
        
        // Messaggio di conferma
        System.out.println("Elemento cancellato con successo."); 
    }

    // Metodo per stampare lo stato delle connessioni
    private static void stampaStato(DatabaseManager db) { 

        // Stampa il numero di connessioni
        System.out.println("Numero totale di connessioni: " + db.getConnectionCount()); 
    }
}
