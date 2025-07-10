package EsercizioTrePattern;

// interfaccia Hamburger
interface Hamburger {

    // Metodo restituire descrizione
    public String getDescrizione();

    // Metodo restituire prezzo
    public double getPrezzo();

}

// classe BaseBurger che implementa l'interfaccia Hamburger
class BaseBurger implements Hamburger {

    // Istanza singleton
    private static BaseBurger istanza;

    // Costruttore privato
    private BaseBurger() {
    }

    // Metodo statico per accedere all'istanza
    public static BaseBurger getIstanza() {
        if (istanza == null) {
            istanza = new BaseBurger();
        }
        return istanza;
    }

    // Restituisce il contenuto della descrzione
    public String getDescrizione() {
        // Messaggio di base
        return "Hamburger BaseBurger";
    }

    // Restituisce il contenuto del prezzo
    public double getPrezzo() {
        // Messaggio di base
        return 7.80d;
    }
}

// Classe astratta che implementa l'interfaccia Hamburger
abstract class HamburgerDecorator implements Hamburger {

    // Riferimento a un oggetto Hamburger da decorare
    protected Hamburger hamburger;

    // Costruttore che accetta un Hamburger da decorare
    public HamburgerDecorator(Hamburger hamburger) {

        // Assegna l'oggetto Hamburger passato come parametro al campo hamburger
        this.hamburger = hamburger;
    }

    // Restituisce la descrizione dell'Hamburger decorato
    public String getDescrizione() {

        // Chiama il metodo getDescrizione() dell'oggetto hamburger decorato
        return hamburger.getDescrizione();
    }

    // Restituisce il prezzo dell'Hamburger decorato
    public double getPrezzo() {

        // Chiama il metodo getPrezzo() dell'oggetto hamburger decorato
        return hamburger.getPrezzo();
    }
}

// Decoratore concreto per aggiungere il formaggio all'Hamburger
class FormaggioDecorator extends HamburgerDecorator {

    // Costruttore che accetta un Hamburger da decorare
    public FormaggioDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    // Restituisce la descrizione dell'Hamburger aggiungendo "Formaggio"
    public String getDescrizione() {
        return super.getDescrizione() + ", Formaggio";
    }

    // Restituisce il prezzo dell'Hamburger aggiungendo il costo del formaggio
    public double getPrezzo() {
        return super.getPrezzo() + 0.50;
    }
}

// Decoratore concreto per aggiungere il bacon all'Hamburger
class BaconDecorator extends HamburgerDecorator {

    // Costruttore che accetta un Hamburger da decorare
    public BaconDecorator(Hamburger hamburger) {

        // Chiama il costruttore della superclasse HamburgerDecorator
        super(hamburger);
    }

    // Restituisce la descrizione dell'Hamburger aggiungendo "Bacon"
    public String getDescrizione() {
        return super.getDescrizione() + ", Bacon";
    }

    // Restituisce il prezzo dell'Hamburger aggiungendo il costo del bacon
    public double getPrezzo() {
        return super.getPrezzo() + 0.80;

    }
}

// Interfaccia per l'observer
interface Observer {
    void aggiorna(String descrizione, double prezzo);
}

// classe NotificaConsole che stampa queste notifiche
class NotificaConsole implements Observer {
    public void aggiorna(String descrizione, double prezzo) {
        System.out.println("Nuovo ordine ricevuto!");
        System.out.println("Descrizione: " + descrizione);
        System.out.println("Prezzo totale: " + prezzo);
    }
}
