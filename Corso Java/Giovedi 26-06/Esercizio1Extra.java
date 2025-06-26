import java.util.Scanner;

public class Esercizio1Extra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Dichiara la variabile risposta che conterrà alla fine del ciclo se continuare o meno
        String risposta;

        //Inizio ciclo
        do {
            //lettura del nome della persona
            System.out.print("Inserisci il nome della persona: ");
            String nome = scanner.next();
            
            // Lettura per il numero di voti
            System.out.print("Quanti voti vuoi inserire? (intero positivo): ");
            int numero = scanner.nextInt();

            // Verifica che il numero sia positivo
            while (numero <= 0) {
                System.out.print("Numero non valido. Inserisci un numero positivo: ");
                numero = scanner.nextInt();
            }

            // Inizializza contatori
            int countValidi = 0;
           
            // Inizializza la somma dei voti validi
            int sumVoti = 0;
            
            //Gestione tramite un ciclo for dell'inserimento dei voti
            for (int i = 1; i <= numero; i++) {
                int voto;

                // Lettura e validazione di un voto (0–30)
                do {
                    System.out.print("Inserisci voto " + i + " (0-30): ");
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
                
                // Somma il voto valido
                sumVoti += voto;
            
            }

            // Calcola e stampa della media dei voti
            double media = (double) sumVoti / countValidi;
            System.out.println("Studente: " + nome + ", Media voti: " + media);
            

            // Chiede se vuole ripetere per un altro studente
            System.out.print("Vuoi inserire un altro studente? (s/n): ");
            risposta = scanner.nextLine();

            //Risposta s ripete il ciclo
        } while (risposta.equalsIgnoreCase("s"));
        
        //Chiusura Scanner
        scanner.close();
    }
}
