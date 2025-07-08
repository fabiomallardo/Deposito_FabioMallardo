package EsercizioDecoratoreMessaggio;

// Definisce il contratto per i messaggi
interface Messaggio { 
    
    // Metodo per ottenere il contenuto del messaggio
    String getContenuto(); 
}

// Implementazione base di Messaggio
class MessaggioBase implements Messaggio {
    
    // Restituisce il contenuto del messaggio
    public String getContenuto() { 
    
        // Messaggio di base
        return "Prova esempio decoratore messaggio"; 
    }
}

// Classe astratta per i decoratori
abstract class MessaggioDecoratore implements Messaggio { 

    // Riferimento al messaggio da decorare
    protected Messaggio messaggio; 

    // Costruttore che accetta un messaggio
    public MessaggioDecoratore(Messaggio messaggio) { 

        // Salva il riferimento al messaggio
        this.messaggio = messaggio; 
    }

    // Implementazione base che delega al messaggio originale
    public String getContenuto() { 
        
        // Restituisce il contenuto del messaggio decorato
        return messaggio.getContenuto(); 
    }
}

// Estende il decoratore astratto
class DecoratoreMaiuscolo extends MessaggioDecoratore { 

    // Costruttore che accetta un messaggio
    public DecoratoreMaiuscolo(Messaggio messaggio) { 
        
        // Passa il messaggio al costruttore della superclasse
        super(messaggio); 
    }

    // Sovrascrive il metodo per modificare il comportamento
    public String getContenuto() { 
        
        // Restituisce il contenuto in maiuscolo
        return super.getContenuto().toUpperCase(); 
    }
}
