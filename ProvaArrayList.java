import java.util.ArrayList;
import java.util.Collections;

public class ProvaArrayList {
    public static void main(String[] args){

    //Primo esempio
    ArrayList<Integer> numero = new ArrayList<>();
    numero.add(10);
    numero.add(20);
    numero.add(30);
    

    //Secondo esempio
    ArrayList<Integer> numeri = new ArrayList<>();

    //Aggiunta 10 numeri casuali
    for (int i = 0; i < 10; i++) {
        numeri.add((int) (Math.random() * 100) + 1);
    }

    // Stampa della lista originale 
    System.out.println("Lista originale: " + numeri);

    //Ordinamento della lista
    Collections.sort(numeri);

    // Stampa della lista ordinata
    System.out.println("Lista ordinata: " + numeri);
    
       //Metodo .get: Accede all'elemento in una data posizione 
        ArrayList<String> clothes = new ArrayList<>();
        clothes.add("jacket");
        clothes.add("shirt");
        clothes.add("pullover");
        System.out.println("ArrayList: " + clothes);
        String str = clothes.get(2);
        System.out.print("Element at index 2: " + str);
        

        //Metodo .set: Definisce un nuovo elemento in un indice specifico
        ArrayList<String> colors = new ArrayList<>();
        colors.add("blue");
        colors.add("red");
        colors.add("green");
        System.out.println("ArrayList: " + colors);
        colors.set(2, "yellow");
        System.out.println("Modified ArrayList: " + colors);
    }
    
}
