public class ProvaConversione {
    public static void main(String[] args) {
        
        int myInt = 9;
        double myDouble = myInt;
        //casting automatico : int to double

        double myDouble2 = 9.78d;
        int myInt2 = (int) myDouble2;
        // casting manuale: double to int

        System.out.println(myInt); //Outputs 9
        System.out.println(myDouble); //Outputs 9.0
        System.out.println(myInt2); //Outputs 9
        System.out.println(myDouble2); //Outputs 9.78

    }
}
