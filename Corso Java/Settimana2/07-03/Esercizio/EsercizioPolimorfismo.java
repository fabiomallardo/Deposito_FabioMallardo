class Persona {
    
    // Attributo protetto
    protected String nome;

    // Costruttore
    Persona(String nome) {
        this.nome = nome;
    }

    // Metodo per salutare
    void Saluta() {
        System.out.println("Ciao, sono " + nome);
    }
}

// Classe derivata
class Pirata extends Persona {

    // Costruttore
    Pirata(String nome) {
        super(nome);
    }

    // Override del metodo Saluta
    @Override
    void Saluta() {
        System.out.println("Sono il pirata " + nome + "!");
    }
}

// Classe principale
public class EsercizioPolimorfismo {

    public static void main(String[] args) {

        // Oggetti di tipo Persona
        Persona persona1 = new Persona("Luca");
        Persona persona2 = new Persona("Giulia");

        persona1.Saluta();  
        persona2.Saluta();  

        // Oggetto Pirata
        Persona pirata = new Pirata("Barbanera");
        Persona pirata2 = new Pirata("Barbarossa");

        
        pirata.Saluta();    
        pirata2.Saluta();
    }
}
