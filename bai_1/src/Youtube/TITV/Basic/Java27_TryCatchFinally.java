package Youtube.TITV.Basic;

import java.util.Scanner;

public class Java27_TryCatchFinally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
//      chỗ nào tiềm ẩn lỗi thì try catch hết
        try {
            System.out.println("Enter a number: ");
             number = scanner.nextInt();
        }catch (Exception e) {
            System.out.println("Error data");
        }finally {
            System.out.println("Finally");
        }

        System.out.println("number = " + number);
        System.out.println("Program finished");
    }
}
