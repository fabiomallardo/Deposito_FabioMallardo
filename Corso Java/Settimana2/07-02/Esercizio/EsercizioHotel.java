import java.util.ArrayList; 
import java.util.Scanner;

class Camera { // Definizione della classe Camera
    private int numero; // Numero della camera
    private float prezzo; // Prezzo della camera

    public Camera(int numero, float prezzo) { // Costruttore della classe Camera
        this.numero = numero; // Inizializza il numero della camera
        this.prezzo = prezzo; // Inizializza il prezzo della camera
    }

    public int getNumero() { // Restituisce il numero della camera
        return numero;
    }

    public void setNumero(int numero) { // Imposta il numero della camera
        this.numero = numero;
    }

    public float getPrezzo() { // Restituisce il prezzo della camera
        return prezzo;
    }

    public void setPrezzo(float prezzo) { // Imposta il prezzo della camera
        this.prezzo = prezzo;
    }

    public void dettagli() { // Stampa i dettagli della camera (numero e prezzo)
        System.out.println("Camera numero: " + numero + ", Prezzo: " + prezzo + "€");
    }

    public void dettagli(boolean conPrezzo) { // Stampa i dettagli della camera, con o senza prezzo
        if (conPrezzo) {
            System.out.println("Camera numero: " + numero + ", Prezzo: " + prezzo + "€");
        } else {
            System.out.println("Camera numero: " + numero);
        }
    }
}

class Suite extends Camera { // Definizione della classe Suite che estende Camera
    private String serviziExtra; // Servizi extra della suite

    public Suite(int numero, float prezzo, String serviziExtra) { // Costruttore della Suite
        super(numero, prezzo); // Chiama il costruttore della superclasse Camera
        this.serviziExtra = serviziExtra; // Inizializza i servizi extra
    }

    public String getServiziExtra() { // Restituisce i servizi extra
        return serviziExtra;
    }

    public void setServiziExtra(String serviziExtra) { // Imposta i servizi extra
        this.serviziExtra = serviziExtra;
    }

    @Override
    public void dettagli() { // Stampa i dettagli della suite (override del metodo Camera)
        System.out.println(
                "Suite numero: " + getNumero() + ", Prezzo: " + getPrezzo() + "€, Servizi extra: " + serviziExtra);
    }
}

class Hotel { // Definizione della classe Hotel
    
    private String nome; // Nome dell'hotel
    private ArrayList<Camera> camere; // Lista delle camere dell'hotel

    public Hotel(String nome) { // Costruttore dell'hotel
        this.nome = nome; // Inizializza il nome
        this.camere = new ArrayList<>(); // Inizializza la lista delle camere
    }

    public void aggiungiCamera(Camera camera) { // Aggiunge una camera alla lista
        camere.add(camera);
    }

    public ArrayList<Camera> getCamere() { // Restituisce la lista delle camere
        return camere;
    }

    public static int contaSuite(ArrayList<Camera> lista) { // Conta quante suite ci sono nella lista
        int count = 0; // Inizializza il contatore
        for (Camera c : lista) { // Scorre tutte le camere
            if (c instanceof Suite) // Se la camera è una suite
                count++; // Incrementa il contatore
        }
        return count; // Restituisce il numero di suite
    }
}

public class EsercizioHotel { // Classe principale
    public static void main(String[] args) { // Metodo main
        Scanner inputInt = new Scanner(System.in); // Scanner per numeri
        Scanner inputStr = new Scanner(System.in); // Scanner per stringhe

        System.out.print("Inserisci il nome dell'hotel: "); // Chiede il nome dell'hotel
        String nomeHotel = inputStr.nextLine(); 

        Hotel hotel = new Hotel(nomeHotel); // Crea un nuovo hotel

        System.out.print("Quante camere vuoi aggiungere? "); // Chiede quante camere aggiungere
        int n = inputInt.nextInt();

        for (int i = 0; i < n; i++) { // Ciclo per inserire le camere
            System.out.print("La camera " + (i + 1) + " è una Suite? (s/n): "); // Chiede se è una suite
            String tipo = inputStr.nextLine();

            System.out.print("Numero camera: "); // Chiede il numero della camera
            int numero = inputInt.nextInt();

            System.out.print("Prezzo: "); // Chiede il prezzo
            float prezzo = inputInt.nextFloat(); 

            if (tipo.equalsIgnoreCase("s")) { // Se è una suite
                System.out.print("Servizi extra: "); // CHiede servizi extra
                String servizi = inputStr.nextLine(); // Legge i servizi extra
                hotel.aggiungiCamera(new Suite(numero, prezzo, servizi)); // Aggiunge una suite
            } else {
                hotel.aggiungiCamera(new Camera(numero, prezzo)); // Aggiunge una camera normale
            }
        }

        // Stampa dettagliata delle camere numero
        System.out.println("--- DETTAGLI CAMERE (SOLO NUMERO) ---");
        for (Camera c : hotel.getCamere()) {
            c.dettagli(false); // Stampa solo il numero
        }

        // Stampa dettagliata delle camere prezzo 
        System.out.println("--- DETTAGLI CAMERE (CON PREZZO) ---");
        for (Camera c : hotel.getCamere()) {
            c.dettagli(true); // Stampa numero e prezzo
        }

        // Stampa dettagli delle sole suite
        System.out.println("--- DETTAGLI SUITE SPECIFICHE ---");
        for (Camera c : hotel.getCamere()) {
            if (c instanceof Suite) { // Se è una suite
                c.dettagli(); // Stampa dettagli suite (override)
            }
        }

        int numeroSuite = Hotel.contaSuite(hotel.getCamere()); // Conta le suite
        System.out.println("Numero di suite nell'hotel: " + numeroSuite); // Stampa il numero di suite

        inputInt.close(); // Chiude lo scanner dei numeri
        inputStr.close(); // Chiude lo scanner delle stringhe
    }
}
