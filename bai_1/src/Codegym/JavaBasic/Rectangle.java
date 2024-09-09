package Codegym.JavaBasic;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        double width;
        double height;
        double area;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the width of the rectangle: ");
        width = input.nextDouble();
        System.out.println("Enter the height of the rectangle: ");
        height = input.nextDouble();

        area = width * height;
        System.out.println("The area of the rectangle is " + area);
    }
}
