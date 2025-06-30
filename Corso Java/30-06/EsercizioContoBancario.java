import java.util.Scanner;

// Creazione classe ContoBancario
class BankAccount {

    //Campo per assegnare nome al titolare
     String nomeTitolare; 

     //Campo per assegnare il saldo iniziale
     double saldo;

    // Costruttore
    public BankAccount(String nomeTitolare, double saldoIniziale) {

        //Assegnazione valori ai campi corrispondenti
        this.nomeTitolare = nomeTitolare;
        this.saldo = saldoIniziale;
    }

    // Metodo per effettuare un deposito
    public void deposita(double importo) {
        if (importo <= 0) {
            System.out.println("Importo di deposito non valido.");
            return;
        }
        saldo += importo;
        System.out.println("Deposito effettuato: " + importo);
    }

    // Metodo per effettuare un prelievo
    public void preleva(double importo) {
        if (importo <= 0) {
            System.out.println("Importo di prelievo non valido.");
            return;
        }
        if (importo > saldo) {
            System.out.println("Fondi insufficienti. Operazione annullata.");
            return;
        }
        saldo -= importo;
        System.out.println("Prelievo effettuato: " + importo);
    }

    // Metodo per visualizzare il saldo
     void mostraSaldo() {
        System.out.println("Saldo attuale di " + nomeTitolare + ": " + saldo);
    }
}

public class EsercizioContoBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creazione di un solo conto
        System.out.print("Inserisci il nome del titolare: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci il saldo iniziale: ");
        double saldoIniziale = scanner.nextDouble();

        BankAccount conto = new BankAccount(nome, saldoIniziale);
        System.out.println("Conto creato per " + nome + ".\n");

        boolean esci = false;
        while (!esci) {
            System.out.println("Scegli un'operazione:");
            System.out.println("1. Deposita");
            System.out.println("2. Preleva");
            System.out.println("3. Visualizza saldo");
            System.out.println("4. Esci");
            System.out.print("Opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta) {
                case 1:
                    System.out.print("Importo da depositare: ");
                    double importoDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    conto.deposita(importoDeposito);
                    break;
                case 2:
                    System.out.print("Importo da prelevare: ");
                    double importoPrelievo = scanner.nextDouble();
                    scanner.nextLine();
                    conto.preleva(importoPrelievo);
                    break;
                case 3:
                    conto.mostraSaldo();
                    break;
                case 4:
                    esci = true;
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }

        scanner.close();
    }
}
