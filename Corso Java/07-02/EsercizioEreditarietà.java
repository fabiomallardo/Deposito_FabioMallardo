import java.util.Scanner;
import java.util.ArrayList;

// Creazione superclasse Animael
class Animale {

    // Attributi privati: ogni animale ha un nome e un'età
    private String nome;
    private int età;

    // Costruttore pubblico : inizializza il nome e l'età
    Animale(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }

    // Metodo getter per ottenere il nome
    public String getNome() {
        return nome;
    }

    // Metodo getter per ottenere l'età 
    public int getEtà() {
        return età;
    }

    // Metodo che rappresenta il verso dell'animale 
    public void faiVerso() {
        System.out.println("Verso generico...");
    }
}

// Classe Cane che estende Animale
class Cane extends Animale {

    // Costruttore pubblico passa nome e età alla superclasse
    Cane(String nome, int età) {
        super(nome, età);
    }

    // Metodo pubblico del verso del cane
    public void faiVerso() {
        System.out.println("Bau!");
    }
}

// Classe Gatto che estende Animale
class Gatto extends Animale {

    // Costruttore pubblico passa nome e età alla superclasse
    Gatto(String nome, int età) {
        super(nome, età);
    }

     // Metodo pubblico del verso del gatto
    public void faiVerso() {
        System.out.println("Miao!");
    }
}

// Classe Pappagallo che estende Animale
class Uccello extends Animale {

    // Costruttore pubblico passa nome e età alla superclasse
    Uccello(String nome, int età) {
        super(nome, età);
    }

     // Metodo pubblico del verso del pappagallo
    public void faiVerso() {
        System.out.println("Cip cip!");
    }
}

// Classe Zoo
class Zoo {

    // Inizializzazione degli array 
    private ArrayList<Cane> cani = new ArrayList<>();
    private ArrayList<Gatto> gatti = new ArrayList<>();
    private ArrayList<Uccello> uccelli = new ArrayList<>();

    // Metodo per leggere in input gli animali da aggiungere
    public void aggiungiAnimaliDaInput() {

        // Inizializzazione del primo Scanner
        Scanner scanner = new Scanner(System.in);

        // Inizializzazione del secondo Scanner
        Scanner scanner2 = new Scanner(System.in);

        // Richiesta all'utente di inserire i cani
        System.out.println("Inserisci i cani: ");
        for (int i = 0; i < 2; i++) {

            // Nome cane da inserire
            System.out.print("Nome cane: ");
            String nome = scanner.nextLine();

            // Eta cane da inserire
            System.out.print("Età cane: ");
            int età = scanner2.nextInt();

            // Aggiunta dei cani alla lista di array creando a sua volta un oggetto
            cani.add(new Cane(nome, età));
        }

        // Richiesta all'utente di inserire i gatti        
        System.out.println("Inserisci i gatti: ");
        for (int i = 0; i < 2; i++) {

            // Richiesta all'utente di inserire il nome dei gatti
            System.out.print("Nome gatto: ");
            String nome = scanner.nextLine();

            // Richiesta all'utente di inserire l'età dei gatti 
            System.out.print("Età gatto: ");
            int età = scanner2.nextInt();

            // Aggiunta dei gatti alla lista di array creando a sua volta un oggetto
            gatti.add(new Gatto(nome, età));
        }

        // Richiesta all'utente di inserire gli uccelli
        System.out.println("Inserisci gli uccelli: ");
        for (int i = 0; i < 2; i++) {

            // Richiesta all'utente di inserire il nome degli uccelli
            System.out.print("Nome uccello: ");
            String nome = scanner.nextLine();

            // Richiesta all'utente di inserire l'età degli uccelli
            System.out.print("Età uccelli: ");
            int età = scanner2.nextInt();

            // Aggiunta degli uccelli alla lista di array creando a sua volta un oggetto
            uccelli.add(new Uccello(nome, età));
        }

        // Chiusura primo Scanner
        scanner.close();

        // Chiusura secondo Scanner
        scanner2.close();
    }

    // Metodo che stampa tutti gli animali inseriti
    public void stampaTuttiGliAnimali() {
        System.out.println("--- Gli animali dello Zoo presenti sono: ---");

        // Scorre la lista dei cani e li stampa
        for (Animale a : cani) {
            stampaAnimale(a);
        }

        // Scorre la lista dei gatti e li stampa
        for (Animale a : gatti) {
            stampaAnimale(a);
        }

        // Scorre la lista degli uccelli e li stampa
        for (Animale a : uccelli) {
            stampaAnimale(a);
        }
    }

    // Metodo che stampa nome, età e verso dell’animale
    private void stampaAnimale(Animale a) {
        System.out.print(a.getNome() + " (" + a.getEtà() + " anni): ");
        a.faiVerso();
    }
}

public class EsercizioEreditarietà {
    public static void main(String[] args) {

        // Crea un oggetto Zoo
        Zoo mioZoo = new Zoo();

        // Chiede all’utente di inserire gli animali in input 
        mioZoo.aggiungiAnimaliDaInput();

        // Stampa gli animali inseriti dall'utente
        mioZoo.stampaTuttiGliAnimali();
    }
}
