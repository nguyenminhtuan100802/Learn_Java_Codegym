package Document.TITV.OOP_Practice.Java45;

public abstract class Transportation {
    protected String typeOfTransportation;
    protected Manufacturer manufacturer;

    public Transportation(String typeOfTransportation, Manufacturer manufacturer) {
        this.typeOfTransportation = typeOfTransportation;
        this.manufacturer = manufacturer;
    }

    public String getTypeOfTransportation() {
        return typeOfTransportation;
    }
    public void setTypeOfTransportation(String typeOfTransportation) {
        this.typeOfTransportation = typeOfTransportation;
    }
    public String getManufacturerName() {
        return this.manufacturer.getName();
    }

    public void startTransportation() {
        System.out.println("Starting transportation");
    }
    public void endTransportation() {
        System.out.println("Ending transportation");
    }
//    abstract method
    public abstract double getVelocity();
}
