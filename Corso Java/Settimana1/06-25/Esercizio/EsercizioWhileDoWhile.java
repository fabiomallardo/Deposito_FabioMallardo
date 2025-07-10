import java.util.Scanner;

public class EsercizioWhileDoWhile {
    public static void main(String[] args) {

        // Richiesta all'utente di inserire una password
        Scanner scanner = new Scanner(System.in);

        // Password corretta
        final String passwodCorretta = "java123";

        // Tentativi max utente
        int tentativiRimasti = 3;

        // Login non ancora effettuato
        boolean loginEffettuato = false;

        // Login con max 3 tentativi
        while (tentativiRimasti > 0) {
            System.out.print("Inserisci password: ");
            String password = scanner.nextLine();

            if (password.equals(passwodCorretta)) {
                loginEffettuato = true;
                break;
            } else {
                tentativiRimasti--;
                System.out.println("Password errata. Tentativi rimasti: " + tentativiRimasti);
            }
        }

        // Se l'utente fallisce i tentativi
        if (!loginEffettuato) {
            System.out.println("Accesso bloccato");
        } else {
            System.out.println("Login effettuato correttamente");

            // Conferma finale con do–while
            String risposta;
            do {
                System.out.print("Vuoi accedere al sistema? (s/n): ");
                risposta = scanner.nextLine();
            } while (!risposta.equals("s") && !risposta.equals("n"));

            // Conferma
            if (risposta.equals("s")) {
                System.out.println("Accesso al sistema effettuato");
            } else {
                System.out.println("Accesso annullato");
            }
        }

        scanner.close();
    }
}
