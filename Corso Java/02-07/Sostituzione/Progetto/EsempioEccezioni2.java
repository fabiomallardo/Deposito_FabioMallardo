package Progetto;
import java.util.Scanner;

public class EsempioEccezioni2 {
    public static void main(String[] args) {

        //Blocco try / catch 
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Inserire un numero: ");
            int input = scanner.nextInt();
            System.out.println("Inserito: " + input);
            int x = input / 0;
            System.out.println(" x = " + x);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
}
