package EsercizioMedioFacade;

public class Main {
    public static void main(String[] args) {
        // Ottieni l'istanza singleton del Facade
        FacadeSingleton pc = FacadeSingleton.getIstanza();

        // Registra servizi come observer
        pc.getSistemaOperativo().registraServizio(new Antivirus());
        pc.getSistemaOperativo().registraServizio(new GestoreUpdate());

        // Avvia il computer
        pc.accendiComputer();
    }
}
