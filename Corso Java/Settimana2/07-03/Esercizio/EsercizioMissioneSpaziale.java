
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

// Definizione della classe base Astronauta
class Astronauta {
    // Nome dell'astronauta
    protected String nome;
    // Email dell'astronauta
    protected String email;
    // Quantità di ossigeno disponibile
    protected float creditoOssigeno;
    // Numero di azioni svolte dall'astronauta
    protected int azioniSvolte = 0;

    // Costruttore della classe Astronauta
    public Astronauta(String nome, String email) {
        this.nome = nome;
        this.email = email;
        // Rigenera l'ossigeno all'inizio
        rigeneraOssigeno();
    }

    // Metodo per rigenerare l'ossigeno in modo casuale
    public void rigeneraOssigeno() {
        this.creditoOssigeno = new Random().nextFloat() * 100;
    }

    // Metodo per visualizzare i dati dell'astronauta
    public void visualizzaDati() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Credito Ossigeno: " + creditoOssigeno);
    }

    // Metodo per interagire con la stazione spaziale
    public void interagisci(StazioneSpaziale stazione) {
        System.out.println("Interazione base non prevista.");
    }
}

// Definizione della classe Scienziato che estende Astronauta
class Scienziato extends Astronauta {

    // Costruttore della classe Scienziato
    public Scienziato(String nome, String email) {
        super(nome, email);
    }

    // Sovrascrive il metodo interagisci per aggiungere esperimenti
    @Override
    public void interagisci(StazioneSpaziale stazione) {
        if (azioniSvolte < 3) {
            System.out.print("Inserisci il nome dell’esperimento da aggiungere: ");
            String esperimento = EsercizioMissioneSpaziale.scannerTesto.nextLine();
            stazione.aggiungiEsperimento(esperimento);
            azioniSvolte++;
        } else {
            // Dopo 3 azioni, diventa ScienziatoCapo
            ScienziatoCapo capo = new ScienziatoCapo(nome, email);
            capo.interagisci(stazione);
        }
    }
}

// Definizione della classe ScienziatoCapo che estende Scienziato
class ScienziatoCapo extends Scienziato {
    // Costruttore della classe ScienziatoCapo
    public ScienziatoCapo(String nome, String email) {
        super(nome, email);
    }

    // Sovrascrive il metodo interagisci per stampare gli esperimenti
    @Override
    public void interagisci(StazioneSpaziale stazione) {
        System.out.println("Esperimenti nella stazione: ");
        stazione.stampaEsperimenti();
    }
}

// Definizione della classe Ispettore che estende Astronauta
class Ispettore extends Astronauta {

    // Costruttore della classe Ispettore
    public Ispettore(String nome, String email) {
        super(nome, email);
    }

    // Sovrascrive il metodo interagisci per valutare esperimenti
    @Override
    public void interagisci(StazioneSpaziale stazione) {
        if (azioniSvolte < 3) {
            System.out.print("Numero esperimento da valutare (0 - " + (stazione.esperimenti.size() - 1) + "): ");
            int index = EsercizioMissioneSpaziale.scannerNumeri.nextInt();

            System.out.print("Inserisci la valutazione (1-5): ");
            int voto = EsercizioMissioneSpaziale.scannerNumeri.nextInt();

            stazione.aggiungiValutazione(index, voto);
            azioniSvolte++;
        } else {
            // Dopo 3 azioni, diventa IspettoreEsperto
            IspettoreEsperto esperto = new IspettoreEsperto(nome, email);
            esperto.interagisci(stazione);
        }
    }
}

// Definizione della classe IspettoreEsperto che estende Ispettore
class IspettoreEsperto extends Ispettore {
    // Costruttore della classe IspettoreEsperto
    public IspettoreEsperto(String nome, String email) {
        super(nome, email);
    }

    // Sovrascrive il metodo interagisci per stampare le valutazioni
    @Override
    public void interagisci(StazioneSpaziale stazione) {
        System.out.println("Valutazioni attuali:");
        stazione.stampaValutazioni();
    }
}

// Definizione della classe StazioneSpaziale
class StazioneSpaziale {
    // Lista degli esperimenti presenti nella stazione
    ArrayList<String> esperimenti = new ArrayList<>();
    // Lista delle valutazioni associate agli esperimenti
    ArrayList<Integer> valutazioni = new ArrayList<>();

