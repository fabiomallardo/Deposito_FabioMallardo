import java.util.Scanner;

public class EsercizioFinaleCondizioni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Età
        System.out.print("Dammi l'età (anni): ");
        int eta = scanner.nextInt();

        // Miglior tempo sui 100m (in secondi)
        System.out.print("Dammi il miglior tempo sui 100 metri (in secondi): ");
        double tempo = scanner.nextDouble();

        // Peso (in kg)
        System.out.print("Dammi il peso (in kg): ");
        double peso = scanner.nextDouble();

        // Altezza (in metri, es. 1.75)
        System.out.print("Dammi l'altezza (in metri): ");
        double altezza = scanner.nextDouble();

        // Calcolo del BMI
        double bmi = peso / Math.pow(altezza, 2);

        // età inclusa 18–40, tempo <12s, BMI <25
        if (
            eta >= 18 && eta <= 40
            && tempo < 12.0
            && bmi < 25.0
            ){
            System.out.println("Ammesso alla gara");
        } else {
            System.out.println("Non ammesso alla gara");
        }

        scanner.close();
    }
}
