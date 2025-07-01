import java.util.Scanner;
import java.util.ArrayList;

// Creazione classe Auto
class Auto {

    // Targa
    String targa;

    // Modello
    String modello;

    // Costruttore
    Auto(String targa, String modello) {
        this.targa = targa;
        this.modello = modello;
    }

    // Metodo per stampare tutte le auto con targa e modello
    void stampaAutoInfo() {
        System.out.println("Targa " + targa + " Modello " + modello);
    }
}

// Creazione classe Officina;
class Officina {

    // Lista di auto
    ArrayList<Auto> arrayDiAuto = new ArrayList<>();

    // Metodo per aggiungere un auto all'officina
    void aggiungiAuto(Auto auto) {
        arrayDiAuto.add(auto);
    }

    // Metodo per stampare tutte le info delle auto
    void stampaAuto() {
        System.out.println("Le auto presenti in officina sono: ");
        for (Auto a : arrayDiAuto) {
            a.stampaAutoInfo();
        }
    }

}

public class EsercizioFinaleOggetti {
    public static void main(String[] args) {

        // Inizializzazione dello Scanner
        Scanner scanner = new Scanner(System.in);

        // Creazione dell'oggetto Officina
        Officina officina = new Officina();

        // Richiesta all'utente di inserire la targa
        System.out.println("Inserisci dati della prima auto:");
        System.out.print("Targa: ");
        String targa1 = scanner.nextLine();

        // Verifica che l'utente abbia digitato una targa valida
        while (targa1.isEmpty()) {
            System.out.print("Inserire una targa valida");
            targa1 = scanner.nextLine();
        }

        // Richiesta all'utente di inserire il modello
        System.out.print("Modello: ");
        String modello1 = scanner.nextLine();

        // Verifica che l'utente abbia digitato un modello valido
        while (modello1.isEmpty()) {
            System.out.print("Inserire un modello valido");
            modello1 = scanner.nextLine();
        }

        // Creazione del primo oggetto auto
        Auto auto1 = new Auto(targa1, modello1);


        // Aggiungiamo la prima auto
        officina.aggiungiAuto(auto1);

        // Richiesta all'utente di inserire la seconda targa
        System.out.println("Inserisci dati della seconda auto:");
        System.out.print("Targa: ");
        String targa2 = scanner.nextLine();

        // Verifica che l'utente abbia digitato una targa valida
        while (targa2.isEmpty()) {
            System.out.print("Inserire una targa valida");
            targa2 = scanner.nextLine();
        }

        // Ricbhiesta all' utente di inserire il seconod modello
        System.out.print("Modello: ");
        String modello2 = scanner.nextLine();

        // Verifica che l'utente abbia digitato un modello valido
        while (modello2.isEmpty()) {
            System.out.print("Inserire un modello valido");
            modello2 = scanner.nextLine();
        }

        // Creazione del secondo oggetto auto
        Auto auto2 = new Auto(targa2, modello2);

        // Aggiungiamo la seconda auto
        officina.aggiungiAuto(auto2);

        // Stampa elenco
        officina.stampaAuto();

        // Chiusura Scanner
        scanner.close();
    }
}
