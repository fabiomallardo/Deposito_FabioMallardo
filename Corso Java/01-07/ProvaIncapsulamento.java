class Person {

    private String name; // Attributo privato
    private int età;

    // Costruttore corretto
    public Person(String nome, int eta) {
        this.name = nome;
        this.età = eta;
    }

    // Metodo privato per verificare se è maggiorenne
    private boolean verificaMaggiorenne() {
        return this.età >= 18;
    }

    // Metodo pubblico che usa il metodo privato
    public void stampaStatus() {
        if (verificaMaggiorenne()) {
            System.out.println(this.name + " è maggiorenne.");
        } else {
            System.out.println(this.name + " non è maggiorenne.");
        }
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }
}

public class ProvaIncapsulamento {

    public static void main(String[] args) {

        // Creo l'oggetto con nome e età
        Person myObj = new Person("Pippo", 20);

        // Uso getter e setter
        System.out.println("Nome attuale: " + myObj.getName());

        myObj.setName("Giovanni");

        System.out.println("Nuovo nome: " + myObj.getName());

        // Verifico lo status (maggiorenne o no)
        myObj.stampaStatus();
    }
}
