package Progetto;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChiamanteCustom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.print("Procedere con la divisione? 1=Si, 2=No: ");
            scelta = acquisisciNumero(scanner, ""); // input sicuro per la scelta

            if (scelta == 1) {
                try {
                    int numeratore = acquisisciNumero(scanner, "Inserisci il primo numero (numeratore): ");
                    Controller.checkPositive(numeratore);

                    int denominatore = acquisisciNumero(scanner, "Inserisci il secondo numero (denominatore): ");
                    Controller.checkPositive(denominatore);
                    Controller.checkNotZero(denominatore);

                    int risultato = numeratore / denominatore;
                    System.out.println(numeratore + "/" + denominatore + "=" + risultato);

                } catch (NumeroNegativoException e) {
                    e.printStackTrace();
                    System.out.println("Messaggio: " + e.getMessage());
                    continue;
                } catch (NumeroZeroException e) {
                    e.printStackTrace();
                    System.out.println("Messaggio: " + e.getMessage());
                    continue;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Errore generico: " + e.getMessage());
                    continue;
                }
            }

        } while (scelta != 2);

        System.out.println("Programma terminato.");
        scanner.close();
    }

    
    //Metodo che garantisce l'inserimento di un numero intero da parte dell'utente.
    
    public static int acquisisciNumero(Scanner scanner, String messaggio) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                if (!messaggio.isBlank()) {
                    System.out.print(messaggio);
                }
                numero = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Errore: inserire solo numeri interi.");
                scanner.nextLine(); // pulisce il buffer in caso di input errato
            }
        }

        return numero;
    }
}
