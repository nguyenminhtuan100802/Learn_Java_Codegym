package Document.Codegym.Array;

import java.util.Scanner;

public class ConvertTemperature {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        while (true){
            int choice = 0;
            try{
                System.out.println(ANSI_YELLOW + "========= MENU =========" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "1. Fahrenheit to Celsius" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "2. Celsius to Fahrenheit" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "3. Exit" + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "========= END =========" + ANSI_RESET);
                System.out.print("Enter your choice:");
                choice = new Scanner(System.in).nextInt();
            }
            catch (Exception e){
                System.out.println(ANSI_RED + "<!>Error input data, please enter a number" + ANSI_RESET);
            }

            if(choice == 1){
                System.out.print("Enter temperature in Fahrenheit: ");
                double fahrenheitTemp = new Scanner(System.in).nextDouble();
                System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius(fahrenheitTemp));
            }
            else if(choice == 2){
                System.out.print("Enter temperature in Celsius: ");
                double celsiusTemp = new Scanner(System.in).nextDouble();
                System.out.println("Celsius to Fahrenheit: " + celsiusToFahrenheit(celsiusTemp));
            }
            else if(choice == 3){
                break;
            }
        }
    }
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}
