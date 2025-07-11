package model;

import strategy.*;
import observer.*;

// La classe Vegeta implementa le interfacce Personaggio e Observer
public class Vegeta implements Personaggio, Observer {

    // Attributi di base
    private String nome = "Vegeta";
    private int livelloPotenza = 8000;

    // Campo per contenere la strategia d'attacco attuale
    private StrategiaAttacco strategiaAttacco;

    // Metodo per assegnare dinamicamente la strategia
    public void setStrategiaAttacco(StrategiaAttacco strategia) {
        this.strategiaAttacco = strategia;
    }

    // Metodo che esegue l'attacco secondo la strategia attuale
    public void eseguiAttacco() {
        if (strategiaAttacco != null) {
            strategiaAttacco.eseguiAttacco();
        } else {
            System.out.println(nome + " non ha una strategia d'attacco!");
        }
    }

    // Metodo dell'interfaccia Observer: riceve notifiche dagli eventi
    @Override
    public void aggiorna(String messaggio) {
        System.out.println("NOTIFICA per " + nome + ": " + messaggio);
    }

    // Implementazioni dei metodi dell'interfaccia Personaggio
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getLivelloPotenza() {
        return livelloPotenza;
    }

    @Override
    public void mostraStatistiche() {
        System.out.println(nome + " - Livello Potenza: " + livelloPotenza);
    }
}
