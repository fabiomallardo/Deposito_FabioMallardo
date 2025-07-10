package EsercizioDecoratoreMessaggio;

public class Main {
    public static void main(String[] args) {

        // Messaggio 
        Messaggio messaggio = new MessaggioBase();

        // Messaggio decorato 
        Messaggio messaggioDecorato = new DecoratoreMaiuscolo(messaggio);

        // Stampo 
        System.out.println("Messaggio decorato: " + messaggioDecorato.getContenuto());
    }
}
