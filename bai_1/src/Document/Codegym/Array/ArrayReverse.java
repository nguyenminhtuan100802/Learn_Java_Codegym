package Document.Codegym.Array;

import java.util.Scanner;

public class ArrayReverse {
    public static void main(String[] args) {
        int amountOfElements;
        do {
            System.out.print("Enter the size of the array: ");
             amountOfElements = new Scanner(System.in).nextInt();
        } while (amountOfElements < 1 || amountOfElements > 21);
        double[] arrayNumber = new double[amountOfElements];

        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print("Enter value for element " + (i) + ": ");
            arrayNumber[i] = (new Scanner(System.in)).nextDouble();
        }

        double[] arrayReverseNumber = new double[amountOfElements];
        for (int i = 0, j = arrayNumber.length - 1; i < arrayReverseNumber.length; i++, j--) {
            arrayReverseNumber[i] = arrayNumber[j];
        }

        System.out.print(">>Array: ");
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print(arrayNumber[i] + " " + " ");
        }
        System.out.println();
        System.out.print(">>Array: ");
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print(arrayReverseNumber[i] + " " + " ");
        }
    }
}
