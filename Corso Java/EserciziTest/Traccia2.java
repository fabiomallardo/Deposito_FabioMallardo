import java.util.ArrayList;
import java.util.Scanner;

public class Traccia2 {
    public static void main(String[] args) {

        // Inizializzazione Scanner
        Scanner scanner = new Scanner(System.in);

        // Inizializzazione ArrayList
        ArrayList<String> lista = new ArrayList<>();

        System.out.println("Inserisci gli articoli della spesa (digita \"fine\" per terminare):");

        // Ciclo di inserimento finché non si digita "fine"
        while (true) {
            String voce = scanner.nextLine();
            if (voce.equalsIgnoreCase("fine")) {
                break;
            }
            if (!voce.isEmpty()) {
                lista.add(voce);
            }
        }

        // Stampa di tutti gli elementi uno per riga
        System.out.println("\nGli articoli inseriti sono:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("- " + lista.get(i));
        }

        // Numero totale di elementi
        System.out.println("\nNumero totale di elementi: " + lista.size());

        // Controllo se c'è "pane" e "latte"
        if (lista.contains("pane") && lista.contains("latte")) {
            System.out.println("\nHai pensato alla colazione!");
        }

        // Chiusura Scanner
        scanner.close();
    }
}
