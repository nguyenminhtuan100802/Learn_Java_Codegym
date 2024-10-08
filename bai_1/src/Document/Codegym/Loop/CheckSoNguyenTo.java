package Document.Codegym.Loop;

import java.util.Scanner;

public class CheckSoNguyenTo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();

        if (number > 1) {
            boolean flagIsPrime = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flagIsPrime = false;
                }
            }
            if (flagIsPrime) {
                System.out.println(number + " is a prime number");
            }
            else {
                System.out.println(number + " is not a prime number");
            }
        }
    }
}
