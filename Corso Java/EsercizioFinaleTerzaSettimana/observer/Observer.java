package observer;

// Interfaccia che rappresenta chi riceve le notifiche
public interface Observer {

    // Metodo che viene chiamato quando c'è una nuova notifica
    void aggiorna(String messaggio);
}
