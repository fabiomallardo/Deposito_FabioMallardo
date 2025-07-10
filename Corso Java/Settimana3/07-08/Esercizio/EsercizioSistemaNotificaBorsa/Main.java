package EsercizioSistemaNotificaBorsa;

public class Main {
    public static void main(String[] args) {

        // Istanza agenziaBorsa, l'unica
        AgenziaBorsa agenziaBorsa = AgenziaBorsa.getIstanza();

        // Creo l'oggetto investigatori
        Investitore privato = new InvestitorePrivato();
        Investitore bancario = new InvestitoreBancario();

        // Aggiungo alla lista
        agenziaBorsa.aggiungiInvestitore(privato);
        agenziaBorsa.aggiungiInvestitore(bancario);

        // Do in input delle azioni
        agenziaBorsa.notificaInvestitori("AZIONE1", 10.67);
        agenziaBorsa.notificaInvestitori("AZIONE2", 1234.90);
    }
}
