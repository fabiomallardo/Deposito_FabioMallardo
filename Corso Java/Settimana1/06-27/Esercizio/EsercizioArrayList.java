import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioArrayList {
    public static void main(String[] args) {

        // Dichiarazione della lista
        ArrayList<String> nomi = new ArrayList<>();

        // Dichiarazione dello Scanner
        Scanner scanner = new Scanner(System.in);

        // Lettura dei nomi finché non si digita "fine"
        String parola;
        do {
            System.out.print("Inserisci nome studente (o \"fine\" per terminare): ");
            parola = scanner.nextLine();

            if (parola.isEmpty()) {
                System.out.println("Nome non valido, riprova.");
            } else if (!parola.equals("fine")) {
                nomi.add(parola);
            }
        } while (!parola.equals("fine"));

        // Ordinamento alfabetico
        Collections.sort(nomi);

        // Stampa dei nomi e conteggio con for indicizzato
        System.out.println("Elenco studenti (" + nomi.size() + "):");
        for (int i = 0; i < nomi.size(); i++) {
            System.out.println(nomi.get(i));
        }

        // Rimozione di studenti indicati dall’utente
        String daRimuovere;
        do {
            System.out.print("Inserisci nome da rimuovere (o \"fine\" per terminare): ");
            daRimuovere = scanner.nextLine();

            if (daRimuovere.isEmpty()) {
                System.out.println("Nome non valido, riprova.");
            } else if (!daRimuovere.equals("fine")) {
                boolean removed = nomi.remove(daRimuovere);
                System.out.println(
                        removed
                                ? daRimuovere + " rimosso dalla lista."
                                : daRimuovere + " non presente in lista.");
            }
        } while (!daRimuovere.equals("fine"));

        // Ordinamento e stampa finale, sempre con for indicizzato
        Collections.sort(nomi);
        System.out.println("\nElenco finale studenti (" + nomi.size() + "):");
        for (int i = 0; i < nomi.size(); i++) {
            System.out.println(nomi.get(i));
        }

        // Chiusura dello scanner
        scanner.close();
    }
}
