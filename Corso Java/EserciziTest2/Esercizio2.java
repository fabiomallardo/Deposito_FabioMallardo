import java.util.Scanner;

// Classe ContoBancario
class ContoBancario {

    // Attributi privati
    private int numeroConto;
    private double saldo;
    private String titolare;

    // Costruttore
    public ContoBancario(int numeroConto, double saldo, String titolare){
        this.numeroConto = numeroConto;
        this.saldo = saldo;
        this.titolare = titolare;
    }

    // Metodo per restituire  il numero del conto
    public int getNumeroConto(){
        return numeroConto;
    }
    // Metodo per restituire  la quantità del saldo
    public double getSaldo(){
        return saldo;
    }
    // Metodo per restituire  il nome del titolare
    public String getTitolare(){
        return titolare;
    }

    // Metodo per depositare fondi
    public void deposita(double importo){
        if (importo > 0 ){
            saldo = saldo + importo;
            System.out.println("I soldi che hai appena depositato sono: " + importo);
        } else {
            System.out.println("Importo non valido, impossibile effettuare il deposito");
        }
    }

    // Metodo per prelevare fondi
    public void preleva(double importo){
        if (importo <= saldo){
            saldo = saldo - importo;
            System.out.println("I soldi che hai appena prelavato sono: " + importo);
        } else {
            System.out.println("Non hai a disposizione quei soldi sul tuo conto");
        }
    }
}

public class Esercizio2 {

    public static void main(String[] args) {
        
        // Inizialiazzazione degli Scanner
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);
        
        // Richiesta all'utente di inserire il numero del conto
        System.out.print("Inserisci il numero del conto: ");
        int numeroConto = scannerNum.nextInt();

        // Richietsa all'utente di inserire il nome del titolare
        System.out.print("Inserisci il nome del titolare: ");
        String titolare = scannerStr.nextLine();

        // Richiesta all'utente di inserire il saldo
        System.out.print("Inserisci il saldo iniziale: ");
        double saldoIniziale = scannerNum.nextDouble();

        // Creazione conto
        ContoBancario conto = new ContoBancario(numeroConto, saldoIniziale, titolare);

        // Operazioni
        System.out.print("Quanto vuoi depositare? ");
        double importoDeposito = scannerNum.nextDouble();
        conto.deposita(importoDeposito);

        System.out.print("Quanto vuoi prelevare? ");
        double importoPrelievo = scannerNum.nextDouble();
        conto.preleva(importoPrelievo);

        // Stampa saldo finale
        System.out.println("Saldo finale per " + conto.getTitolare() + ": " + conto.getSaldo() + "€");

        // Chiusura scanner
        scannerStr.close();
        scannerNum.close();
    }
}