import java.util.Scanner;

// classe astratta Cadetto
abstract class Cadetto {

    // Attributi protetti
    protected String nome;

    // Costruttore
    public Cadetto(String nome) {
        this.nome = nome;
    }

    // Metodo per presentarsi
    public abstract void presentati();
}

// classe Pilota che estende Cadetto
class Astronauta extends Cadetto {

    // Attributi privati
    private int oreDiVolo;

    // Costruttore
    public Astronauta(String nome, int oreDiVolo) {
        super(nome);
        this.oreDiVolo = oreDiVolo;
    }

    @Override // Sovrascrizione del metodo per presentarsi
    public void presentati() {
        System.out.println("Sono l' Astronauta " + nome + " con " + oreDiVolo + " ore di volo.");
    }
}

// classe Ingegnere che estende Cadetto
class TecnicoDiBordo extends Cadetto {

    // Attributi privati
    private String specializzazione;

    // Costruttore
    public TecnicoDiBordo(String nome, String specializzazione) {
        super(nome);
        this.specializzazione = specializzazione;
    }

    @Override // Sovrascrzione del metodo per presentarsi
    public void presentati() {
        System.out.println("Sono il Tecnico di bordo  " + nome + ", specializzato in " + specializzazione + ".");
    }
}

// classe Medico che estende Cadetto
class Medico extends Cadetto {

    // Attributi privati
    private String reparto;

    // Costruttore
    public Medico(String nome, String reparto) {
        super(nome);
        this.reparto = reparto;
    }

    @Override // Sovrascrzione del metodo per presentarsi
    public void presentati() {
        System.out.println("Sono il medico " + nome + " del reparto " + reparto + ".");
    }
}

public class Esercizio3 {
    public static void main(String[] args) {

        // Inizializzazione scanner
        Scanner scanner = new Scanner(System.in);

        // Dichiarazione della variabile null
        Cadetto cadetto = null;

        // Richiesta all'utente di inserire il nome del cadetto
        System.out.print("Inserisci il nome del cadetto: ");
        String nome = scanner.nextLine();

        // Richietsa all'utente di scegliere il tipo di cadetto
        System.out.print("Scegli il tipo di cadetto (1 = Astronauta, 2 = Ingegnere, 3 = Tecnico di bordo ): ");
        int scelta = scanner.nextInt();

        switch (scelta) {
            // Se sceglie l'Astronauta
            case 1:

                // Richiesta di inserire le ore di volo
                System.out.print("Inserisci le ore di volo: ");
                int ore = scanner.nextInt();

                // Creazione dlel'oggetto Astronauata
                cadetto = new Astronauta(nome, ore);
                break;

            // Se sceglie il tecnico di brodo
            case 2:

                // Richiesta all'utente di inserire la specializzazione
                System.out.print("Inserisci la specializzazione: ");
                String specializzazione = scanner.nextLine();

                // Creazione oggetto tecnico di bordo
                cadetto = new TecnicoDiBordo(nome, specializzazione);
                break;

            // Se sceglie il medico
            case 3:

                // Richietsa all'utemte di inserire il reparto
                System.out.print("Inserisci il reparto: ");
                String reparto = scanner.nextLine();

                // Creazione oggetto medico
                cadetto = new Medico(nome, reparto);
                break;

            // Nel caso in cui avesse non scelto uno di questi tre lavori
            default:
                System.out.println("Scelta non valida. Fine programma.");
        }

        // Chiamo il metodo per far presentare il cadetto
        cadetto.presentati();

        // Chiusura scanner
        scanner.close();
    }
}
