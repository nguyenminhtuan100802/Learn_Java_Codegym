package Document.Codegym.BT.Debug;

import java.util.Scanner;

public class Debug {
    public static void main(String[] args) {
        System.out.print("Enter a number:");
        int inputNumber = new Scanner(System.in).nextInt();
        System.out.println("input: " + inputNumber);


        if (inputNumber < 0) {
            System.out.println("Negative number");
        }
        else if (inputNumber > 0) {
            System.out.println("Positive number");
        }
        else {
            System.out.println("Zero number");
        }
    }
}
