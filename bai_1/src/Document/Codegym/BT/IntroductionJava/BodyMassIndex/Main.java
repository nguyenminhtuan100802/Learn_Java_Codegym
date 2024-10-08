package Document.Codegym.BT.IntroductionJava.BodyMassIndex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter bmi: ");
        int bmi = new Scanner(System.in).nextInt();

        if (bmi < 18.5) {
            System.out.println("Underweight");
        }
        else if (bmi < 25.0) {
            System.out.println("Normal");
        }
        else if (bmi < 30.0){
            System.out.println("Overweight");
        }
        else {
            System.out.println("Obese");
        }
    }
}
