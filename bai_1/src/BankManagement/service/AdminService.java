package BankManagement.service;

import BankManagement.entity.Admin;
import BankManagement.constant.TextColor;

import java.util.Scanner;

public class AdminService {
    private static final Admin admin = new Admin();

    public static boolean verifyLogin() {
        System.out.print("Nhập tên đăng nhập:");
        String username = new Scanner(System.in).nextLine();
        System.out.print("Nhập mật khẩu:");
        String password = new Scanner(System.in).nextLine();
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println(TextColor.BLUE + "Đăng nhập quản trị viên thành công" + TextColor.END_COLOR);
            return true;
        } else {
            System.out.println(TextColor.RED + "<!> Sai tên đăng nhập hoặc mật khẩu" + TextColor.END_COLOR);
            return false;
        }
    }
}
