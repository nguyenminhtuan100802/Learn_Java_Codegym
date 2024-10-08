package Document.Codegym.Array;

import java.util.Scanner;

public class FindStudent {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Enter student's name you want to find:");
        String inputName = new Scanner(System.in).nextLine();

        boolean found = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(inputName)) {
                found = true;
                System.out.println("Found " + students[i] + " at position " + i);
                break;
            }
        }
        if (!found) System.out.println("Not found student");
    }
}
