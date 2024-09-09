package Youtube.TITV.OOP.OOP_Abstract;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape2 = new Rectangle(5.5, 6.5);

        System.out.println("Area shape1: " + shape1.calArea());
        System.out.println("Area shape2: " + shape2.calArea());

    }
}
