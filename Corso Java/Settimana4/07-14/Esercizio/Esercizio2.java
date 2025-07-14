// SISTEMA DI PAGAMENTO E-COMMERCE //
/* SIMULARE UN CHECKOUT CON METODI DI PAGAMENTO DIFFERENTI (CARTA, PAYPAL, CRYPTO) 
DESIGN PATTERN DA USARE: FACTORY METHOD (PER IL TIPO DI PAGAMENTO CORRETTO) E FACADE (NASCONDERE COMPLESSITA DEL PROCESSO)
*/

import java.util.Scanner;

// Interfaccia comune che definisce il contratto per tutti i tipi di pagamento
interface Pagamento {

    // Metodo per eseguire il pagamento
    void paga(double importo);
}

// Implementazione concreta per il pagamento in contanti
class PagamentoContanti implements Pagamento {

    // Metodo che esegue il pagamento in contanti
    @Override
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + "€ effettuato in contanti.");
    }
}

// Implementazione concreta per il pagamento con carta
class PagamentoCarta implements Pagamento {

    // Metodo che esegue il pagamento con carta
    @Override
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + "€ effettuato con Carta di Credito.");
    }
}

// Implementazione concreta per il pagamento con PayPal
class PagamentoPayPal implements Pagamento {

    // Metodo che esegue il pagamento con PayPal
    @Override
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + "€ effettuato con PayPal.");
    }
}

// Implementazione concreta per il pagamento con Bitcoin
class PagamentoBitcoin implements Pagamento {

    // Metodo che esegue il pagamento con Bitcoin
    @Override
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + "€ effettuato con Bitcoin.");
    }
}

// Classe factory per creare l'oggetto Pagamento corretto
class PagamentoFactory {

    // Restituisce l'implementazione giusta in base al tipo
    public static Pagamento creaPagamento(String tipo) {

        // Controlla il tipo di pagamento richiesto
        switch (tipo) {

            // Se contanti
            case "contanti":

                // Restituisce PagamentoContanti
                return new PagamentoContanti();

            // Se carta
            case "carta":

                // Restituisce PagamentoCarta
                return new PagamentoCarta();

            // Se PayPal
            case "paypal":

                // Restituisce PagamentoPayPal
                return new PagamentoPayPal();

            // Se Bitcoin
            case "bitcoin":

                // Restituisce PagamentoBitcoin
                return new PagamentoBitcoin();

            // Se tipo non riconosciuto
            default:

                // Restituisce null
                return null;
        }
    }
}

// Classe Facade che semplifica il processo di checkout
class CheckoutFacade {

    // Metodo per gestire l'intero processo di pagamento
    public void eseguiPagamento(String metodo, double importo) {
        System.out.println("Inizio processo di checkout...");

        // Ottiene l'oggetto Pagamento tramite la factory
        Pagamento pagamento = PagamentoFactory.creaPagamento(metodo);

        // Se il metodo di pagamento è valido
        if (pagamento != null) {

            // Esegue il pagamento
            pagamento.paga(importo);
            System.out.println("Checkout completato.\n");

        }
        // Se il metodo non è valido
        else {
            System.out.println("Errore: Metodo di pagamento non supportato.");
        }
    }
}

public class Esercizio2 {
    public static void main(String[] args) {

        // Inizializzazione degli scanner
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        // Istanzia la Facade per il checkout
        CheckoutFacade checkout = new CheckoutFacade();

        // Richiesta dell'importo all'utente
        System.out.print("Inserisci importo da pagare: ");
        double importo = scannerNum.nextDouble();

        // Richiesta del metodo di pagamento
        System.out.print("Scegli metodo di pagamento (contanti / carta / paypal / bitcoin): ");
        String metodo = scannerStr.nextLine();

        // Esegue il pagamento tramite la Facade
        checkout.eseguiPagamento(metodo, importo);

        // Chiusura Scanner
        scannerNum.close();
        scannerStr.close();
    }
}
