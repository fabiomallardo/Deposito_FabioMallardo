import java.util.Scanner;

public class Traccia1 {
    public static void main(String[] args) {

        // Inizializzazione dello Scanner
        Scanner scanner = new Scanner(System.in);

        // Richiesta all'utente dell'età
        System.out.print("Inserisci età: ");
        int eta = scanner.nextInt();

        // Verifica che l'utente abbia inserito un età valida
        while (eta <= 0) {
            System.out.println("Età non valida, inserisci un'età valida: ");
            eta = scanner.nextInt();
        }

        //Richiesta all'utente degli anni di programmazione
        System.out.print("Inserisci anni di esperienza in programmazione: ");
        int anniDiEsperienza = scanner.nextInt();

        // Verifica che l'utente abbia inserito un numero valid0
        while (anniDiEsperienza < 0) {
            System.out.println("Anni di esperienza non validi, inserisci un anno valido: ");
            anniDiEsperienza = scanner.nextInt();
        }

        //Richiesta all'utente il numero di certificazioni ottenute
        System.out.print("Inserisci numero di certifazioni ottenute: ");
        int certificazioni = scanner.nextInt();

        // Verifica che l'utente abbia inserito un numero valid0
        while (certificazioni < 0) {
            System.out.println("Numero di certificazioni non valido, inserisci un numero valido: ");
            certificazioni = scanner.nextInt();
        }

        //Controllo se l'utente soddisfa i requisiti necessari
        boolean idoneo = 
            (eta > 18 && anniDiEsperienza >= 2)
            || (certificazioni >= 1 && eta >= 16 && eta <= 18);
        
            if (idoneo){
            System.out.println("Idoneo al corso");
        } else {
            System.out.println("Non idoneo al corso");
        }
        
        //Calcolo della radice quadrata  del totale
        double radiceQuadrata = Math.sqrt(eta + anniDiEsperienza);
        System.out.println("La Radice quadrata è: " + radiceQuadrata);


        //Chiusura Scanner
        scanner.close();
    }


}
