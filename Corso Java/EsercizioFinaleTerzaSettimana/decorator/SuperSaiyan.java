package decorator;

import model.Personaggio;

// Decoratore concreto che rappresenta la trasformazione in Super Saiyan
public class SuperSaiyan extends DecoratorePersonaggio {

    // Costruttore: riceve il personaggio da decorare
    public SuperSaiyan(Personaggio personaggio) {
        super(personaggio);
    }

    // Sovrascriviamo il metodo per aumentare la potenza
    @Override
    public int getLivelloPotenza() {
        
        // Aumentiamo la potenza base del doppio
        return (int) (super.getLivelloPotenza() * 2);
    }

    // Sovrascriviamo il metodo per mostrare una versione potenziata delle statistiche
    @Override
    public void mostraStatistiche() {
        System.out.println(super.getNome() + " si è trasformato in Super Saiyan! ");
        System.out.println("Livello Potenza aumentato: " + getLivelloPotenza());
    }
}
