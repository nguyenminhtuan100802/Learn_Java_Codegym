package Youtube.TITV.OOP.OOP_Interface;

public class Main {
    public static void main(String[] args) {
        CalculatorFX500 calculatorFX500 = new CalculatorFX500();
        System.out.println(calculatorFX500.plus(5, 7));
        System.out.println(calculatorFX500.minus(5, 7));
        System.out.println(calculatorFX500.multiple(5, 7));
        System.out.println(calculatorFX500.divide(5, 7));
        System.out.println(calculatorFX500.divide(5, 0));

        CalculatorApp calculatorApp = new CalculatorApp();
        System.out.println(calculatorApp.plus(5, 7));
        System.out.println(calculatorApp.minus(5, 7));
        System.out.println(calculatorApp.multiple(5, 7));
        System.out.println(calculatorApp.divide(5, 7));
        System.out.println(calculatorApp.divide(5, 0));
        calculatorApp.sortIncrease(new double[]{5, 4.2, 3.1, 9.1, 7.4, 1.3, 1.2});
        calculatorApp.sortDecrease(new double[]{5, 4.2, 3.1, 9.1, 7.4, 1.3, 1.2});
    }
}
