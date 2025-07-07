// Classe di esempio che rappresenta una Dipendenza
class Dipendenza {
    public void stampa() {
        System.out.println("Dipendenza: Sto lavorando...");

        // Accesso al Singleton dall'interno della Dipendenza
        Singleton singleton = Singleton.getInstance();
        singleton.messaggioInterno();
    }
}

// Definizione della classe Singleton
class Singleton {

    // Istanza privata statica della classe Singleton
    private static Singleton instance;

    // Dipendenza associata al Singleton
    private Dipendenza dipendenza;

    // Costruttore privato per impedire l'istanziazione diretta
    private Singleton() {
        
        // Inizializzazione della dipendenza all'interno del Singleton
        dipendenza = new Dipendenza();
    }

    // Metodo pubblico statico per ottenere l'unica istanza della classe
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Metodo di esempio che può essere chiamato sull'istanza Singleton 
    public void doSomething() {
        System.out.println("Singleton: doSomething() chiamato");
        dipendenza.stampa();
    }

    // Metodo richiamabile dalla Dipendenza
    public void messaggioInterno() {
        System.out.println("Singleton: Sono stato chiamato dalla Dipendenza!");
    }
}


// Classe con il metodo main per eseguire il programma
public class ProvaSingleton {
    public static void main(String[] args) {
        // Otteniamo l'istanza Singleton e la usiamo
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }
}
