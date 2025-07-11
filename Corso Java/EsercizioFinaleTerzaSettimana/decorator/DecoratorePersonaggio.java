package decorator;

import model.Personaggio;

// Classe astratta che implementa Personaggio ed è la base dei decoratori
public abstract class DecoratorePersonaggio implements Personaggio {

    // Il personaggio originale da decorare
    protected Personaggio personaggio;

    // Costruttore che riceve un oggetto Personaggio
    public DecoratorePersonaggio(Personaggio personaggio) {
        this.personaggio = personaggio;
    }

    // Implementiamo i metodi di Personaggio delegandoli al personaggio originale
    @Override
    public String getNome() {
        return personaggio.getNome();
    }

    @Override
    public int getLivelloPotenza() {
        return personaggio.getLivelloPotenza();
    }

    @Override
    public void mostraStatistiche() {
        personaggio.mostraStatistiche();
    }
}
