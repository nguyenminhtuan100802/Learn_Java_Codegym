package Youtube.TITV.OOP_Practice.Java45;

public class Plane extends Transportation{
    private String typeOfFuel;

    public Plane(String typeOfTransportation, Manufacturer manufacturer, String typeOfFuel) {
        super(typeOfTransportation, manufacturer);
        this.typeOfFuel = typeOfFuel;
    }

    @Override
    public double getVelocity() {
        return 500;
    }
}
