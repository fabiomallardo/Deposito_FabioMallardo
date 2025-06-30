// Creazione classe Libro
class Libro {
    // contatore 
    static int codice_numerico_autoincrementante = 1;

    // variabili d’istanza
    int codice_numerico;
    String titolo;
    String autore;
    double prezzo;

    Libro() {
        codice_numerico = codice_numerico_autoincrementante++;
    }

    // metodo per stampare i dettagli
    void stampaDettagli() {
        System.out.println(
            "Codice: " + codice_numerico
          + " | Titolo: \"" + titolo + "\""
          + " | Autore: " + autore
          + " | Prezzo: €" + prezzo
        );
    }
}

public class EsercizioClassi {
    public static void main(String[] args) {
        // creo il primo libro
        Libro l1 = new Libro();
        l1.titolo = "Il Piccolo Principe";
        l1.autore = "Antoine de Saint-Exupéry";
        l1.prezzo = 10.99;

        // creo il secondo libro
        Libro l2 = new Libro();
        l2.titolo = "Harry Potter e la Pietra Filosofale";
        l2.autore = "J.K. Rowling";
        l2.prezzo = 12.50;

        // stampo i dettagli di entrambi
        l1.stampaDettagli();
        l2.stampaDettagli();
    }
}
