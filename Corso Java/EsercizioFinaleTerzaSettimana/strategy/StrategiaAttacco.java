package strategy;

// Interfaccia che rappresenta una strategia di attacco
public interface StrategiaAttacco {

    // Metodo che tutte le strategie concrete dovranno implementare
    // Rappresenta l'attacco vero e proprio del personaggio
    void eseguiAttacco();
}
