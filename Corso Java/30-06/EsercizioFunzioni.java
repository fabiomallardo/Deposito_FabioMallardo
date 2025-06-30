import java.util.Arrays;
import java.util.Scanner;

public class EsercizioFunzioni {

    // Funzione Base
    static int somma(int a, int b) {
        return a + b;
    }

    // Sfida sull'Overloading
    static int multiply(int a, int b) {
        return a * b;
    }

    static double multiply(double a, double b, double c) {
        return a * b * c;
    }

    // Ricorsione
    static int sommaNaturali(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sommaNaturali(n - 1);
    }

    // Varuiabile primitiva
    static void modificaPrimitivo(int x) {
        x = 999;
        System.out.println("  [dentro modificaPrimitivo] x = " + x);
    }

    // Array
    static void modificaArray(int[] arr) {
        if (arr.length > 0) {
            arr[0] = 999;
        }
        System.out.println("  [dentro modificaArray] arr = " + Arrays.toString(arr));
    }

    public static void main(String[] args) {

        // Inizilizzare lo Scaaner
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Scegli il nome dell'esercizio: -Funzione Base, -Sfida sull'Overloading, -Ricorsione, -Passaggio per Valore: ");
        String nomeFunzioni = scanner.nextLine();

        // Controllo che l'utente abbia digitato un nome valido
        while (!nomeFunzioni.equals("Funzione Base")
                && !nomeFunzioni.equals("Sfida sull'Overloading")
                && !nomeFunzioni.equals("Ricorsione")
                && !nomeFunzioni.equals("Passaggio per Valore")) {

            System.out.print(
                    "Nome non riconosciuto. "
                            + "Riprova (Funzione Base, Sfida sull'Overloading, Ricorsione, Passaggio per Valore): ");
            nomeFunzioni = scanner.nextLine();
        }

        // Facciamo eseguire ciò che ha scelto l'utente
        switch (nomeFunzioni) {
            case "Funzione Base":
                System.out.println("La somma è: " + somma(23, 45));
                break;

            case "Sfida sull'Overloading":
                System.out.println("Il prodotto di 20 e 20 è: " + multiply(20, 20));

                System.out.println(
                        "Il prodotto di 2.45, 3.51 e 6.78 è: "
                                + multiply(2.45, 3.51, 6.78));
                break;

            case "Ricorsione":
                System.out.println("La somma dei primi n numeri naturali è: " + sommaNaturali(20));
                break;

            case "Passaggio per Valore":

                // Primitivo
                int prim = 42;
                System.out.println("Prima di modificaPrimitivo: prim = " + prim);
                modificaPrimitivo(prim);
                System.out.println("Dopo modificaPrimitivo: prim = " + prim);

                // array
                int[] arr = { 1, 2, 3 };
                System.out.println("Prima di modificaArray: arr = " + Arrays.toString(arr));
                modificaArray(arr);
                System.out.println("Dopo modificaArray: arr = " + Arrays.toString(arr));
                break;

        }

        // Chiusura Scanner
        scanner.close();
    }
}