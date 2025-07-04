public class ProvaFunzioni {

    // Definizione funzione
    static void saluta() {
        System.out.println("Ciao, Java!");
    }

    // Definizione funzione con metodi
    static int somma(int a, int b) {
        return a + b;
    }

    // Overloading 
    static void mostra(int numero) {
        System.out.println("Numero: " + 10 + numero);
    }

    static void mostra(String testo) {
        System.out.println("Testo: " + testo);
    }

    public static void main(String[] args) {

        // Chiamata della funzione
        saluta();

        // Stampa output
        System.out.println(somma(30, 20));

        // Chiamata della funzione
        mostra(10);
        mostra("Ciao");

    }

}