package observer;

import java.util.*;

// La classe EventoDiGioco rappresenta un oggetto "osservabile" 
// che può notificare eventi a più Observer registrati
public class EventoDiGioco implements Subject {

    // Lista di Observer (cioè chi vuole ricevere notifiche)
    private List<Observer> osservatori = new ArrayList<>();

    // Metodo per registrare un nuovo osservatore
    @Override
    public void aggiungiOsservatore(Observer o) {
        osservatori.add(o);
    }

    // Metodo per rimuovere un osservatore registrato
    @Override
    public void rimuoviOsservatore(Observer o) {
        osservatori.remove(o);
    }

    // Metodo per inviare una notifica a tutti gli osservatori registrati
    @Override
    public void notificaOsservatori(String messaggio) {
        for (Observer o : osservatori) {

            // Ogni observer riceve il messaggio tramite il suo metodo 'aggiorna'
            o.aggiorna(messaggio);
        }
    }
}










