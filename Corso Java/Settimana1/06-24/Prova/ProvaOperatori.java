public class ProvaOperatori {
    public static void main(String[] args) {
        // Operatore di addizione con assegnazione
        int x = 10;
        x += 5;
        System.out.println(x);  // stampa 15

        /*  
        Operatori aritmetici
        */
        // Addizione
        int a = 4;
        int b = 2;
        System.out.println("La somma dell'addizione è: " + (a + b));

        // Sottrazione
        int c = 4;
        int d = 2;
        System.out.println("La differenza della sottrazione è: " + (c - d));

        // Moltiplicazione
        int e = 4;
        int f = 2;
        System.out.println("Il prodotto della moltiplicazione è: " + (e * f));

        // Divisione
        int g = 4;
        int h = 2;
        System.out.println("Il risultato della divisione è: " + (g / h));

        // Modulo (resto della divisione)
        int i = 4;
        int l = 2;
        System.out.println("Il resto della divisione è: " + (i % l));

        //Operatore di confronto (==)
        int j = 10;
        int y = 10;
        System.out.println("I due numeri sono uguali? " + (j == y));

        //Operatore di confronto (!=)
        int m = 10;
        int n = 10;
        System.out.println("I due numeri sono uguali? " + (m != n));


        
        /* 
         Operatori logici
         */
         //Operatore AND (&&)
         int firstNumber = 10;
         int secondNumber = 20;
         System.out.println((5 < firstNumber && 10 < secondNumber));


         //Operatore OR (||)
         int firstNumber1 = 10;
         int secondNumber2 = 20;
         System.out.println((100 < firstNumber1 || 10 < secondNumber2));

         //Operatore NOT (!)
         int firstNumber3 = 10;
         int secondNumber4 = 20;
         System.out.println(! (5 < firstNumber3 && 10 < secondNumber4));

         
    }
}
