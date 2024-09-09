package Youtube.TITV.OOP.OOP_Interface;

public class CalculatorFX500 implements Calculator {

    @Override
    public double plus(double a, double b) {
        return a + b;
    }

    @Override
    public double minus(double a, double b) {
        return a - b;
    }

    @Override
    public double multiple(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b != 0) return a / b;
        return 0;
    }
}
