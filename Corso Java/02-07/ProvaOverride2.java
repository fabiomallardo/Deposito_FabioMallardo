class Studente {

    private String nome;
    private int eta;

    // Costruttore
    public Studente(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Override del metodo toString()
    @Override
    public String toString() {
        return "Studente: " + nome + ", Età: " + eta;
    }
}

public class ProvaOverride2 {
    public static void main(String[] args) {
        Studente s1 = new Studente("Luca", 20);
        System.out.println(s1); // Chiama automaticamente toString()
    }
}
