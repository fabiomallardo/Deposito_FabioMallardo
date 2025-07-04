class Vehicle {

    protected String brand = "Ford";

    public void honk() {

        System.out.println("Tuut, tuut!");
    }
}

class Car extends Vehicle {

    private String modelName = "Fiat";

    public String getModelName() {
        return modelName;
    }
}

public class ProvaEreditarietà {
    public static void main(String[] args) {

        Car myCar = new Car();

        myCar.honk();

        System.out.println(myCar.brand + " " + myCar.getModelName());
    }
}