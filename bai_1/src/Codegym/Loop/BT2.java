package Codegym.Loop;

import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double interestPercent = 6;
        System.out.println("Enter amount of money: ");
        double n = input.nextDouble();
        System.out.println("Enter amount of years: ");
        double m = input.nextDouble();

        for (int i = 0; i < m * 12; i++) {
            n = n + n * (interestPercent / 12) / 100;
        }
        System.out.println("Total money: " + n);

    }
}
