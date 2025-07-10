import java.util.Scanner;
import java.util.ArrayList;

class Hamburger {

    // Attributo protetto
    protected String nome;

    // Costruttore
    public Hamburger(String nome) {
        this.nome = nome;
    }

    // Metodo che stampa il procedimento di preparazione
    void prepara() {
        System.out.println("Questo è il procedimento di preparazione:");
    }

    // Metodo che restituisce il nome del panino
    public String getNome() {
        return nome;
    }
}

// Classe Cheeseburger che estende Hamburger
class Cheeseburger extends Hamburger {

    public Cheeseburger() {
        super("Cheeseburger");
    }

    @Override
    void prepara() { // Sovrascrivo il metodo che ho creato prima per ottenere il nome del panino più
                     // gli ingredienti
        System.out.println("Preparazione " + getNome() + ": pane, carne, formaggio, ketchup");
    }
}

// Classe VegBurger che estende Hamburger
class VegBurger extends Hamburger {

    public VegBurger() {
        super("VegBurger");
    }

    @Override
    void prepara() { // Sovrascrivo il metodo che ho creato prima per ottenere il nome del panino più
                     // gli ingredienti
        System.out.println("Preparazione " + getNome() + ": pane integrale, burger vegetale, insalata, pomodoro");
    }
}

// Classe DoubleBacon che estende Hamburger
class DoubleBacon extends Hamburger {

    public DoubleBacon() {
        super("DoubleBacon");
    }

    @Override
    void prepara() { // Sovrascrivo il metodo che ho creato prima per ottenere il nome del panino più
                     // gli ingredienti
        System.out.println("Preparazione " + getNome() + ": pane, doppia carne, bacon, cheddar, maionese");
    }
}

public class EsercizioHamburgeria {

    public static void main(String[] args) {

        // Inizializzo lo Scanner per l'input
        Scanner scanner = new Scanner(System.in);

        // Creo l'ArrayList dei panini
        ArrayList<Hamburger> panini = new ArrayList<>();

        // Variabile che serve per il menu
        boolean menu = true;

        System.out.println("--- BENVENUTO IN QUESTA HAMBURGERIA ---");

        while (menu) {
            System.out.println(" --- SCEGLI IL PANINO CHE VUOI ORDINARE : --- ");
            System.out.println("1. CHEESEBURGER ");
            System.out.println("2. VEGBURGER ");
            System.out.println("3. DOUBLEBACON ");

            // Scelta dell'utente
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":

                    // Aggiungo all'array
                    panini.add(new Cheeseburger());

                    // Stampo il panino scelto
                    System.out.println("Hai ordinato un Cheeseburger.");
                    break;
                case "2":

                    // Aggiungo all'array
                    panini.add(new VegBurger());

                    // Stampo il panino scelto
                    System.out.println("Hai ordinato un VegBurger.");
                    break;
                case "3":

                    // Aggiungo all'array
                    panini.add(new DoubleBacon());

                    // Stampo il panino scelto
                    System.out.println("Hai ordinato un DoubleBacon.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    continue;
            }

            // Dopo ogni ordine, chiedi se vuole ordinare altro o uscire
            System.out.println("--- VUOI ORDINARE UN ALTRO PANINO ? --- ");
            System.out.println("1. Sì ");
            System.out.println("2. NO, PREPARA L'ORDINE ED ESCI ");

            String risposta = scanner.nextLine();

            if (risposta.equals("2")) {
                menu = false;
            }
        }

        // Prepara tutti i panini ordinati
        System.out.println("--- PREPARAZIONE ORDINE ---");
        for (Hamburger h : panini) {
            h.prepara(); // Richiamo il metodo che stampa la preparazione e il nome del panino con gli
                         // ingredienti
        }

        // Stampa finale
        System.out.println("Grazie per aver ordinato!");

        // Chiusuar scanner
        scanner.close();
    }
}
