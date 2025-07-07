package EsercizioSingleton;

public class Main {
    public static void main(String[] args) {

        // Richiamo del Singleton
        Logger logger = Logger.getIstanza();
        Logger logger2 = Logger.getIstanza();

        // Richiamo del metodo per scrivere due messaggi
        logger.scriviMessaggio("Nuovo messaggio 1");
        logger2.scriviMessaggio("Nuovo messaggio 2");

        // Confronto tra i due logger per vedere se sono uguali
        System.out.println("Le due instanze sono uguali? " + (logger == logger2));
    }
}
