package Progetto;
public class EsempioEccezioni{
    public static void main(String[] args) {
        
        // Blocco di codice try/catch/ finally

        try {

            // Dichiarazioni variabili
            int a = 5;
            int b = 0;
            int c = a / b;

            // Stampa variabile c
            System.out.println(c);

        } catch (Exception ex) {

            // Stampa stack 
            ex.printStackTrace();
            int d = 3 / 0;
            System.out.println(d);

        } finally {
            System.out.println("Finally");
        }
        System.out.println("Programma terminato");
    }
}