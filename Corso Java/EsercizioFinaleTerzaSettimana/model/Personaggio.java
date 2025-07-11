 package model;


// interfaccia Personaggio rappresenta un'entità generica all'interno del sistema,
public interface Personaggio {
    
    // Metodo che restituisce il nome del personaggio
    String getNome();
    
    // Metodo che restituisce il livello di potenza del personaggio
    int getLivelloPotenza();
    
    // Metodo che mostra le statistiche del personaggio
    void mostraStatistiche();

}

