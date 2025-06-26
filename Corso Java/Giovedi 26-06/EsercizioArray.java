import java.util.Scanner;

public class EsercizioArray {
    public static void main(String[] args) {

        // Inizializzare lo Scanner
        Scanner scanner = new Scanner(System.in);

        // Richiesta all’utente quanti dolci vuole ordinare
        System.out.print("Quanti dolci vuoi ordinare? (1-10): ");
        int numeroDolci = scanner.nextInt();

        // Verifichiamo che la richiesta non sia fuori range
        while (numeroDolci < 1 || numeroDolci > 10) {
            System.out.print("Numero non valido. Inserisci un valore tra 1 e 10: ");
            numeroDolci = scanner.nextInt();
        }

        // Creiamo due array per contenere il nomi dei dolci e la quantità
        String[] nomiDolci = new String[numeroDolci];
        int[] quantitaDolci = new int[numeroDolci];

        // Per ogni dolce chiediamo il nome e la quantità
        for (int i = 0; i < numeroDolci; i++) {
            // Nome del dolce
            System.out.print("Nome dolce " + (i + 1) + ": ");
            nomiDolci[i] = scanner.nextLine();

            // Quantità ordinata e verifichiamo se è valida
            System.out.print("Quantità per " + nomiDolci[i] + " : ");
            int quantita = scanner.nextInt();
            while (quantita < 0) {
                System.out.print("Quantità non valida. Inserisci un numero ≥ 0: ");
                quantita = scanner.nextInt();
            }
            quantitaDolci[i] = quantita;
        }

        // Stampa il riepilogo ordini e il totale
        System.out.println("Riepilogo ordini: ");
        int totale = 0;
        for (int i = 0; i < numeroDolci; i++) {
            System.out.println(nomiDolci[i] + ": " + quantitaDolci[i]);
            totale += quantitaDolci[i];
        }

        System.out.println("Quantità totale di dolci ordinati: " + totale);

        // Chiusura scanner
        scanner.close();
    }
}
