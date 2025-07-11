package singleton;


// Singleton che rappresenta il GameMaster/Kaio del Nord
public class GameMaster {

    // L’unica istanza statica della classe
    private static GameMaster istanza;

    // Costruttore privato
    private GameMaster() {}

    // Metodo per ottenere l’istanza unica (lazy initialization)
    public static GameMaster getIstanza() {
        if (istanza == null) {
            istanza = new GameMaster();
        }
        return istanza;
    }

    // Metodo utile per annunciare messaggi globali
    public void annuncia(String messaggio) {
        System.out.println("GameMaster: " + messaggio);
    }
}
