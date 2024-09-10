package Codegym.Loop;

import java.util.Scanner;

public class BT {
    public static void main(String[] args) {
        int sum = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = input.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = input.nextInt();

        for (int i = num1; i <= num2; i++) {
            sum = sum + i;
            if (kiemTraSoChinhPhuong(i)){
                System.out.println("Số chính phương: " + i);
            }
        }
        System.out.println("Sum: " + sum);

    }
    public static boolean kiemTraSoChinhPhuong(double x)
    {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }

}
