class Veicolo {
    void run() {
        System.out.println("Il veicolo è in marcia");
    }
}

class Bike extends Veicolo {
    void run() {
        System.out.println("La bici sta correndo");
    }
}

class Bike2 extends Veicolo {
    void run() {
        System.out.println("La bici sta correndo in sicurezza");
    }
}

public class ProvaOverride {
    public static void main(String[] args) {
        Veicolo v1 = new Bike();
        v1.run();

        Veicolo v2 = new Bike2();
        v2.run();
    }
}
