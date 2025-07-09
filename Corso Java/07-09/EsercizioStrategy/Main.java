package EsercizioStrategy;

public class Main {
    public static void main(String[] args) {
        Calcolatore calcolatore = new Calcolatore();

        // Strategia: Addizione
        calcolatore.setCalcolatore(new Addizione());
        int risultatoAddizione = calcolatore.calcola(10, 50);
        System.out.println("Risultato Addizione: " + risultatoAddizione);

        // Strategia: Moltiplicazione
        calcolatore.setCalcolatore(new Moltiplicazione());
        int risultatoMoltiplicazione = calcolatore.calcola(10, 50);
        System.out.println("Risultato Moltiplicazione: " + risultatoMoltiplicazione);
    }
}
