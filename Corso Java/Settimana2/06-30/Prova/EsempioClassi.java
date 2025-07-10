//Creazione classe Auto
class Auto {
    String marca;
    int anno;
    double prezzo;

    void mostraInfo() {
        System.out.println(marca + " - " + anno + " - €" + prezzo);
    }
}

// Creazione classe Studente
class Studente {

    // Variabile di istanza
    String nome;

    // Variabile statica
    static int totaleStudenti = 0;

    Studente(String nome) {
        this.nome = nome;
        totaleStudenti++;
    }
}

public class EsempioClassi {
    public static void main(String[] args) {

        // Creazione oggetto
        Auto miaAuto = new Auto();

        // Assegnazione valori
        miaAuto.marca = "Tesla";
        miaAuto.anno = 2023;
        miaAuto.prezzo = 59999.99d;

        // Richiamo del metodo
        miaAuto.mostraInfo();

        // Creazione oggetto
        Studente s1 = new Studente("Marco");
        Studente s2 = new Studente("Lucia");

        System.out.println("Totale studenti: " + Studente.totaleStudenti);
    }
}
