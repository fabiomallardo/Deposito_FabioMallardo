import java.util.ArrayList; 
import java.util.Scanner;  

// Classe astratta
abstract class VeicoloConsegna { 
    protected String targa;         // Targa del veicolo
    protected float caricoMassimo;  // Carico massimo trasportabile

    public VeicoloConsegna(String targa, float caricoMassimo) { // Costruttore
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    // Metodo astratto con controllo peso
    public abstract void consegnaPacco(String destinazione, float pesoPacco); 

    // Stampa le informazioni del veicolo
    public void stampaInfo() {
        System.out.println("Targa: " + targa + " | Carico massimo: " + caricoMassimo + " kg");
    }
}

// Interfaccia
interface Tracciabile {
    void tracciaConsegna(String codiceTracking); // Metodo per tracciare la consegna
}

// // Furgone eredita VeicoloConsegna e implementa Tracciabile
class Furgone extends VeicoloConsegna implements Tracciabile { 
    public Furgone(String targa, float caricoMassimo) { // Costruttore
        super(targa, caricoMassimo);
    }

    @Override
    public void consegnaPacco(String destinazione, float pesoPacco) { 
        if (pesoPacco > caricoMassimo) { // Controlla se il peso supera il carico massimo
            System.out.println("Errore: il pacco supera il carico massimo del furgone!");
        } else {
            System.out.println("Furgone " + targa + " consegna via strada a " + destinazione + " peso: " + pesoPacco);
        }
    }

    @Override
    public void tracciaConsegna(String codiceTracking) { 
        System.out.println("Tracking furgone: pacco " + codiceTracking + " in transito su strada.");
    }
}

// // Drone eredita VeicoloConsegna e implementa Tracciabile
class Drone extends VeicoloConsegna implements Tracciabile { 
    public Drone(String targa, float caricoMassimo) { // Costruttore
        super(targa, caricoMassimo);
    }

    @Override
    public void consegnaPacco(String destinazione, float pesoPacco) { 
        if (pesoPacco > caricoMassimo) { // Controlla se il peso supera il carico massimo
            System.out.println("Errore: il pacco supera il carico massimo del drone!");
        } else {
            System.out.println("Drone " + targa + " vola verso " + destinazione + " (peso: " + pesoPacco + " kg)");
        }
    }

    @Override
    public void tracciaConsegna(String codiceTracking) { 
        System.out.println("Tracking drone: pacco " + codiceTracking + " in volo.");
    }
}

// Classe principale
public class EsercizioInterfaccia {
    public static void main(String[] args) {
        ArrayList<VeicoloConsegna> veicoli = new ArrayList<>(); // Crea una lista di veicoli
        Scanner scannerStringa = new Scanner(System.in);    // Scanner per leggere stringhe
        Scanner scannerNumero = new Scanner(System.in);    // Scanner per leggere numeri

        while (true) { // Ciclo per inserire veicoli
            // Menu
            System.out.println("--- 1. Aggiungi Furgone --- "); 
            System.out.println("--- 2. Aggiungi Drone --- "); 
            System.out.println("--- 3. Avvia Consegne --- "); 
            System.out.println("--- 4. Esci --- "); 
            int scelta = scannerNumero.nextInt(); 

            if (scelta == 3) break; // Avvia le consegne
            if (scelta == 4) break; // Esce dal ciclo

            System.out.print("Targa: "); // Chiede la targa
            String targa = scannerStringa.nextLine(); 
            System.out.print("Carico massimo (kg): "); // Chiede il carico massimo
            float carico = scannerNumero.nextFloat();

            VeicoloConsegna v = null; // Inizializza il veicolo
            if (scelta == 1) v = new Furgone(targa, carico); // Se 1, crea un Furgone
            else if (scelta == 2) v = new Drone(targa, carico); // Se 2, crea un Drone

            if (v != null) veicoli.add(v); // Aggiunge il veicolo alla lista
        }

        if (veicoli.size() > 0) { // Se ci sono veicoli nella lista
            System.out.print("\nInserisci destinazione: "); // Chiede la destinazione
            String destinazione = scannerStringa.nextLine(); 
            System.out.print("Inserisci codice tracking: "); // Chiede il codice tracking
            String codiceTracking = scannerNumero.nextLine(); 
            System.out.print("Inserisci peso pacco (kg): "); // Chiede il peso del pacco
            float pesoPacco = scannerStringa.nextFloat(); 


            System.out.println("\n--- Avvio consegne ---"); // Messaggio di inizio consegne
            for (VeicoloConsegna v : veicoli) { // Cicla su tutti i veicoli
                v.stampaInfo(); // Stampa le info del veicolo
                v.consegnaPacco(destinazione, pesoPacco); // Effettua la consegna
                if (v instanceof Tracciabile) { // Se il veicolo è tracciabile
                    ((Tracciabile) v).tracciaConsegna(codiceTracking); // Traccia la consegna
                }
        }

    }

        scannerStringa.close(); // Chiude lo scanner delle stringhe
        scannerNumero.close(); // Chiude lo scanner dei numeri
    }
}
