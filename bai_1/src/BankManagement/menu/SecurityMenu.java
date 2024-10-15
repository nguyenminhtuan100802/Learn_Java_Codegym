package BankManagement.menu;

import BankManagement.entity.User;
import BankManagement.management.UserManagement;
import BankManagement.service.MenuService;
import BankManagement.utility.Choice;
import BankManagement.constant.UserSecurityChoice;
import BankManagement.constant.TextColor;


import java.util.Scanner;

public class SecurityMenu {
    public static void displayMenu(User user) {
        boolean isExit = false;
        while (!isExit) {
            MenuService.refreshMenu();
            System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP > TRANG CHỦ (Người dùng) > BẢO MẬT (Người dùng)" + TextColor.END_COLOR + "=================");
            System.out.println("1. Thiết lập PIN cho tài khoản");
            System.out.println("2. Đổi PIN cho tài khoản");
            System.out.println("3. Đổi mật khẩu cho tài khoản");
            System.out.println("0. Trở về trang chủ");
            System.out.print("Nhập lựa chọn của bạn:");
            Choice.security = new Scanner(System.in).nextLine();
            switch (Choice.security) {
                case UserSecurityChoice.SET_UP_PIN_ACCOUNT:
                    UserManagement.setUpPinForAccount(user);
                    break;
                case UserSecurityChoice.CHANGE_PIN_ACCOUNT:
                    UserManagement.changePinForAccount(user);
                    break;
                case UserSecurityChoice.CHANGE_PASSWORD:
                    UserManagement.changePasswordForAccount(user);
                    break;
                case UserSecurityChoice.RETURN_HOME:
                    isExit = true;
                    break;
                default:
                    System.out.println(TextColor.RED + "<!> Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
            }
        }
    }
}