    // Metodo per aggiungere un esperimento
    public void aggiungiEsperimento(String nome) {
        esperimenti.add(nome);
        valutazioni.add(0); // inizialmente senza voto
        System.out.println("Esperimento aggiunto.");
    }

    // Metodo per aggiungere o aggiornare una valutazione
    public void aggiungiValutazione(int index, int valore) {
        if (index >= 0 && index < valutazioni.size() && valore >= 1 && valore <= 5) {
            valutazioni.set(index, valore);
            System.out.println("Valutazione aggiornata.");
        } else {
            System.out.println("Indice o valore non validi.");
        }
    }

    // Metodo per stampare tutti gli esperimenti
    public void stampaEsperimenti() {
        for (int i = 0; i < esperimenti.size(); i++) {
            System.out.println(i + ": " + esperimenti.get(i));
        }
    }

    // Metodo per stampare esperimenti e relative valutazioni
    public void stampaValutazioni() {
        for (int i = 0; i < esperimenti.size(); i++) {
            System.out.println(i + ": " + esperimenti.get(i) + " -> " + valutazioni.get(i));
        }
    }
}

// Definizione della classe principale del programma
public class EsercizioMissioneSpaziale {
    // Scanner statici per leggere input da tastiera
    static Scanner scannerNumeri = new Scanner(System.in);
    static Scanner scannerTesto = new Scanner(System.in);
    // Riferimento all'astronauta attuale
    static Astronauta astronauta = null;
    // Istanza della stazione spaziale
    static StazioneSpaziale stazione = new StazioneSpaziale();

    // Metodo main, punto di ingresso del programma
    public static void main(String[] args) {
        // Variabile per controllare il ciclo del menu
        boolean menu = true;

        // Ciclo principale del menu
        while (menu) {
            System.out.println("--- MENU PRINCIPALE ---");
            System.out.println("1. CREA UN NUOVO ASTRONAUTA");
            System.out.println("2. VISUALIZZA I DATI DELL'ASTRONAUTA");
            System.out.println("3. LOGIN PER RIGENERARE L'OSSIGENO");
            System.out.println("4. INTERAZIONE CON IL PROFILO");
            System.out.println("5. USCIRE DAL PROGRAMMA");
            System.out.print("Scelta: ");

            // Legge la scelta dell'utente
            String scelta = scannerTesto.nextLine();

            // Gestisce la scelta tramite switch
            switch (scelta) {
                case "1":
                    creaAstronauta();
                    break;
                case "2":
                    visualizzaAstronauta();
                    break;
                case "3":
                    login();
                    break;
                case "4":
                    interagisci();
                    break;
                case "5":
                    menu = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
        // Messaggio di fine programma
        System.out.println("Programma terminato.");
    }

    // Metodo per creare un nuovo astronauta
    static void creaAstronauta() {
        System.out.print("Nome: ");
        String nome = scannerTesto.nextLine();

        System.out.print("Email: ");
        String email = scannerTesto.nextLine();

        System.out.print("Pianeta preferito: ");
        String pianeta = scannerTesto.nextLine();

        // Se il pianeta è tra quelli elencati, crea uno Scienziato, altrimenti un
        // Ispettore
        if (pianeta.matches("mercurio|venere|terra|marte|giove|saturno|urano|nettuno")) {
            astronauta = new Scienziato(nome, email);
            System.out.println("Hai creato uno scienziato");
        } else {
            astronauta = new Ispettore(nome, email);
            System.out.println("Hai creato un ispettore");
        }
    }

    // Metodo per visualizzare i dati dell'astronauta
    static void visualizzaAstronauta() {
        if (astronauta != null)
            astronauta.visualizzaDati();
        else
            System.out.println("Nessun astronauta registrato.");
    }

    // Metodo per rigenerare l'ossigeno dell'astronauta
    static void login() {
        if (astronauta != null) {
            astronauta.rigeneraOssigeno();
            System.out.println("Ossigeno rigenerato.");
        } else {
            System.out.println("Crea prima un astronauta.");
        }
    }

    // Metodo per far interagire l'astronauta con la stazione
    static void interagisci() {
        if (astronauta != null)
            astronauta.interagisci(stazione);
        else
            System.out.println("Crea prima un astronauta.");
    }
}
