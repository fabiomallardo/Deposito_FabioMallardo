package EsercizioSingleton;

// Definizione della classe Logger come Singleton
public class Logger {

    // Istanza privata statica della classe Logger
    private static Logger istanza;

    // Costruttore privato per impedire l'instanzazione diretta
    private Logger() {};

    // Metodo statico pubblico che restituisce la stesssa istanza
    public static Logger getIstanza() {

        // Se l'istanza non esiste viene creata
        if (istanza == null) {
            istanza = new Logger();
        }
        return istanza;
    }

    // Metodo che stampa il messaggio con data e ora
    public void scriviMessaggio(String nuovoMessaggio) {
        System.out.println("Sono le 16:15 del 7 Luglio");
    }
}
