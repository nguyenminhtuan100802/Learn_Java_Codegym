package Document.Document_From_Teacher_Dao.Slide_1_2;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive number:");
        double number = scanner.nextDouble();

        if (number >= 0) {
            double result = Math.sqrt(number);
            System.out.println("Sqrt of your number is: " + result);
        }
    }
}
