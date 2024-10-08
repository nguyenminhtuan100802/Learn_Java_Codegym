package Document.TITV.OOP_Practice.Java45;

public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("vinfast", "vn");

        Transportation transportation1 = new Plane("plane", manufacturer1, "gas");
        Transportation transportation2 = new Car("car", manufacturer1, "oil");

        System.out.println(transportation1.getManufacturerName());
        transportation1.startTransportation();
        System.out.println(transportation1.getVelocity());
        System.out.println(transportation2.getVelocity());
    }
}
