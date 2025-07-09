package EsercizioStrategy;

// Interfaccia operazione
interface Operazione {

    //Metodo
    public int esegui(int a, int b);
}

// Strategia concreta: Addizione
class Addizione implements Operazione{
    public int esegui(int a, int b){
        return a + b;
    }
}


// Strategia concreta : Moltiplicazione
class Moltiplicazione implements Operazione{
    public int esegui(int a, int b){
        return a * b;
    }
}

// Context
class Calcolatore{
    private Operazione operazione;

    public void setCalcolatore(Operazione operazione){
        this.operazione = operazione;
    }

    public int calcola(int a, int b){
        return operazione.esegui(a,b);
    }
}