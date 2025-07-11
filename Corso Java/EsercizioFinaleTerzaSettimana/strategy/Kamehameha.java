package strategy;

// Classe concreta che rappresenta l'attacco Kamehameha di Goku
public class Kamehameha implements StrategiaAttacco {

    // Implementazione del metodo nell'interfaccia StrategiaAttacco
    @Override
    public void eseguiAttacco() {

        // Questo è il comportamento specifico di questa strategia
        System.out.println("KAAA... MEEE... HAAA... MEEE... HAAAA!!!");
    }
}
