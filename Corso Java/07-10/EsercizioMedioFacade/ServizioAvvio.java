package EsercizioMedioFacade;

// Interfaccia Observer
public interface ServizioAvvio {
    void esegui();
}

// Observer concreto: antivirus
class Antivirus implements ServizioAvvio {
    public void esegui() {
        System.out.println(">> Servizio: Antivirus avviato.");
    }
}

// Observer concreto: gestione aggiornamenti
class GestoreUpdate implements ServizioAvvio {
    public void esegui() {
        System.out.println(">> Servizio: Verifica aggiornamenti...");
    }
}

