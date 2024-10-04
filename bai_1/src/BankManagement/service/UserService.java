package BankManagement.service;

import BankManagement.entity.User;
import BankManagement.management.UserManagement;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class UserService {
    public static User verifyLogin() {
        System.out.print("Enter your username:");
        String username = (new Scanner(System.in)).nextLine();
        System.out.print("Enter your password:");
        String password = (new Scanner(System.in)).nextLine();

        for (int i = 0; i < UserManagement.getUserArrayList().size(); i++) {
            if (UserManagement.getUserArrayList().get(i).getUsername().equals(username) && UserManagement.getUserArrayList().get(i).getPassword().equals(password)) {
                System.out.println(TextColor.BLUE + "Xin chào " + UserManagement.getUserArrayList().get(i).getFullName() + TextColor.END_COLOR);
                return UserManagement.getUserArrayList().get(i);
            }
        }
        System.out.println(TextColor.RED + "<!> Tên đăng nhập hoặc mật khẩu không đúng!" + TextColor.END_COLOR);
        return null;
    }
}
