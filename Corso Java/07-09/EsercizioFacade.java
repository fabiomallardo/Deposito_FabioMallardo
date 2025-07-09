// Sottoclasse LuceCamera
class LuceCamera{
    void accendi(){
        System.out.println("Luce camera accesa");
    }
}

class LuceCucina{
    void accendi(){
        System.out.println("Luce cucina accesa");
    }
}

// Facade
class GestioneLuciFacade{
    private LuceCamera camera = new LuceCamera();
    private LuceCucina cucina = new LuceCucina();
    
    void accendiTutte(){
        camera.accendi();
        cucina.accendi();
    }
}


public class EsercizioFacade {
public static void main(String[] args) {

    GestioneLuciFacade luci = new GestioneLuciFacade();

    luci.accendiTutte();
    
}    
}
