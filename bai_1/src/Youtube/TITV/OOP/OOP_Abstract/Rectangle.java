package Youtube.TITV.OOP.OOP_Abstract;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calArea() {
        return this.width * this.height;
    }
}
