package EsercizioSingleton2;

// Definizione della classe DatabaseManager come Singleton
public class DatabaseManager {
    
    // Instanza privata statica della classe DatabaseManager
    private static DatabaseManager instanza;

    //Attributo privato che tiene traccia delle connessioni
    private int contatoreConnessioni = 0;

    // Costruttore privato per impedire l'istanziazione diretta
    private DatabaseManager(){}

    // Metodo pubblico statico per ottenere l'unica istanza di DatabaseManaher
    public static DatabaseManager getInstanza(){

        // Se l'istanza non esiste, viene creata
        if (instanza == null){
            instanza = new DatabaseManager();
        }

        // restituisce l'istanza esistente
        return instanza;
    }

   
    
    // metodo per simulare una connessione al DB
    public void connect(){
      contatoreConnessioni++;
      System.out.println("--- Connessione stabilita. Connessioni attive: " + contatoreConnessioni);
    }

    // metodo che restituisce le connessioni effettuate
    public int getConnectionCount(){
        return contatoreConnessioni;
    }
}

