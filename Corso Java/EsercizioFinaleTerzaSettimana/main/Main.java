package main;

import java.util.Scanner;
import model.*;
import factory.*;
import strategy.*;
import decorator.*;
import observer.EventoDiGioco;
import observer.Observer;
import singleton.GameMaster;

public class Main {
    public static void main(String[] args) {

        // Inizializzazione scanner
        Scanner scanner = new Scanner(System.in);

        // Chiedere all'utente che personaggio vuole scegliere
        System.out.print("Scegli il tuo personaggio (Goku / Vegeta): ");
        String nome = scanner.nextLine();

        // Usiamo la Factory per creare il personaggio richiesto
        Personaggio personaggio = PersonaggiFactory.creaPersonaggio(nome);

        if (personaggio == null) {
            System.out.println("Personaggio non valido.");
            scanner.close();
            return;
        }

        // Mostriamo le statistiche base
        personaggio.mostraStatistiche();

        // Assegniamo la strategia di attacco in base al tipo di personaggio
        if (personaggio instanceof Goku) {
            ((Goku) personaggio).setStrategiaAttacco(new Kamehameha());
        } else if (personaggio instanceof Vegeta) {
            ((Vegeta) personaggio).setStrategiaAttacco(new FinalFlash());
        }

        // Eseguiamo l'attacco
        System.out.println("Attacco in corso:");
        if (personaggio instanceof Goku) {
            ((Goku) personaggio).eseguiAttacco();
        } else if (personaggio instanceof Vegeta) {
            ((Vegeta) personaggio).eseguiAttacco();
        }

        // Creiamo un evento di gioco e registriamo il personaggio come Observer
        EventoDiGioco evento = new EventoDiGioco();

        // Per registrarlo come observer, dobbiamo castarlo
        if (personaggio instanceof Observer) {
            evento.aggiungiOsservatore((Observer) personaggio);
            ;
        }

        // Applichiamo la trasformazione Super Saiyan con il Decorator
        System.out.println("Trasformazione in corso...");
        personaggio = new SuperSaiyan(personaggio);

        // Simuliamo un evento globale
        singleton.GameMaster.getIstanza().annuncia("Evento globale in arrivo!");
        evento.notificaOsservatori("Freezer è atterrato su Namecc!");

        // Mostriamo le nuove statistiche dopo la trasformazione
        personaggio.mostraStatistiche();

        scanner.close();
    }
}
