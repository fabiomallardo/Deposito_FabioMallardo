package Progetto;

public class Controller {

    public static void checkPositive(int number) throws NumeroNegativoException {
        if (number < 0) {
            throw new NumeroNegativoException("Errore: numero negativo inserito (" + number + ")", null);
        }
    }

    public static void checkNotZero(int number) {
        if (number == 0) {
            throw new NumeroZeroException("Errore: il numero non può essere zero", null);
        }
    }
}
