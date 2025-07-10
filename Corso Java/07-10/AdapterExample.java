// Definisce l'interfaccia che rappresenta una presa europea
interface EuropeanSocket { 
    // Metodo che fornisce elettricità
    void giveElectricity(); 
}

// Classe che rappresenta una presa americana
class AmericanSocket { 
    // Metodo che fornisce elettricità in stile americano
    public void provideElectricity() { 
        // Stampa messaggio di fornitura elettricità americana
        System.out.println(" Elettricità fornita da presa americana (110V)."); 
    }
}

// Classe adattatore che implementa l'interfaccia europea
class SocketAdapter implements EuropeanSocket {
    // Riferimento alla presa americana da adattare
    private AmericanSocket americanSocket; 

    // Costruttore che riceve una presa americana
    public SocketAdapter(AmericanSocket americanSocket) { 
        // Salva la presa americana
        this.americanSocket = americanSocket; 
    }

    @Override
    // Implementazione del metodo europeo
    public void giveElectricity() { 
        // Messaggio di conversione
        System.out.println(" Adattatore converte la presa da USA a EU...");
        // Chiama il metodo della presa americana
        americanSocket.provideElectricity(); 
    }
}

// Classe che rappresenta un dispositivo europeo
class EuropeanDevice { 
    // Riferimento a una presa europea
    private EuropeanSocket socket; 

    // Costruttore che riceve una presa europea
    public EuropeanDevice(EuropeanSocket socket) { 
        // Salva la presa europea
        this.socket = socket; 
    }

    // Metodo per accendere il dispositivo
    public void powerOn() { 
        // Messaggio di collegamento
        System.out.println(" Collegamento in corso..."); 
        // Richiede elettricità dalla presa europea
        socket.giveElectricity(); 
        // Messaggio di dispositivo acceso
        System.out.println(" Dispositivo europeo acceso.");
    }
}

public class AdapterExample { 
    public static void main(String[] args) { 
        // Crea una presa americana
        AmericanSocket usaSocket = new AmericanSocket(); 

        // Crea un adattatore per la presa americana
        EuropeanSocket adapter = new SocketAdapter(usaSocket); 

        // Crea un dispositivo europeo collegato all'adattatore
        EuropeanDevice laptop = new EuropeanDevice(adapter); 

        // Accende il dispositivo usando la presa americana tramite adattatore
        laptop.powerOn(); 
    }
}
