package factory;

import model.Personaggio;
import model.Goku;
import model.Vegeta;

// La classe PersonaggiFactory serve per creare oggetti Personaggio
public class PersonaggiFactory {

    // Metodo statico che riceve una stringa con il nome del personaggio
    // e restituisce un oggetto che implementa l'interfaccia Personaggio
    public static Personaggio creaPersonaggio(String nome) {

        switch (nome) {

            // Se l'utente scrive "goku", viene creato un oggetto Goku
            case "Goku":
                return new Goku();

            // Se l'utente scrive "vegeta", viene creato un oggetto Vegeta
            case "Vegeta":
                return new Vegeta();

            // Se il nome non corrisponde a nessun personaggio conosciuto
            default:
                System.out.println("Personaggio non riconosciuto: " + nome);
                return null;
        }
    }
}
