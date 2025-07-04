package Progetto;
public class TestDivisione {
    public static void main(String[] args) {

        try {
            EsempioDivisione.divisioneChecked(4, 2);

            try {
                EsempioDivisione.divisioneUnchecked(4, 0);
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                System.out.println(message);

            }
            try {
                EsempioDivisione.divisione3(1, 0);
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                System.out.println(message);
            }
            System.out.println("Ciao");
        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println(message);
            Throwable causa = e.getCause();
            e.printStackTrace();
            causa.printStackTrace();
        } finally {
            System.out.println("Ciao");
        }
        System.out.println("Programma terminato");
    }

}
