public class EsercizioFinaleCondizioniRandomizzato {
    public static void main(String[] args) {

        //Età casuale:
        int eta = (int)(Math.random() * 51);

        //Tempo sui 100 m casuale:
        double tempo = (double)(Math.random() * 16.0d);

        //Peso casuale:
        double peso = (double)(Math.random() * 80.5d);

        //Altezza casuale
        double altezza = (double)(Math.random() * 2.20d);

        //Calcolo bmi
        double bmi = peso / Math.pow(altezza, 2);

        //Condizioni per partecipare alla garaWS
        if (
            eta >= 18 && eta <= 40
            && tempo < 12.0d
            && bmi < 25.0d
        ) {
            System.out.println("Ammesso alla gara");
        } else {
            System.out.println("Non ammesso alla gara");
        }
    }
    
}