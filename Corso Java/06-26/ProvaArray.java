public class ProvaArray {
    public static void main(String[] args) {

        // Dichiarazione e inizializzazione
        int[] numeri = new int[5];
        // Array di dimensione 5

        int[] valori = { 1, 2, 3, 4, 5 };
        // Inizializzazione diretta

        int[] arrayNumero = { 10, 20, 30, 40, 50, 60 };
        System.out.println("Il numero scelto è: " + arrayNumero[4]);

        // Dichiarazione di un array di 5 elementi
        int[] numeri2 = new int[5];

        // Riempimento dell'array con i numeri 1-5
        for (int i = 0; i < numeri2.length; i++) {
            numeri2[i] = i;
        }

        // Stampa degli elementi dell'array
        System.out.println("Elementi dell'array:");
        for (int i = 0; i < numeri2.length; i++) {
            System.out.print(numeri2[i] + " ");
        }

        // Array 2D
        int[][] matrice = new int[3][3];

        // Inizializzazione diretta
        int[][] matricePredefinita = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Elemento centrale: " + matricePredefinita[1][1]);
        
        
        // Dichiarazione di una matrice 3x3
        int[][] matrice3 = new int[3][3]; 

        int valore = 1;

        // Riempimento della matrice con numeri progressivi

        for (int i = 0; i < matrice3.length; i++) {

            for (int j = 0; j < matrice3[i].length; j++) {

                matrice3[i][j] = valore++;

            }

        }

        // Stampa della matrice
        System.out.println("Matrice 3x3:");

        for (int i = 0; i < matrice3.length; i++) {

            for (int j = 0; j < matrice3[i].length; j++) {

                System.out.print(matrice3[i][j] + "\t");

            }

            System.out.println(); // Nuova riga per formattare la matrice

        }
    }
}
