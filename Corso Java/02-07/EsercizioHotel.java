import java.util.ArrayList; 
import java.util.Scanner;   

class Camera { // Definizione della classe Camera
    private int numero;     // Numero della camera
    private float prezzo;   // Prezzo della camera

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

    public void dettagli() { // Stampa i dettagli della camera
        System.out.println("Camera numero: " + numero + ", Prezzo: " + prezzo + "€");
    }

    public void dettagli(boolean conPrezzo) { // Stampa i dettagli con prezzo eventualmente
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
    public void dettagli() { // Stampa i dettagli della suite 
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
        int count = 0;
        for (Camera c : lista) { // Scorre tutte le camere
            if (c instanceof Suite) // Se la camera è una suite
                count++;
        }
        return count;
    }
}


