package Codegym.Loop;

import java.util.Scanner;

public class MenuDrawShape {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("==============" + ANSI_YELLOW + " MENU " + ANSI_RESET + "==============");
            System.out.println("1. Draw a triangle");
            System.out.println("2. Draw a square");
            System.out.println("3. Draw a rectangle");
            System.out.println("4. Quit program");
            System.out.println("==============" + ANSI_YELLOW + " END " + ANSI_RESET + "==============");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("******");
                System.out.println("*****");
                System.out.println("****");
                System.out.println("***");
                System.out.println("**");
                System.out.println("*");
            }
            else if (choice == 2) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
            else if (choice == 3) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 20; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
            else if (choice == 4) {
                break;
            }
        }
    }
}
