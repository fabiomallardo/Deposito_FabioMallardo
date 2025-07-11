// Importa la classe Scanner per input da tastiera
import java.util.Scanner;

// Classe base utente che rappresenta un utente con id e nome
class User {
    // Identificativo utente
    String id;
    // Nome utente
    String name;

    // Costruttore che inizializza id e nome
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Classe che rappresenta il sistema legacy per la gestione utenti
class LegacyUserSystem {
    // Array di utenti con dimensione massima 100
    private User[] users = new User[100];
    // Contatore utenti attualmente presenti
    private int count = 0;

    // Metodo per aggiungere un utente al sistema legacy
    public void addUser(String uid, String uname) {
        users[count++] = new User(uid, uname);
    }

    // Metodo per rimuovere un utente dal sistema legacy tramite id
    public void removeUser(String uid) {
        for (int i = 0; i < count; i++) {
            if (users[i] != null && users[i].id.equals(uid)) {
                users[i] = null;
            }
        }
    }

    // Metodo che restituisce tutti gli utenti (array)
    public User[] getAllUsers() {
        return users;
    }

    // Metodo per cercare un utente tramite id
    public User searchUser(String uid) {
        for (User u : users) {
            if (u != null && u.id.equals(uid)) return u;
        }
        return null;
    }
}

// Interfaccia moderna per la gestione utenti
interface UserManagement {
    // Metodo per creare un utente
    void createUser(String id, String name);
    // Metodo per eliminare un utente
    void deleteUser(String id);
    // Metodo per trovare un utente tramite chiave
    User findUser(String key);
}

// Classe Adapter che adatta il sistema legacy all'interfaccia moderna
class UserManagementAdapter implements UserManagement {
    // Riferimento al sistema legacy
    private LegacyUserSystem legacy;

    // Costruttore che riceve il sistema legacy
    public UserManagementAdapter(LegacyUserSystem legacy) {
        this.legacy = legacy;
    }

    // Implementazione del metodo per creare utente
    public void createUser(String id, String name) {
        legacy.addUser(id, name);
    }

    // Implementazione del metodo per eliminare utente
    public void deleteUser(String id) {
        legacy.removeUser(id);
    }

    // Implementazione del metodo per trovare utente tramite chiave
    public User findUser(String key) {
        return legacy.searchUser(key);
    }

    // Metodo per ottenere tutti gli utenti dal sistema legacy
    public User[] getAllUsers() {
        return legacy.getAllUsers();
    }
}

// Interfaccia Strategy per la ricerca utenti
interface UserSearchStrategy {
    // Metodo per cercare un utente nell'array tramite chiave
    User search(User[] users, String key);
}

// Strategia di ricerca utente tramite id
class SearchByIdStrategy implements UserSearchStrategy {

    // Implementazione della ricerca per id
    public User search(User[] users, String key) {
        for (User u : users) {
            if (u != null && u.id.equals(key)) return u;
        }
        return null;
    }
}

// Strategia di ricerca utente tramite nome
class SearchByNameStrategy implements UserSearchStrategy {
    // Implementazione della ricerca per nome (case insensitive)
    public User search(User[] users, String key) {
        for (User u : users) {
            if (u != null && u.name.equalsIgnoreCase(key)) return u;
        }
        return null;
    }
}

// Classe Facade che semplifica l'interazione con il sistema utenti
class UserFacade {
    // Adapter per la gestione utenti
    private UserManagementAdapter adapter;
    // Strategia di ricerca corrente
    private UserSearchStrategy strategy;

    // Costruttore che riceve l'adapter e imposta la strategia di default (per id)
    public UserFacade(UserManagementAdapter adapter) {
        this.adapter = adapter;
        this.strategy = new SearchByIdStrategy();
    }

    // Metodo per cambiare la strategia di ricerca
    public void setSearchStrategy(UserSearchStrategy strategy) {
        this.strategy = strategy;
    }

    // Metodo per registrare un nuovo utente
    public void registerUser(String id, String name) {
        adapter.createUser(id, name);
    }

    // Metodo per rimuovere un utente
    public void removeUser(String id) {
        adapter.deleteUser(id);
    }

    // Metodo per trovare un utente tramite chiave usando la strategia corrente
    public User findUser(String key) {
        return strategy.search(adapter.getAllUsers(), key);
    }
}

public class EsercizioMedioAdapter {
    public static void main(String[] args) {
        
        // Inizializzo i due Scanner
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        
        // Crea il sistema legacy
        LegacyUserSystem legacy = new LegacyUserSystem();
        
        // Crea l'adapter per il sistema legacy
        UserManagementAdapter adapter = new UserManagementAdapter(legacy);
        
        // Crea la facade per la gestione utenti
        UserFacade facade = new UserFacade(adapter);

        // Ciclo infinito per gestire il menu utente
        while (true) {
            // Stampa il menu delle opzioni
            System.out.println("1. Aggiungi utente");
            System.out.println("2. Rimuovi utente");
            System.out.println("3. Cerca utente");
            System.out.println("4. Cambia strategia di ricerca");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");

            int scelta = scannerNum.nextInt();

            // Gestisce la scelta tramite switch
            switch (scelta) {
                
                // Caso aggiunta utente
                case 1:
                    System.out.print("ID utente: ");
                    String id = scannerStr.nextLine();
                    System.out.print("Nome utente: ");
                    String name = scannerStr.nextLine();
                    facade.registerUser(id, name);
                    break;
                
                    // Caso rimozione utente
                case 2:
                    System.out.print("ID da rimuovere: ");
                    String rid = scannerStr.nextLine();
                    facade.removeUser(rid);
                    break;
               
                    // Caso ricerca utente
                case 3:
                    System.out.print("Inaserisci id utente: ");
                    String chiave = scannerStr.nextLine();
                    User trovato = facade.findUser(chiave);
                    if (trovato != null)
                        System.out.println("Trovato: " + trovato.id + " - " + trovato.name);
                    else
                        System.out.println("Utente non trovato.");
                    break;
                
                    // Caso cambio strategia di ricerca
                case 4:
                    System.out.println("1. Per ID");
                    System.out.println("2. Per Nome");
                    int tipo = scannerNum.nextInt();
                    
                    if (tipo == 1)
                        facade.setSearchStrategy(new SearchByIdStrategy());
                    else
                        facade.setSearchStrategy(new SearchByNameStrategy());
                    break;
               
                    // Caso uscita dal programma
                case 5:
                    System.out.println("Uscita...");
                    scannerNum.close();
                    scannerStr.close();
                    return;
            }
        }
    }
}
