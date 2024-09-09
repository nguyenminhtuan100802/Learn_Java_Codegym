package Document_From_Teacher_Dao.Slide_1_3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DecimalFormatPractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter math score: ");
        double mathScore = input.nextDouble();
        System.out.print("Enter physic score: ");
        double physicScore = input.nextDouble();
        System.out.print("Enter chemistry score: ");
        double chemistryScore = input.nextDouble();

        double average = (mathScore + physicScore + chemistryScore) / 3;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("The average score is: " + decimalFormat.format(average));
    }
}
