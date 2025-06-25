import java.util.Scanner;

public class EsercizioSwitch {
    public static void main(String[] args) {

        //Preazzo base dell'assicurazione
        final double prezzoBase = 500.0;
        
        // 1) Età del conducente
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci l'età del conducente: ");
        int eta = scanner.nextInt();
        if (eta < 18) {
            System.out.println("Non sei idoneo per l'assicurazione");
            scanner.close();
            return;
        }
        
        // inizializzo il prezzo con il prezzo base
        double prezzo = prezzoBase;
        
        // maggiorazioni/sconti per fascia d'età
        //Meno di 18
        if (eta < 18) {
            System.out.println("Non sei idoneo per l'assicurazione");
        } else if (eta < 18 && eta > 25) {
            // 18–25 anni: +20%
            prezzo += prezzoBase * 0.20;
        } else if (eta <= 50) {
            // 26–50 anni: nessuna maggiorazione
        } else {
            // > 50 anni: sconto 10%
            prezzo -= prezzoBase * 0.10;
        }
        
        // 2) Anni di esperienza alla guida
        System.out.print("Inserisci gli anni di esperienza alla guida: ");
        int anniEsperienza = scanner.nextInt();
        if (anniEsperienza < 2) {
            // meno di 2 anni: +30%
            prezzo += prezzoBase * 0.30;
        }
        
        // 3) Incidenti negli ultimi 5 anni
        System.out.print("Quanti incidenti negli ultimi 5 anni? ");
        int incidenti = scanner.nextInt();
        //Maggiore di 4 non idoneo all'assicurazione
        if (incidenti > 4) {
            System.out.println("Non sei idoneo per l'assicurazione");
            scanner.close();
            return;
        } else if (incidenti == 1) {
            // 1 incidente: +15%
            prezzo += prezzoBase * 0.15;
        } else if (incidenti >= 2) {
            // 2–4 incidenti: +30%
            prezzo += prezzoBase * 0.30;
        }
        
        // 4) Scelta del pacchetto
        System.out.println("Scegli il pacchetto assicurativo:");
        System.out.println("  1) Base (prezzo standard)");
        System.out.println("  2) Intermedio (+20%)");
        System.out.println("  3) Premium (+50%)");
        System.out.print("Inserisci 1, 2 o 3: ");
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                // Base: nessuna modifica
                break;
            case 2:
                prezzo += prezzoBase * 0.20;
                break;
            case 3:
                prezzo += prezzoBase * 0.50;
                break;
            default:
                System.out.println("Scelta non valida: applico pacchetto Base");
                break;
        }
        
        // 5) Stampa del preventivo
        System.out.println("Il preventivo finale è: " + prezzo);
        
        scanner.close();
    }
}
