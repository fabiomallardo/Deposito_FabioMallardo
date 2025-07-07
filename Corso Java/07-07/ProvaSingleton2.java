// Classe di esempio che rappresenta una Dipendenza
class Dipendenza2 {
    public void esegui() {
        System.out.println("Dipendenza: Avvio esecuzione...");

        // Accesso al Singleton Logger dall'interno della Dipendenza
        ProvaSingleton2 logger = ProvaSingleton2.getInstance();
        logger.log("Messaggio inviato dalla Dipendenza.");
    }
}

// Definizione della classe Logger come Singleton
public class ProvaSingleton2 {

    // Istanza privata statica della classe Logger
    private static ProvaSingleton2 instance;

    // Dipendenza associata al Logger (opzionale, per esempio)
    private Dipendenza2 dipendenza;

    // Costruttore privato per impedire l'istanziazione diretta
    private ProvaSingleton2() {
        // Inizializzazione della dipendenza (può essere spostata anche altrove, qui è di esempio)
        dipendenza = new Dipendenza2();
    }

    // Metodo pubblico statico per ottenere l'unica istanza di Logger
    public static ProvaSingleton2 getInstance() {
        if (instance == null) {
            instance = new ProvaSingleton2();
        }
        return instance;
    }

    // Metodo per stampare un messaggio di log
    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }

    // Metodo per far eseguire la dipendenza
    public void eseguiDipendenza() {
        dipendenza.esegui();
    }

    // Metodo di esempio che mostra il ciclo completo
    public static void main(String[] args) {
        // Otteniamo l'istanza Singleton e logghiamo un messaggio
        ProvaSingleton2 logger = ProvaSingleton2.getInstance();
        logger.log("Logger pronto all'uso.");

        // Usiamo la dipendenza attraverso il Logger
        logger.eseguiDipendenza();
    }
}
