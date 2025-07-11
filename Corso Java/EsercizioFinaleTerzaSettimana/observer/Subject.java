package observer;

// Interfaccia che rappresenta un soggetto osservabile
public interface Subject {

    // Registra un nuovo osservatore
    void aggiungiOsservatore(Observer o);

    // Rimuove un osservatore registrato
    void rimuoviOsservatore(Observer o);

    // Notifica tutti gli osservatori
    void notificaOsservatori(String messaggio);
}
