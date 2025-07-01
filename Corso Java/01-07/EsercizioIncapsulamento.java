import java.util.Scanner;
import java.util.ArrayList;

// Classe Studente 
class Studente {

    // Attributi privati
    private String nome;
    private int voto;
    private int id;

    private static int contatore = 1; // Contatore statico per assegnare ID univoci

    // Costruttore pubblico
    Studente(String nome, int voto) {
        this.nome = nome;
        this.voto = voto;
        this.id = contatore;
        contatore++;
    }

    // Getter per nome
    public String getNome() {
        return nome; // Restituisce il valore contenuto nel campo nome
    }

    // Getter per voto
    public int getVoto() {
        return voto; // Restituisce il valore contenuto nel campo voto
    }

    // Getter per ID
    public int getId() {
        return id;
    }

    // Setter per voto con controllo: solo tra 0 e 10
    public void setVoto(int voto) {
        if (voto < 0 || voto > 10) {
            System.out.println("Errore: il voto deve essere compreso tra 0 e 10.");
        } else {
            this.voto = voto;
        }
    }
}

public class EsercizioIncapsulamento {
    public static void main(String[] args) {

        // Inizializzazione dello Scanner
        Scanner scanner = new Scanner(System.in);

        //Inizializzazione dello Scanner2
        Scanner scanner2 = new Scanner(System.in);

        // Lista dinamica di studenti
        ArrayList<Studente> studenti = new ArrayList<>();

        // Richiesta all'utente quanti utenti inserire
        System.out.print("Quanti studenti vuoi inserire? ");
        int numeroStudenti = scanner.nextInt();

        // Inserimento studenti
        for (int i = 0; i < numeroStudenti; i++) {
            System.out.println("Studente " + (i + 1));

            // Richiesta all'utente di inserire il nome
            System.out.print("Inserisci il nome dello studente: ");
            String nome = scanner2.nextLine();

            // Richiesta all'utente di inserire il voto
            System.out.print("Inserisci il voto dello studente (0-10): ");
            int voto = scanner.nextInt();

            // Controllo che sia un voto valido
            while (voto < 0 || voto > 10) {
                System.out.println("Errore: il voto deve essere compreso tra 0 e 10.");
                System.out.print("Riprova: ");
                voto = scanner.nextInt();
            }

            // Creazione oggetto Studente e aggiunta alla lista
            Studente s = new Studente(nome, voto);

            // Aggiunge all'ArrayList lo studente appena creato
            studenti.add(s);
        }

        // Stampa elenco completo
        System.out.println(" --- Elenco studenti ---");
        for (Studente s : studenti) {
            System.out.println("Nome: " + s.getNome() + " Voto: " + s.getVoto());
        }

        // Ricerca studente per nome
        System.out.print("Inserisci un nome da cercare: ");
        String nomeRicerca = scanner2.nextLine();

        // Vraiabile booleana presupponendo che l'utente non sia stato trovato
        boolean trovato = false;
        for (Studente s : studenti) {
            if (s.getNome().equalsIgnoreCase(nomeRicerca)) {

                // Se è stato trovato stampa questo messaggio
                System.out.println("Studente trovato: -ID: " + s.getId() + " -Voto: " + s.getVoto());
                trovato = true;
            }
        }

        // Se non è stato trovato stampa questo messaggio
        if (!trovato) {
            System.out.println("Nessuno studente trovato con quel nome.");
        }

        // Chiusura dello scanner
        scanner.close();

        // Chiusura del secondo scanner
        scanner2.close();
    }
}
