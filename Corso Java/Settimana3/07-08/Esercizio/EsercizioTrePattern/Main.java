package EsercizioTrePattern;

public class Main {
    public static void main(String[] args) {

        // Crea l'observer (console)
        Observer console = new NotificaConsole();

        // Crea un ordine con formaggio e bacon 
        Hamburger ordine = new BaconDecorator(new FormaggioDecorator(BaseBurger.getIstanza()));

        // Mostra l'ordine
        System.out.println("Ordine creato:");
        System.out.println(ordine.getDescrizione());
        System.out.println("Totale: " + ordine.getPrezzo());

        // Notifica l'observer 
        console.aggiorna(ordine.getDescrizione(), ordine.getPrezzo());
    }
}
