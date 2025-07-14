import java.util.*;

// l'interfaccia Observer
interface Dispositivo {

    // Metodo che ogni Observer deve implementare per ricevere notifiche
    void aggiorna(String messaggio);
}

// interfaccia Subject
interface CentroControllo {

    // Metodo per registrare un Observer
    void registraDispositivo(Dispositivo d);

    // Metodo per rimuovere un Observer
    void rimuoviDispositivo(Dispositivo d);

    // Metodo per notificare tutti gli Observer
    void notificaDispositivi(String evento);
}

// Implementa il Subject
class SmartHomeHub implements CentroControllo {

    // Lista degli Observer registrati
    private List<Dispositivo> dispositivi = new ArrayList<>();

    // Registra un nuovo Observer
    public void registraDispositivo(Dispositivo d) {

        // Aggiunge alla lista
        dispositivi.add(d);
        System.out.println("Dispositivo registrato.");
    }

    // Rimuove un Observer
    public void rimuoviDispositivo(Dispositivo d) {

        // Rimuove dalla lista
        dispositivi.remove(d);
        System.out.println("Dispositivo rimosso.");
    }

    // Notifica tutti gli Observer di un evento
    public void notificaDispositivi(String evento) {
        System.out.println("\n[Hub] Evento rilevato: " + evento);
        // Cicla su tutti gli Observer
        for (Dispositivo d : dispositivi) {
            // Chiama il metodo di aggiornamento su ciascuno
            d.aggiorna(evento);
        }
    }
}

// Implementa Observer per una luce smart
class LuceSmart implements Dispositivo {
    private String nome;

    // Costruttore che riceve il nome
    public LuceSmart(String nome) {
        this.nome = nome;
    }

    // Implementazione del metodo di notifica
    public void aggiorna(String messaggio) {
        System.out.println("Luce " + nome + ": reagisce a: " + messaggio);
    }
}

// Implementa Observer per un allarme smart
class AllarmeSmart implements Dispositivo {

    // Implementazione del metodo di notifica
    public void aggiorna(String messaggio) {
        System.out.println("Allarme: attivato per:  " + messaggio);
    }
}

// Classe di un dispositivo esterno non compatibile con Observer
class SensoreEsterno {

    // Metodo di notifica specifico
    public void avvisa(String messaggio) {
        System.out.println("Sensore Esterno riceve: " + messaggio);
    }
}

// Adapter che rende compatibile SensoreEsterno con Observer
class SensoreEsternoAdapter implements Dispositivo {

    // Riferimento al sensore esterno
    private SensoreEsterno sensore;

    // Costruttore che riceve il sensore
    public SensoreEsternoAdapter(SensoreEsterno sensore) {
        this.sensore = sensore;
    }

    // Implementazione del metodo Observer
    public void aggiorna(String messaggio) {
        sensore.avvisa(messaggio);
    }
}

public class Esercizio4 {
    public static void main(String[] args) {

        // Inizializzazione scanner
        Scanner scanner = new Scanner(System.in);

        // Crea l'hub centrale
        SmartHomeHub hub = new SmartHomeHub();

        // Crea una luce smart per la cucina
        Dispositivo luceCucina = new LuceSmart("Cucina");

        // Crea un allarme smart
        Dispositivo allarme = new AllarmeSmart();

        // Crea un sensore esterno tramite adapter
        Dispositivo sensoreEsterno = new SensoreEsternoAdapter(new SensoreEsterno());

        // Variabile per controllare il ciclo del menu
        boolean running = true;

        while (running) {
            System.out.println("\n=== SMART HOME MENU ===");
            System.out.println("1. Registra luce smart (Cucina)");
            System.out.println("2. Registra allarme smart");
            System.out.println("3. Registra sensore esterno (con adapter)");
            System.out.println("4. Invia evento (notifica a tutti)");
            System.out.println("0. Esci");

            // Chiede la scelta all'utente
            System.out.print("Scelta: ");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":

                    // Registra la luce smart
                    hub.registraDispositivo(luceCucina);
                    break;

                case "2":

                    // Registra l'allarme smart
                    hub.registraDispositivo(allarme);
                    break;

                case "3":

                    // Registra il sensore esterno tramite adapter
                    hub.registraDispositivo(sensoreEsterno);
                    break;

                case "4":

                    // Chiede all'utente la descrizione dell'evento
                    System.out.print("Descrizione evento (es: Fumo in cucina): ");
                    String evento = scanner.nextLine();

                    // Notifica tutti i dispositivi dell'evento
                    hub.notificaDispositivi(evento);
                    break;

                case "0":

                    // Termina il ciclo
                    running = false;
                    System.out.println("Sistema Smart Home spento.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }

        // Chiude lo scanner
        scanner.close();
    }
}
