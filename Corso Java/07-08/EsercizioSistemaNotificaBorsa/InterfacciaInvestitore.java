package EsercizioSistemaNotificaBorsa;

import java.util.*;

// Definizione interfaccia Display
interface Investitore {

    // Metodo astratto che notifica
    public void notifica(String azione, double valore);
}

// Definizione della classe AgenziaBorsa
class AgenziaBorsa {

    // Definzione Singleton
    private static AgenziaBorsa istanza = null;

    //Lista di investitori privati
    List<Investitore> investitori = new ArrayList<>();

    // Costruttore privato
    private AgenziaBorsa(){}

    // Metodo per ottenere l'istanza
    public static AgenziaBorsa getIstanza(){
        // Verifica che ci fosse
        if (istanza == null){
            
            // Crearea una nuova istanza
            istanza = new AgenziaBorsa();
        } 
            // Restituisci l'istanza esistente
            return istanza;
    } 

    // Metodo che aggiunge un invetsigatore
    public void aggiungiInvestitore(Investitore i){
        investitori.add(i);
    }

    // Metodo che rimuove un invetsigatore
    public void rimuoviInvestitore(Investitore i){
        investitori.remove(i);
    }

    // Metodo che notifica gli investitori
    public void notificaInvestitori(String azione, double valore){
        for (Investitore i : investitori){
            i.notifica(azione, valore);
        }
    }
    
}

// Definizione classe InvestitorePrivato che implementa l'interfaccia Investitore
class InvestitorePrivato implements Investitore{
    
    // Metodod che risponde con messaggio persoanlizzati
    public void notifica(String azione, double valore){
        System.out.println("Investitore Privato: L' azione è " + azione + " , e il valore della quale è " + valore);
    }
}

// Definizione classe InvestitoreBanacrio che implementa l'interfaccia Investitore
class InvestitoreBancario implements Investitore{
    
    // Metodod che risponde con messaggio persoanlizzati
    public void notifica(String azione, double valore){
        System.out.println("Investitore Bancario: L' azione è " + azione + " , e il valore della quale è " + valore);
    }
}

