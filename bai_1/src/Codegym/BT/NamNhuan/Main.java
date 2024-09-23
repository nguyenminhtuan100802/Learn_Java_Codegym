package Codegym.BT.NamNhuan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a year to check:");
        int inputYear = new Scanner(System.in).nextInt();

        if ((inputYear % 4 == 0 && inputYear % 100 != 0) || (inputYear % 400 == 0 && inputYear % 100 == 0)){
            System.out.println(inputYear + " is a leap year");
        }
        else {
            System.out.println(inputYear + " is not a leap year");
        }
    }
}
