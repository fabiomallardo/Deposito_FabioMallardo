package EsercizioMedioFacade; 

import java.util.ArrayList;   
import java.util.List;        

// Definizione della classe principale FacadeSingleton
public class FacadeSingleton { 
    // Variabile statica per l'istanza Singleton
    private static FacadeSingleton istanza; 

    // Riferimento al componente BIOS
    private Bios bios;                        
    
    // Riferimento al componente HardDisk
    private HardDisk hardDisk;               
    
    // Riferimento al componente SistemaOperativo
    private SistemaOperativo sistemaOperativo; 

    // Costruttore privato per Singleton
    private FacadeSingleton() {              
        
        // Inizializza il BIOS
        bios = new Bios();                   
        
        // Inizializza l'HardDisk
        hardDisk = new HardDisk();           
        
        // Inizializza il Sistema Operativo
        sistemaOperativo = new SistemaOperativo(); 
    }

    // Metodo statico per ottenere l'istanza Singleton
    public static FacadeSingleton getIstanza() { 
        
        // Se non esiste ancora l'istanza
        if (istanza == null) {                   
            
            // Crea una nuova istanza
            istanza = new FacadeSingleton();     
        }
        
        // Restituisce l'istanza
        return istanza;                          
    }

    public SistemaOperativo getSistemaOperativo() { 
        // Restituisce il riferimento al Sistema Operativo
        return sistemaOperativo;
    }

    // Metodo per avviare il computer tramite Facade
    public void accendiComputer() {              
        System.out.println(">>> Avvio computer in corso...");

        // Inizializza il BIOS
        bios.inizializza();                      
        // Carica le impostazioni del BIOS
        bios.carica();                           
        // Avvia il BIOS
        bios.avvia();                            

        // Inizializza l'HardDisk
        hardDisk.inizializza();                  
        // Carica i dati di sistema dall'HardDisk
        hardDisk.carica();                       
        // Avvia l'HardDisk
        hardDisk.avvia();                       

        // Inizializza il Sistema Operativo
        sistemaOperativo.inizializza();          
        // Carica l'interfaccia del Sistema Operativo
        sistemaOperativo.carica();               
        // Avvia il Sistema Operativo
        sistemaOperativo.avvia();               

        System.out.println("\n>>> Computer avviato con successo.");
    }

    //  Componenti del sottosistema

    // Classe interna per il BIOS
    static class Bios {                          
        // Metodo per inizializzare il BIOS
        public void inizializza() {              
            System.out.println("BIOS: Inizializzazione completata.");
        }

        // Metodo per caricare le impostazioni del BIOS
        public void carica() {                   
            System.out.println("BIOS: Caricamento impostazioni...");
        }

        // Metodo per avviare il BIOS
        public void avvia() {                   
            System.out.println("BIOS: Avvio completato.");
        }
    }

    // Classe interna per l'HardDisk
    static class HardDisk {                      
        // Metodo per inizializzare l'HardDisk
        public void inizializza() {              
            System.out.println("HardDisk: Inizializzazione del disco...");
        }

        // Metodo per caricare i dati di sistema
        public void carica() {                   
            System.out.println("HardDisk: Caricamento dati di sistema...");
        }

        // Metodo per avviare l'HardDisk
        public void avvia() {                    
            System.out.println("HardDisk: Disco pronto.");
        }
    }

    // Classe interna per il Sistema Operativo
    static class SistemaOperativo {              
        // Lista dei servizi di avvio
        private List<ServizioAvvio> servizi = new ArrayList<>(); 

        // Metodo per inizializzare il Sistema Operativo
        public void inizializza() {              
            System.out.println("Sistema Operativo: Configurazione iniziale...");
        }

        // Metodo per caricare l'interfaccia
        public void carica() {                   
            System.out.println("Sistema Operativo: Caricamento interfaccia...");
        }

        // Metodo per avviare il Sistema Operativo
        public void avvia() {                    
            System.out.println("Sistema Operativo: Benvenuto!");
            // Avvia i servizi registrati
            notificaServizi();                   
        }

        // Metodo per registrare un servizio di avvio
        public void registraServizio(ServizioAvvio s) { 
            servizi.add(s);
        }

        // Metodo privato per notificare i servizi di avvio
        private void notificaServizi() {         
            System.out.println("Sistema Operativo: Avvio dei servizi in background...");
            // Per ogni servizio registrato
            for (ServizioAvvio s : servizi) {    
                // Esegue il servizio
                s.esegui();                      
            }
        }
    }
}
