package Document.Codegym.JavaBasic;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = 3.5;

        System.out.println("Enter month you want to check: ");
        int month = input.nextInt();

        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12){
            System.out.println("The month " + month + " has 31 days");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println("The month " + month + " has 30 days");
        } else if (month == 2) {
            System.out.println("The month " + month + " has 28 or 29 days");
        }
    }
}
