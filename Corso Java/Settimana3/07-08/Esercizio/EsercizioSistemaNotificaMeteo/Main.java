package EsercizioSistemaNotificaMeteo; 

public class Main { 
    public static void main(String[] args) {

        // Crea una nuova istanza di StazioneMeteo
        StazioneMeteo stazione = new StazioneMeteo(); 

        // Crea un display di tipo console
        Display console = new DisplayConsole();

        // Crea un display di tipo mobile
        Display mobile = new DisplayMobile(); 

        // Aggiunge il display console alla stazione meteo
        stazione.aggiungiDisplay(console); 

        // Aggiunge il display mobile alla stazione meteo
        stazione.aggiungiDisplay(mobile); 

        // Imposta la temperatura a 18.5°C e notifica i display
        stazione.setTemperatura(18.5f); 
        
        // Imposta la temperatura a 25.0°C e notifica i display
        stazione.setTemperatura(25.0f); 
    }
}
