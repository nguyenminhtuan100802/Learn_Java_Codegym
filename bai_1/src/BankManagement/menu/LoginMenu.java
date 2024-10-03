package BankManagement.menu;

import BankManagement.management.RegisterFormManagement;
import BankManagement.management.UserManagement;
import BankManagement.menu.Admin.AdminMenu;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.ChoiceLogin;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class LoginMenu {

    public static void displayMenu() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP " + TextColor.END_COLOR + "=================");
            System.out.println("1. Đăng nhập với quyền admin");
            System.out.println("2. Đăng nhập với quyền người dùng");
            System.out.println("3. Khôi phục mật khẩu");
            System.out.println("4. Đăng ký tài khoản người dùng");
            System.out.println("5. Hỗ trợ");
            System.out.println("6. Chọn ngôn ngữ");
            System.out.println("7. Tìm điểm giao dịch");
            System.out.println("8. Tra cứu tỷ giá");
            System.out.println("10. Đăng xuất");
            System.out.print("Nhập lựa chọn của bạn:");
            Choice.login = new Scanner(System.in).nextLine();
            switch (Choice.login) {
                case ChoiceLogin.LOGIN_AS_ADMIN:
                    AdminMenu.displayMenu();
                    break;
                case ChoiceLogin.LOGIN_AS_USER:
                    UserMenu.displayMenu();
                    break;
                case ChoiceLogin.RESET_PASSWORD:
                    UserManagement.resetPassword();
                    break;
                case ChoiceLogin.REGISTER_USER:
                    RegisterFormManagement.addNewRegisterForm();
                    break;
                case ChoiceLogin.SUPPORT:
                    break;
                case ChoiceLogin.EXIT:
                    isExit = true;
                    break;
                default:
                    System.out.println(TextColor.RED + "<!>Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
            }
        }
        System.out.println(TextColor.BLUE + "Hẹn gặp lại <3" + TextColor.END_COLOR);
    }
}
