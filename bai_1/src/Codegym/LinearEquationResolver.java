package Codegym;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        double a, b, c, result;
        Scanner input = new Scanner(System.in);
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");

        System.out.print("a: ");
        a = input.nextDouble();

        System.out.print("b: ");
        b = input.nextDouble();

        System.out.print("c: ");
        c = input.nextDouble();

        if (a != 0){
            result = (c - b) / a;
            System.out.println("PT 1 nghiệm: " + result);
        }
        else {
            if (b == c){
                System.out.println("PT vô số nghiệm");
            }
            else {
                System.out.println("PT vô nghiệm");
            }
        }
    }
}
