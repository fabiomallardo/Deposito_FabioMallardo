import java.util.Scanner;

// Definisce l'interfaccia IVeicolo con due metodi: Avvia e MostraTipo
interface IVeicolo{
    
    // Metodo per avviare il veicolo
    void Avvia();           
    
    // Metodo per mostrare il tipo di veicolo
    void MostraTipo();      
}

// Implementazione dell'interfaccia IVeicolo per la classe Auto
class Auto implements IVeicolo{
    @Override
    public void Avvia(){
        
        // Stampa messaggio di avvio auto
        System.out.println("Avvio dell'auto"); 
    }

    @Override
    public void MostraTipo(){
        
        // Stampa il tipo di veicolo
        System.out.println("Tipo: Auto");      
    }
}

// Implementazione dell'interfaccia IVeicolo per la classe Moto
class Moto implements IVeicolo{
    @Override
    public void Avvia(){
        
        // Stampa messaggio di avvio moto
        System.out.println("Avvio della moto");
    }

    @Override
    public void MostraTipo(){
        
        // Stampa il tipo di veicolo
        System.out.println("Tipo: Moto");       
    }
}

// Implementazione dell'interfaccia IVeicolo per la classe Camion
class Camion implements IVeicolo{
    @Override
    public void Avvia(){
        
        // Stampa messaggio di avvio camion
        System.out.println("Avvio del camion"); 
    }

    @Override
    public void MostraTipo(){
        
        // Stampa il tipo di veicolo
        System.out.println("Tipo: Camion");     
    }
}

// Classe factory per creare oggetti di tipo IVeicolo
class VeicoloFactory {

    // Metodo statico che crea e restituisce un oggetto IVeicolo in base al tipo passato
    public static IVeicolo CreaVeicolo(String tipo) {
        
        // Se il tipo è null, restituisce null
        if (tipo == null) return null; 

        // Controlla il tipo richiesto e restituisce l'oggetto corrispondente
        switch (tipo.toLowerCase()) {
            case "auto":
            
            // Restituisce un oggetto Auto
                return new Auto();      
            case "moto":
            
            // Restituisce un oggetto Moto
                return new Moto();      
            case "camion":
            
            // Restituisce un oggetto Camion
                return new Camion();    
            default:
            
            // Messaggio di errore
                System.out.println("Tipo non valido."); 
                
                // Restituisce null se il tipo non è valido
                return null;            
        }
    }
}

public class EsercizioFactoryMethod {

    public static void main(String[] args) {
        
        // Inizialiazzione dello scanner
        Scanner scannerScelta = new Scanner(System.in); 

        // Chiede all'utente quale veicolo vuole creare
        System.out.print("Quale veicolo vuoi creare? (auto/moto/camion): ");
        
        String scelta = scannerScelta.nextLine();       

        // Crea il veicolo tramite la factory
        IVeicolo veicolo = VeicoloFactory.CreaVeicolo(scelta); 

        // Se il veicolo è stato creato correttamente
        if (veicolo != null) {    
            
            // Avvia il veicolo
            veicolo.Avvia();      
            
            // Mostra il tipo di veicolo
            veicolo.MostraTipo(); 
        }
        
        // Chiude lo scanner
        scannerScelta.close();          
    }
}
