package EsercizioSistemaNotificaMeteo; 

import java.util.*; 

// Definisce l'interfaccia Display
interface Display{ 

    // Metodo astratto che aggiorna la temperatura 
    void aggiorna(float temperatura); 
}


// Definisce la classe StazioneMeteo
class StazioneMeteo { 

    //Inizializzazione della lista di oggetti Displays
    private List<Display> displays = new ArrayList<>(); 

    // Variabile per la temperatura
    private float temperatura; 
    

    // Metodo che aggiunge un display alla lista
    public void aggiungiDisplay(Display d){ 
        displays.add(d); 
    }

    // Metodo che rimuove un display alla lista
    public void rimuoviDisplay(Display d){ 
        displays.remove(d); 
    }

    // Metodo per settare la temperatura
    public void setTemperatura(float temperatura){
        // Aggiorna la variabile temperatura
        this.temperatura = temperatura; 

        // Notifica tutti i display del cambiamento
        notificaDisplay(); 
    }

    // Metodo per notificare tutti i display
    public void notificaDisplay(){ 
        for (Display d : displays){ 
            d.aggiorna(temperatura);
        }
    }
}

// Definisce la classe DisplayConsole che implementa Display
class DisplayConsole implements Display { 

    // Implementa il metodo aggiorna
    public void aggiorna(float temperatura) { 
    System.out.println("Console: Temperatura aggiornata a " + temperatura + "°C"); 
    }
}

// Definisce la classe DisplayMobile che implementa Display
class DisplayMobile implements Display { 
    
    // Implementa il metodo aggiorna
    public void aggiorna(float temperatura) { 
    System.out.println("Mobile: Temperatura attuale " + temperatura + "°C");
    }
}
