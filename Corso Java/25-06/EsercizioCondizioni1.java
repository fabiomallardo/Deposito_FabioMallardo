import java.util.Scanner;

public class EsercizioCondizioni1 {
    public static void main(String[] args) {

        //Chiedere l'età all'utente
        Scanner obj1 = new Scanner(System.in);
        System.out.print("Dammi l'età: ");
        int eta = obj1.nextInt();
        System.out.println("L'età è: " + eta);

        //Chiedere il mezzo di trasporto 
        Scanner obj2 = new Scanner(System.in);
        System.out.print("Scegli tra taxi e bus: ");
        String scelta = obj2.nextLine();
        System.out.println("Il mezzo di trasporto è: " + scelta);


        //Controllare se soddisfa i requisiti per entrare
        boolean biglietto = true;
        boolean adulto = true;
        boolean saltaLaFila = true;

        if ((biglietto && adulto) && (saltaLaFila)) {
            System.out.println("L'utente soddisfa i requisiti di accesso");
        } else {
            System.out.println("L'utente non soddisfa i requisiti di accesso");
        }

        obj1.close();
        obj2.close();
    }
}
