import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Persona.java
abstract class Persona {

    // Attributi privati
    private String nome;
    private int eta;

    // Costruttore pubblico
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Getter per il nome
    public String getNome() {
        return nome;
    }

    // Setter per il nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter per l'età
    public int getEta() {
        return eta;
    }

    // Setter per l'età
    public void setEta(int eta) {
        this.eta = eta;
    }

    // Metodo astratto: ogni sottoclasse dovrà implementare descriviRuolo()
    public abstract void descriviRuolo();
}

// Creazione dell'interfaccia Registrabile
interface Registrabile {

    // Metodo di registrazione che stampa la modalità di registrazione della persona
    void registrazione();

}

// Sottoclasse Studente che estende Persona e implementa l'interfaccia
class Studente extends Persona implements Registrabile {

    // Attributi privati
    private String classeFrequentata;

    // Costruttore pubblico
    public Studente(String nome, int eta, String classeFrequentata) {
        super(nome, eta);
        this.classeFrequentata = classeFrequentata;
    }

    // Metodo get che restituisce la classe frequentata
    public String getClasseFrequentata() {
        return classeFrequentata;
    }

    // Metodo set che assegna il valore al campo
    public void setClasseFrequentata(String classeFrequentata) {
        this.classeFrequentata = classeFrequentata;
    }

    @Override // Sovrascrivo il metodo creato nella superclasse
    public void descriviRuolo() {
        System.out.println(
                "--- Ciao sono " + getNome() + " uno studente della classe: " + getClasseFrequentata() + " ---");
    }

    // Implementazione dell'interfaccia con il metodo registrazione che stampa il
    // modo in cui è avvenuta la registrazione
    public void registrazione() {
        System.out.println("--- Registrazione tramite modulo online ---");
    }
}

// Sottoclasse Docente che estende Persona e implementa l'interfaccia
class Docente extends Persona implements Registrabile {

    // Attributi privati
    private String materia;

    // Costruttore pubblico
    public Docente(String nome, int eta, String materia) {
        super(nome, eta);
        this.materia = materia;
    }

    // Metodo get che restituisce il valore al campo materia
    public String getMateria() {
        return materia;
    }

    // Metodo set che aggiunge al campo materia un nuovo valore
    void setMateria(String materia) {
        this.materia = materia;
    }

    @Override // Sovrascrivo il metodo creato nella superclasse
    public void descriviRuolo() {
        System.out.println("--- Ciao sono " + getNome() + " un docente di: " + getMateria() + " ---");
    }

    @Override // Implementazione dell'interfaccia con il metodo registrazione
    public void registrazione() {
        System.out.println("--- Registrazione tramite segreteria didattica ---");
    }
}

public class EsercizioGestioneScuola {
    public static void main(String[] args) {

        // Lista di tipo Persona con ogetti studente e docente
        List<Persona> persone = new ArrayList<>();

        // Inizializzazione scanner Stringa e Integer
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        // Messaggio di benvenuto
        System.out.println("Buongiorno, benvenuto a scuola");

        // Richiesta all'utente quanti studenti vuole inserire
        System.out.print("--- Inserisci il numero degli studenti --- ");
        int numeroStudenti = scannerNum.nextInt();

        // Ciclo per ogni studnete inserito lo aggiungo alla lista
        for (int i = 1; i <= numeroStudenti; i++) {
            System.out.println("Studente " + i + " ---");

            // Richiesta all'utente di inserire il nome
            System.out.print("--- Inserisci il nome dello studente --- ");
            String nomeStudente = scannerStr.nextLine();

            // Richiesta all'utente di inserire l'età
            System.out.print("--- Inserisci l'età dello studente --- ");
            int eta = scannerNum.nextInt();

            // Richiesta all'utente della classe frequentata
            System.out.print("-- Inserisci la classe che frequenti --- ");
            String classeStudente = scannerStr.nextLine();

            // Aggiunta dell'oggetto studente creato
            persone.add(new Studente(nomeStudente, eta, classeStudente));
        }

        // Richiesta all'utente di inserire il numero dei docenti
        System.out.print("--- Inserisci il numero dei docenti --- ");
        int numeroDocenti = scannerNum.nextInt();
        // Ciclo per ogni docente inserito lo aggiungo alla lista
        for (int i = 1; i <= numeroDocenti; i++) {
            System.out.println("Docente " + i + " ---");

            // Richiesta di inserire il nome del docente
            System.out.print("--- Inserisci il nome del docente --- ");
            String nomeDocente = scannerStr.nextLine();

            // Richiesta di inserire l'età del docente
            System.out.print("--- Inserisci l'età del docente --- ");
            int etaDocente = scannerNum.nextInt();

            // Richiesta di inserire la materia che insegna
            System.out.print("--- Inserisci la materia professata --- ");
            String materiaDocente = scannerStr.nextLine();

            // Aggiunta dell'oggetto docente creato
            persone.add(new Docente(nomeDocente, etaDocente, materiaDocente));
        }

        // Stampa ruolo e registrazione
        System.out.println("--- Il ruolo e la registrazione sono --- ");

        // Ciclo su ogni oggetto di tipo Persona presente nella lista 'persone'
        for (Persona p : persone) {

            // Chiama il metodo descriviRuolo() sull'oggetto corrente per stampare il ruolo
            p.descriviRuolo();

            // Verifica se l'oggetto corrente implementa l'interfaccia Registrabile
            if (p instanceof Registrabile) {
                // Se sì, effettua il cast e chiama il metodo registrazione()
                ((Registrabile) p).registrazione();
            }
        }

        // Chiusura dei due scanner
        scannerNum.close();
        scannerStr.close();

    }
}
