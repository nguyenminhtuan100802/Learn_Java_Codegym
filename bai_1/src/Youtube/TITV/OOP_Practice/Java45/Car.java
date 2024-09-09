package Youtube.TITV.OOP_Practice.Java45;

public class Car extends Transportation{
    private String typeOfFuel;
    public Car(String typeOfTransportation, Manufacturer manufacturer, String typeOfFuel) {
        super(typeOfTransportation, manufacturer);
        this.typeOfFuel = typeOfFuel;
    }

    @Override
    public double getVelocity() {
        return 60;
    }
}
