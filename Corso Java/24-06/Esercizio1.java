import java.util.Scanner; // Import della classe Scanner;

class Esercizio1 {
    public static void main(String[] args) {
        Scanner myObj1 = new Scanner(System.in); // Primo Scanner creato
        // Lettura stringa 
        System.out.print("Dammi una stringa: ");
        String primaStringa = myObj1.nextLine();
        System.out.println("La stringa è: " + primaStringa);

        // Lettura char
        System.out.print("Dammi un carattere: ");
        char primoCarattere = myObj1.nextLine().charAt(0);
        System.out.println("IL carattere è: " + primoCarattere);

        // Lettura booleano
        System.out.print("Dammi un valore booleano: ");
        boolean booleano = myObj1.nextBoolean();
        System.out.println("Il booleano è: " + booleano);

        Scanner myObj2 = new Scanner(System.in); // Secondo Scanner creato
        // Lettura tipo int
        System.out.print("Dammi un numero intero: ");
        int primoNumero = myObj2.nextInt();
        System.out.println("Il numero è: " + primoNumero);

        // Lettura tipo double
        System.out.print("Dammi un numero decimale: ");
        double secondoNumero = myObj2.nextDouble();
        System.out.println("Il numero decimale è: " + secondoNumero);

        // Converisoni
        // da int a double (implicita)
        double primoInDouble = primoNumero;

        // da double a int (esplicita)
        int secondoInInt = (int) secondoNumero;

        System.out.println("int → double : " + primoInDouble);
        System.out.println("double → int : " + secondoInInt);
    }
}
