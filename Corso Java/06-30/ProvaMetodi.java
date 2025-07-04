import java.util.ArrayList;

//Classe Auto2
class Auto2 {
    String marca;
    int anno;

    Auto2(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }
}

// Classe Claolcatrice
class Calcolatrice {
}

public class ProvaMetodi {
    // Metodo con ritorno
    int somma(int a, int b) {
        return a + b;
    }

    // Metodo senza ritorno
    void saluta() {
        System.out.println("Ciao!");
    }

    public static void main(String[] args) {
        ProvaMetodi calc = new ProvaMetodi();
        calc.saluta();
        int risultato = calc.somma(15, 3);
        System.out.println("La somma è: " + risultato);

        ArrayList<Auto2> autoList = new ArrayList<>();
        autoList.add(new Auto2("Tesla", 2023));
        autoList.add(new Auto2("Ford", 2020));

        for (Auto2 auto : autoList) {
            System.out.println(auto.marca + " - " + auto.anno);
        }
    }
}