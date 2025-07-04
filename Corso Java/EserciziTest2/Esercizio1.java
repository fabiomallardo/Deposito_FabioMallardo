// Classe base
class Veicolo {

    // Attributi protetti
    protected String marca;
    protected String modello;
    protected int anno;

    // Costruttore
    public Veicolo(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }


    @Override
    public String toString() {
        return anno + " " + marca + " " + modello;
    }
}

// Sottoclasse Auto 
class Auto extends Veicolo {

    // Attributo privato
    private int numeroPorte;

    // Costruttore
    public Auto(String marca, String modello, int anno, int numeroPorte) {
        super(marca, modello, anno);
        this.numeroPorte = numeroPorte;
    }

    @Override
    public String toString() {
        return super.toString() + " - Auto con " + numeroPorte + " porte";
    }
}

// Sottoclasse Moto
class Moto extends Veicolo {

    // Attributo privato
    private String tipoManubrio;

    // Costruttore
    public Moto(String marca, String modello, int anno, String tipoManubrio) {
        super(marca, modello, anno);
        this.tipoManubrio = tipoManubrio;
    }

    @Override
    public String toString() {
        return super.toString() + " - Moto con manubrio: " + tipoManubrio;
    }
}

public class Esercizio1 {
    public static void main(String[] args) {

        // Creo oggetto auto
        Auto auto = new Auto("Fiat", "Punto", 2015, 5);
        
        // Creo oggetto moto
        Moto moto = new Moto("Yamaha", "MT-07", 2020, "Sportivo");

        // Stampa auto e moto
        System.out.println(auto);
        System.out.println(moto);
    }
}
