import java.util.Arrays;

public class ProvaSpecialCharacters {
    public static void main(String[] args){

        //Metodo .split()
        String str = "Hello World";
        String[] words = str.split("\\s");
        System.out.println(Arrays.toString(words));

        //Metodo .length() con stringa "piena" e stringa "vuota"
        String descrizione = "Articolo sulle stringhe...";
        String vuota = "";
        System.out.println("Lunghezza:" + descrizione.length());
        System.out.println("Lunghezza:" + vuota.length());

        //Metodo .equals() //true
        String nuovaStringa = "Ciao";
        String confrontoStringa = "Ciao";
        System.out.println(nuovaStringa.equals(confrontoStringa));

        //Metodo .equals() //false
        String nuovaStringa1 = "Ciao";
        String confrontoStringa1 = "ciao";
        System.out.println(nuovaStringa1.equals(confrontoStringa1));
    }
}
