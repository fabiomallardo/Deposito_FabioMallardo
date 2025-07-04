import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Biblioteca");

        int scelta;
        do {
            System.out.println("\n--- Menu Biblioteca ---");
            System.out.println("1. Aggiungi libro");
            System.out.println("2. Aggiungi risorsa");
            System.out.println("3. Aggiungi ebook");
            System.out.println("4. Aggiungi utente");
            System.out.println("5. Visualizza dettagli risorse");
            System.out.println("6. Visualizza dettagli utenti");
            System.out.println("7. Ricerca risorsa per titolo");
            System.out.println("0. Esci");
            System.out.print("- Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    biblioteca.addLibro();
                    break;               
                case 2:
                    biblioteca.addEbook();
                    break;
                case 3:
                    biblioteca.aggiungiUtente();
                    break;
                case 4:
                    biblioteca.stampaDatiRisorse();
                    break;
                case 5:
                    biblioteca.stampaDatiUtenti();
                    break;
                case 6:
                    biblioteca.ricercaRisorsa(GlobalScanner.readStringInput());
                    break;
                case 0:
                    System.out.println("Arrivederci e grazie...");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        scanner.close();
    }
}