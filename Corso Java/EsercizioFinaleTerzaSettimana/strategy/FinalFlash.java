package strategy; 

// Classe concreta che rappresenta l'attacco Final Flash di Vegeta
public class FinalFlash implements StrategiaAttacco {

    // Implementazione del metodo nell'interfaccia StrategiaAttacco
    @Override
    public void eseguiAttacco() {
        System.out.println("FINAL... FLAASH!!");
    }
}
