import java.util.Scanner;
import java.util.ArrayList;

// Creazione classe Aereo 
class Aereo {

    // Attributi privati
    private String modello;
    private int numeroPosti;
    private String codice;

    // Costruttore
    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        this.numeroPosti = numeroPosti;
        this.codice = codice;
    }

    // Getter e Setter per modello
    public String getModello() {
        return modello; // Restituisce il valore attuale del campo modello
    }

    public void setModello(String modello) {
        this.modello = modello; // Imposta un nuovo valore del campo modello
    }

    // Getter e Setter per numeroPosti
    public int getNumeroPosti() {
        return numeroPosti; // Restituisce il numero di posti
    }

    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) { // Controllo che il numero sia positivo
            this.numeroPosti = numeroPosti; // Imposta il nuovo valore
        } else {
            System.out.println("Errore: numero posti deve essere positivo."); // Stampa messaggio d'errore se il numero
                                                                              // è negativo
        }
    }

    // Getter e Setter per codice
    public String getCodice() {
        return codice; // Restituisce il codice identificativo dell’aereo
    }

    public void setCodice(String codice) {
        this.codice = codice; // Imposta un nuovo codice
    }
}

// Costruzione classe Pilota
class Pilota {

    // Attributi privati
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    // Costruttore pubblico
    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        this.oreVolo = oreVolo;

    }

    // Metodo getter e setter per nome
    public String getNome() {
        return nome; // Restituisce il valore attuale del campo nome
    }

    public void setNome(String nome) {
        this.nome = nome; // Aggiunge al campo nome un nuovo valore
    }

    // Metodo getter e setter per numeroBrevetto
    public String getNumeroBrevetto() {
        return numeroBrevetto; // Restituisce il valore contenuto nel campo numeroBrevetto
    }

    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto; // Aggiunge un nuovo valore al campo numeroBrevetto
    }

    // Metodo getter e setter per ore di volo
    public int getOreVolo() {
        return oreVolo; // Restituisce il valore contenuto nel campo oreVolo
    }

    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) { // Controllo che le ore del volo siano maggiori di zero
            this.oreVolo = oreVolo; // Impostiamo il nuovo valore
        } else {
            System.out.println("Errore: le ore di volo devono essere maggiore di zero"); // Stampiamo un messaggio
                                                                                         // d'errore se il numero è
                                                                                         // minore di zero
        }
    }

}

// Costruzione classe CompagniaAerea
class CompagniaAerea {

    // Attributi privati
    private String nome;
    private ArrayList<Aereo> flotta = new ArrayList<>();
    private ArrayList<Pilota> piloti = new ArrayList<>();

    // Costruttore pubblico
    CompagniaAerea(String nome) {
        this.nome = nome;
    }

    // Metodo per aggiungere un aereo alla flotta
    void aggiungiAereo(Aereo aereo) {
        flotta.add(aereo);
    }

    // Metodo per aggiungere un pilota
    void aggiungiPilota(Pilota pilota) {
        piloti.add(pilota);
    }

    // Metodo per stampare due aerei e due piloti
    public void stampaInfoCompagnia() {
        System.out.println("Compagnia: " + nome);

        System.out.println("--- Flotta Aerei ---");
        for (Aereo a : flotta) {
            System.out.println(
                    "Modello: " + a.getModello() + ", Posti: " + a.getNumeroPosti() + ", Codice: " + a.getCodice());
        }

        System.out.println("--- Piloti ---");
        for (Pilota p : piloti) {
            System.out.println("Nome: " + p.getNome() + ", Brevetto: " + p.getNumeroBrevetto() + ", Ore di volo: "
                    + p.getOreVolo());
        }

    }
}

public class EsercizioGestioneFlotta {

    public static void main(String[] args) {

        // Inizializzazione primo Scanner
        Scanner scanner = new Scanner(System.in);

        // Inizializzazione secondo Scanner
        Scanner scanner2 = new Scanner(System.in);

        // Inserimento nome compagnia
        System.out.print("Inserisci il nome della compagnia aerea: ");
        String nomeCompagnia = scanner.nextLine();

        // Controllo che ha inserito uan compagnia valida
        while (nomeCompagnia.isEmpty()) {
            System.out.print("Errore: inserire compagnia valida: ");
            nomeCompagnia = scanner.nextLine();
        }

        // Creaiamo un oggetto CompagniaAerea
        CompagniaAerea compagnia = new CompagniaAerea(nomeCompagnia);

        // Avvio di un ciclo per inserire i due aerei
        for (int i = 1; i <= 2; i++) {
            System.out.println(" Inserimento Aereo " + i);

            // Richiesta all'utente di inserire il modello
            System.out.print("Modello: ");
            String modello = scanner.nextLine();

            // Controllo che ha inserito un modello valido
            while (modello.isEmpty()) {
                System.out.print("Errore: inserire modello valido: ");
                modello = scanner.nextLine();
            }

            // Richiesta all'utente di inserire il numero dei posti
            System.out.print("Numero posti: ");
            int numeroPosti = scanner2.nextInt();

            // Richiesta all'utente di inserire il codice identificativo
            System.out.print("Codice identificativo: ");
            String codice = scanner.nextLine();

            // Controllo che ha inserito un codice valido
            while (codice.isEmpty()) {
                System.out.print("Errore: inserire codice valido: ");
                codice = scanner.nextLine();
            }

            // Creaimo un oggetto aereo
            Aereo aereo = new Aereo(modello, numeroPosti, codice);

            // Aggiungiamo l'oggetto appena creato alla compagnia
            compagnia.aggiungiAereo(aereo);
        }

        // Avvio di un ciclo per inserire i due aerei
        for (int i = 1; i <= 2; i++) {
            System.out.println("--- Inserimento Pilota --- " + i);

            // Richiesta all'utente di inserire il nome
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            // Controllo che ha inserito un nome valido
            while (nome.isEmpty()) {
                System.out.print("Errore: inserire nome valido: ");
                nome = scanner.nextLine();
            }

            // Richiesta all'utente di inserire il numero brevetto
            System.out.print("Numero brevetto: ");
            String brevetto = scanner.nextLine();

            // Controllo che ha inserito un numero di brevetto valido
            while (brevetto.isEmpty()) {
                System.out.print("Errore: inserire numero di brevetto valido: ");
                brevetto = scanner.nextLine();
            }

            // Richiesta all'utente di inserire le ore di volo
            System.out.print("Ore di volo: ");
            int oreVolo = scanner2.nextInt();

            // Creaiamo oggetto pilota
            Pilota pilota = new Pilota(nome, brevetto, oreVolo);

            // Aggkungiamo l'oggetto pilota alla compagnia
            compagnia.aggiungiPilota(pilota);
        }

        // Stampa finale
        System.out.println("---  COMPAGNIA AEREA ---");
        compagnia.stampaInfoCompagnia();

        // Chiusura primo scanner
        scanner.close();

        // Chiusura secondo scanner
        scanner2.close();
    }
}
