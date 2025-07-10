import java.util.*;

// Definisce l'interfaccia per le forme geometriche
interface IShape {
    // Metodo per disegnare la forma
    void Draw();

    // Imposta la strategia di disegno
    void setDrawStrategy(DrawStrategy strategy);

    // Aggiunge un osservatore
    void attachObserver(ShapeObserver observer);

    // Notifica tutti gli osservatori
    void notifyObservers();
}

// Interfaccia per la strategia di disegno
interface DrawStrategy {
    // Metodo per eseguire il disegno
    void executeDraw(String shapeName);
}

// Implementazione concreta di una strategia di disegno semplice
class SimpleDrawStrategy implements DrawStrategy {
    public void executeDraw(String shapeName) {

        // Stampa un messaggio semplice
        System.out.println("Disegno semplice: " + shapeName);
    }
}

// Implementazione concreta di una strategia di disegno dettagliata
class DetailedDrawStrategy implements DrawStrategy {
    public void executeDraw(String shapeName) {
        // Stampa dettagli
        System.out.println("Disegno dettagliato di un " + shapeName + ": [linee, ombreggiature, proporzioni]");
    }
}

// Interfaccia per l'osservatore delle forme
interface ShapeObserver {
    // Metodo chiamato quando la forma viene disegnata
    void update(String shapeType);
}

// Implementazione concreta dell'osservatore che logga l'evento
class LoggerObserver implements ShapeObserver {
    @Override
    public void update(String shapeType) {
        // Log dell'evento
        System.out.println("[Observer] È stato disegnato un: " + shapeType);
    }
}

// Implementazione concreta della forma Cerchio
class Circle implements IShape {
    // Strategia di disegno corrente
    private DrawStrategy strategy;
    // Lista degli osservatori
    private List<ShapeObserver> observers = new ArrayList<>();

    @Override
    public void Draw() {
        // Esegue il disegno usando la strategia
        strategy.executeDraw("Cerchio");
        // Notifica gli osservatori
        notifyObservers();
    }

    @Override
    public void setDrawStrategy(DrawStrategy strategy) {
        // Imposta la strategia di disegno
        this.strategy = strategy;
    }

    @Override
    public void attachObserver(ShapeObserver observer) {
        // Aggiunge un osservatore alla lista
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (ShapeObserver o : observers) {
            // Notifica ogni osservatore
            o.update("Cerchio");
        }
    }
}

// Implementazione concreta della forma Quadrato
class Square implements IShape {
    // Strategia di disegno corrente
    private DrawStrategy strategy;
    // Lista degli osservatori
    private List<ShapeObserver> observers = new ArrayList<>();

    @Override
    public void Draw() {
        // Esegue il disegno usando la strategia
        strategy.executeDraw("Quadrato");
        // Notifica gli osservatori
        notifyObservers();
    }

    @Override
    public void setDrawStrategy(DrawStrategy strategy) {
        // Imposta la strategia di disegno
        this.strategy = strategy;
    }

    @Override
    public void attachObserver(ShapeObserver observer) {
        // Aggiunge un osservatore alla lista
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (ShapeObserver o : observers) {
            // Notifica ogni osservatore
            o.update("Quadrato");
        }
    }
}

// Classe astratta per il Factory Method
abstract class ShapeCreator {
    // Metodo astratto per creare una forma
    public abstract IShape CreateShape(String type);
}

// Factory per creare cerchi
class CircleCreator extends ShapeCreator {
    @Override
    public IShape CreateShape(String type) {
        // Se il tipo è "circle", crea un Cerchio
        if ("circle".equalsIgnoreCase(type))
            return new Circle();
        // Altrimenti restituisce null
        return null;
    }
}

// Factory per creare quadrati
class SquareCreator extends ShapeCreator {
    @Override
    public IShape CreateShape(String type) {
        // Se il tipo è "square", crea un Quadrato
        if ("square".equalsIgnoreCase(type))
            return new Square();
        // Altrimenti restituisce null
        return null;
    }
}

// Classe principale che contiene il main
public class EsercizioCompletoPattern {
    public static void main(String[] args) {
        // Crea uno scanner per l'input da tastiera
        Scanner scanner = new Scanner(System.in);

        // Chiede all'utente la forma
        System.out.print("Quale forma vuoi disegnare? (circle / square): ");
        String forma = scanner.nextLine();

        // Chiede all'utente la strategia
        System.out.print("Vuoi un disegno semplice o dettagliato? (simple / detailed): ");
        String style = scanner.nextLine();
        // Sceglie la strategia
        DrawStrategy strategy = "detailed".equals(style) ? new DetailedDrawStrategy() : new SimpleDrawStrategy();

        // Factory metodo
        ShapeCreator creator;
        switch (forma.toLowerCase()) {
            case "circle":
                creator = new CircleCreator();
                break;
            case "square":
                creator = new SquareCreator();
                break;
            default:
                creator = null;
                break;
        }

        // Se la forma non è valida, stampa errore
        if (creator == null) {
            System.out.println("Forma non riconosciuta.");
            // Termina il programma
            return;
        }

        // Crea la forma tramite la factory
        IShape shape = creator.CreateShape(forma);

        if (shape != null) {
            // Imposta la strategia di disegno
            shape.setDrawStrategy(strategy);
            // Aggiunge un osservatore
            shape.attachObserver(new LoggerObserver());

            // Disegna la forma
            shape.Draw();

        } else {
            // Errore nella creazione
            System.out.println("Errore nella creazione della forma.");
        }

        // Chiude lo scanner
        scanner.close();
    }
}
