// Classe base
class Persona {
    protected String nome; 

    public Persona(String nome) { // Costruttore della classe base
        this.nome = nome; // Inizializza il nome
    }

    public void saluta() { // Metodo per salutare
        System.out.println("Ciao, sono " + nome); // Stampa un saluto con il nome
    }
}

// Classe derivata
class Alunno extends Persona {
    private String scuola;

    public Alunno(String nome, String scuola) { // Costruttore della classe derivata
        super(nome); // Chiama il costruttore della classe base
        this.scuola = scuola; // Inizializza la scuola
    }

    public void saluta() { // Override del metodo saluta
        super.saluta(); // Chiama il metodo saluta della classe base
        System.out.println("Vado alla scuola " + scuola); // Stampa la scuola frequentata
    }
}

// Classe principale con il main
public class ProvaSuper {
    public static void main(String[] args) { // Metodo principale
        Alunno a = new Alunno("Luca", "ITIS Informatico"); // Crea un oggetto Alunno
        a.saluta(); // Chiama il metodo saluta sull'oggetto Alunno
    }
}
