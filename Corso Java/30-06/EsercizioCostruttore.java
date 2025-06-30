import java.util.Scanner;

// Creazione classe Classe
class Classe {
    String nome;
    int eta;
    String citta;

    // Costruttore
    public Classe(String nome, int eta, String citta) {
        this.nome = nome;
        this.eta = eta;
        this.citta = citta;
    }

    // Metodo per stampare i dettagli
    public void stampaDettagli() {
        System.out.println(
            "Nome:  " + nome
          + " Età:   " + eta
          + " Città: " + citta
        );
    }
}

public class EsercizioCostruttore {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Primo oggetto
        System.out.print("Dammi il nome della prima persona: ");
        String nome1 = scanner.nextLine();
        System.out.print("Dammi la città della prima persona: ");
        String citta1 = scanner.nextLine();
        Classe persona1 = new Classe(nome1, 40, citta1);
        persona1.stampaDettagli();


        // Secondo oggetto
        System.out.print("Dammi il nome della seconda persona: ");
        String nome2 = scanner.nextLine();
        System.out.print("Dammi la città della seconda persona: ");
        String citta2 = scanner.nextLine();
        Classe persona2 = new Classe(nome2, 30, citta2);
        persona2.stampaDettagli();

        scanner.close();
    }
}
