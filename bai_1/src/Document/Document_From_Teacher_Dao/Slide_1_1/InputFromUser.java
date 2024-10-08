package Document.Document_From_Teacher_Dao.Slide_1_1;

import java.util.Scanner;

public class InputFromUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("NHẬP THÔNG TIN");
        System.out.print(">> Họ tên: ");
        String name = scanner.nextLine();
        System.out.print(">> Tuổi: ");
        int age = scanner.nextInt();
        System.out.print(">> Mức lương khởi điểm: ");
        double salary = scanner.nextDouble();

        System.out.println("NHẬP THÔNG TIN");
        System.out.println(">> Họ tên: " + name);
        System.out.println(">> Tuổi: " + age);
        System.out.println(">> Mức lương khởi điểm: " + salary);
        scanner.close();

    }
}
