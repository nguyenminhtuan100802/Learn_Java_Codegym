package Youtube.TITV.Basic;

import java.util.Scanner;

public class Java09_Scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Your Age: ");
        long age = scanner.nextLong();
        System.out.println("Enter Your Score: ");
        float score = scanner.nextFloat();

        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("score: " + score);
    }
}
