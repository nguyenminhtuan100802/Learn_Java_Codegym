package Codegym.BT.ReadNumber;

import java.util.Scanner;

public class Main {
    private static final String[] underTwenty = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
    private static final String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    public static String numberToWords(int number) {
        if (number < 20) {
            return underTwenty[number];
        } else if (number < 100) {
            return tens[number / 10] + (number % 10 != 0 ? " " + underTwenty[number % 10] : "");
        } else {
            return underTwenty[number / 100] + " hundred" +
                    (number % 100 != 0 ? " and " + numberToWords(number % 100) : "");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (0 - 999): ");
        int number = scanner.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("Please enter a number between 0 and 999.");
        } else {
            System.out.println(numberToWords(number));
        }

        scanner.close();
    }
}
