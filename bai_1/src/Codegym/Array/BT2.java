package Codegym.Array;

import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.print("Enter n: ");
        int n = new Scanner(System.in).nextInt();
        int[][] numbers = new int[n][n];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print("Enter number : ");
                numbers[i][j] = new Scanner(System.in).nextInt();
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i][i];
        }
        System.out.println("Sum" + sum);
    }
}
