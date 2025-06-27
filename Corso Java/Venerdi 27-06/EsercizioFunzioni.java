import java.util.Scanner;

public class EsercizioFunzioni {

    // Funzione per calcolare il quadrato
    static int potenza(int a) {
        return a * a;
    }

    // Funzione per gestire input non numerico
    static void potenza(String s) {
        System.out.println("Inserisci un numero valido");
    }

    public static void main(String[] args) {

        //Inizializzazione dello Scanner
        Scanner scanner = new Scanner(System.in);

        //Richiesta all'utente di un numero
        System.out.print("Dammi un numero: ");
        String input = scanner.nextLine();

        // Controllo il parametro
        if (input.matches("\\d+")) {

            // Input valido
            System.out.println("Risultato: " + potenza(Integer.parseInt(input)));

        } else {

            // Messaggio d'errore
            potenza(input);
        }

        
        // Stampa stringa
        int lunghezzaStringa = input.length();
        System.out.println("La stringa è lunga: " + lunghezzaStringa);
        
        // Chiusura Scanner
        scanner.close();
    }
}
