// Sottoclasse
class SubsytemA{
    void operationA(){
        System.out.println("Operazione A del sottosistema A");
    }
}

class SubsytemB{
    void operationB(){
        System.out.println("Operazione B del sottosistema B");
    }
}

// Facade
class Facade {
    private SubsytemA a = new SubsytemA(); 
    private SubsytemB b = new SubsytemB();

    public void operazioneUnificata(){
        a.operationA();
        b.operationB();
    }
}


public class ProvaFacade {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operazioneUnificata();
    }
}
