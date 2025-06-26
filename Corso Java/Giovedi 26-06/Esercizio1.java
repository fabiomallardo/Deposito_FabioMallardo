import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        //Scanner per input da console
        Scanner scanner = new Scanner(System.in);

        //Prompt per il numero di voti da inserire
        System.out.print("Quanti voti vuoi inserire? (intero positivo): ");
        int numero = scanner.nextInt();

        //Verifica che il numero sia positiva
        while (numero <= 0) {
            System.out.print("Numero non valido. Inserisci un numero positivo: ");
            numero = scanner.nextInt();
        }

        //Inizializza contatore voti validi
        int countValidi = 0;

        for (int i = 1; i <= numero; i++) {
            int voto;
            
            //Lettura e validazione di un voto (0–30)
            do {
                System.out.print("Inserisci voto #" + i + " (0-30): ");
                voto = scanner.nextInt();
                if (voto < 0 || voto > 30) {
                    System.out.println("Voto non valido, riprova.");
                }
            } while (voto < 0 || voto > 30);

            // Classificazione del voto
            if (voto >= 24) {
                System.out.println("Buono o Ottimo");
            } else if (voto >= 18 && voto <= 23) {
                System.out.println("Sufficiente");
            } else {
                System.out.println("Insufficiente");
            }

            countValidi++;
        }

        // Stampa il totale dei voti validi
        System.out.println("Numero totale di voti validi inseriti: " + countValidi);

        //Chiusura del scanner
        scanner.close();
    }
}
