import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Observer {
    void update(String message);
}

// Interfaccia Subject
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// ConcreteSubject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state){
        this.state = state;
        notifyObservers();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for (Observer o : observers){
            o.update(state);
        }
    }
}
    
    // ConcreteObserver
    class ConcreteObserver implements Observer {
        private String nome;

        public ConcreteObserver(String nome){
            this.nome = nome;
        }

        public void update(String message){
            System.out.println(nome + " ha ricevuto aggiornamento: " + message);
        }
    }