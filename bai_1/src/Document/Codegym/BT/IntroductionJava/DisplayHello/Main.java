package Document.Codegym.BT.IntroductionJava.DisplayHello;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        String inputName = new Scanner(System.in).nextLine();
        System.out.println("Hello " + inputName);
    }
}
