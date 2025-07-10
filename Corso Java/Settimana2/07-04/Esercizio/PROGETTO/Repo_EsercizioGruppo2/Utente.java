import java.util.ArrayList;

// Creazione classe Utente
public class Utente {

    // Attributi privati
    private String nome;
    private String idUtente;
    private ArrayList<Risorsa> risorsaPresaInPrestito;

    // Costruttori pubblici
    public Utente(String nome, String idUtente) {
        this.nome = nome;
        this.idUtente = idUtente;
        this.risorsaPresaInPrestito = new ArrayList<>();
    }

    // Metodo che restituisce il nome
    public String getNome() {
        return nome;
    }

    // Metodo che restituisce l'idUtente
    public String getIdUtente() {
        return idUtente;
    }

    // metodo per prendere in prestito una risorsa
    public void prendiRisorsaInPrestito(Risorsa r) {
        risorsaPresaInPrestito.add(r);
    }

    // metodo per restituire una risorsa
    public void restituisciRisorsaInPrestito(Risorsa r) {
        risorsaPresaInPrestito.remove(r);
    }

    // Metodo per stampare la lista delle risorse
    public void stampaListaRisorse() {
        System.out.println("Le Risorse in prestito per " + nome + ":");
        for (Risorsa r : risorsaPresaInPrestito) {
            r.visualizzaDettagli();
        }
    }

}
