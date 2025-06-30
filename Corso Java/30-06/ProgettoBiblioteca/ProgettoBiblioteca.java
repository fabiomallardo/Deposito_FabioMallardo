import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Creazione classe Book
class Book {

    // Titolo libro
    String title;

    // Nome autore
    String author;

    // Disponibilità o meno del libro
    boolean isAvailable;

    // Metodo che mostra le informazioni del libro
    void displayBookInfo() {
        System.out.println("Titolo      : " + title);
        System.out.println("Autore      : " + author);
        System.out.println("Stato       : " + (isAvailable
                ? "Disponibile"
                : "Non disponibile"));
    }

    // Costruttore
    Book(String title, String author, boolean isAvailabe) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailabe;
    }
}

// Creazione classe Library
class Library {
    List<Book> books = new ArrayList<>();

    // Metodo per aggiungere libri alla biblioteca
    void addBook(Book book) {
        books.add(book);
        System.out.println("Libro aggiunto con successo " + book.title + " dell'autore " + book.author);
    }

    // Metodo per mostrare tutti i libri presenti nella biblioteca
    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("La biblioteca è vuota ");
            return;
        } else {
            System.out.println(" Elenco libri in biblioteca ");
            for (Book b : books) {
                b.displayBookInfo();
            }
        }
    }

    // Metodo per permettere di prendere in prestito un libro (solo se è
    // disponibile)
    void borrowBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (b.isAvailable) {
                    b.isAvailable = false;
                    System.out.println("Prestito effettuato: " + b.title);
                } else {
                    System.out.println("Il libro " + b.title + " non è disponibile");
                }
                return;
            }
        }
        System.out.println(" Libro " + title + " non trovato in biblioteca");
    }

    // Metodo per permettere agli utenti di restituire un libro e segnarlo come
    // duisponibile
    void returnBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.isAvailable) {
                    b.isAvailable = true;
                    System.out.println(" Restituzione avvenuta: " + b.title);
                } else {
                    System.out.println(" Il libro " + b.title + " non risulta prestato.");
                }
                return;
            }
        }
        System.out.println(" Libro " + title + " non trovato in biblioteca");
    }

    //Metodo per ricercare un libro agli utenti tramite nome libro o autore
    void searchBook(String keyword) {
        String key = keyword.toLowerCase();
        List<Book> results = new ArrayList<>();
        for (Book b : books) {
            if (b.title.toLowerCase().contains(key) ||
                b.author.toLowerCase().contains(key)) {
                results.add(b);
            }
        }

        if (results.isEmpty()) {
            System.out.println(" Nessun libro trovato per: " + keyword);
        } else {
            System.out.println(" Risultati ricerca per: " + keyword);
            for (Book b : results) {
                b.displayBookInfo();
            }
        }
    }

    //Creazione classe User
    class User {
        // Limite massimo dei prestiti 3
        static int maxLimit = 3;

        // Nome
        String nome;

        // ArrayList per memorizzare i libri presi in prestito
        List <Book> borrowedBooks = new ArrayList<>();

        //Costruttore 
        User(String nome){
            this.nome = nome;
        }

        // Controllo se l'utente ha già superato il numero massimo limite dei prestiti
        boolean canBorrow(){
            return borrowedBooks.size() < maxLimit;
        }

        // Aggiungo il libro alla lista dei prestiti dell'utente
        void borrow(Book book){
            borrowedBooks.add(book);
        }

        // Rimuovo il libro dalla lista dei prestiti
        void returns(Book book) {
            borrowedBooks.remove(book);
        }

        // Metodo per visualizzare lo stato corrente dei prestti del ll'utente
        void displayLoans() {
    if (borrowedBooks.isEmpty()) {
        System.out.println(nome + " non ha libri in prestito");
    } else {
        System.out.println(" Libri in prestito di " + nome);
        for (Book b : borrowedBooks) {
            b.displayBookInfo();
        }
    }
}
    }

}

public class ProgettoBiblioteca {
    public static void main(String[] args) {

        // Inizializzazione dello Scanner
        Scanner scanner = new Scanner(System.in);

        // Creazione della libreria
        Library library = new Library();

        // Variabile di inizio ciclo
        boolean exit = false;
        while (!exit) {
            System.out.println(" Menu Biblioteca ");
            System.out.println("1) Aggiungi un libro");
            System.out.println("2) Mostra tutti i libri");
            System.out.println("3) Prendi in prestito un libro");
            System.out.println("4) Restituisci un libro");
            System.out.println("5) Ricerca un libro");
            System.out.println("6) Esci");
            System.out.print("Scegli un'opzione (1-6): ");

            String verifica = scanner.nextLine();
            switch (verifica) {
                case "1":
                    // Aggiungo un libro
                    System.out.print("Titolo: ");
                    String title = scanner.nextLine();
                    while (title.isEmpty()) {
                        System.out.print("Titolo non valido. Riprova: ");
                        title = scanner.nextLine();
                    }

                    System.out.print("Autore: ");
                    String author = scanner.nextLine().trim();
                    while (author.isEmpty()) {
                        System.out.print("Autore non valido. Riprova: ");
                        author = scanner.nextLine();
                    }

                    System.out.print("Disponibile? (true/false): ");
                    while (!scanner.hasNextBoolean()) {
                        System.out.print("Inserisci 'true' o 'false': ");
                    }
                    boolean isAvailable = scanner.nextBoolean();
                    

                    library.addBook(new Book(title, author, isAvailable));
                    break;

                case "2":
                    // Mostro tutti i libri
                    library.displayBooks();
                    break;

                case "3":
                    // Prendi in prestito un libro
                    System.out.print("Titolo da prendere in prestito: ");
                    String toBorrow = scanner.nextLine();
                    while (toBorrow.isEmpty()) {
                        System.out.print("Titolo non valido. Riprova: ");
                        toBorrow = scanner.nextLine();
                    }
                    library.borrowBook(toBorrow);
                    break;

                case "4":
                    // Restituzione
                    System.out.print("Titolo da restituire: ");
                    String toReturn = scanner.nextLine();
                    while (toReturn.isEmpty()) {
                        System.out.print("Titolo non valido. Riprova: ");
                        toReturn = scanner.nextLine();
                    }
                    library.returnBook(toReturn);
                    break;
                
                 case "5":
                    // Ricerca un libro
                    System.out.print("Inserisci parola chiave (titolo/autore): ");
                    String keyword = scanner.nextLine();
                    while (keyword.isEmpty()) {
                        System.out.print("Parola chiave non valida. Riprova: ");
                        keyword = scanner.nextLine();
                    }
                    library.searchBook(keyword);
                    break;

                case "6":
                    // Esci
                    exit = true;
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.\n");
            }
        }

        // Chiusura Scanner
        scanner.close();

    }
}
