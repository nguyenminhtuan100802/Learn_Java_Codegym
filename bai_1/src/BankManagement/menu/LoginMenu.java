package BankManagement.menu;

import BankManagement.management.RegisterFormManagement;
import BankManagement.management.UserManagement;
import BankManagement.service.MenuService;
import BankManagement.utility.Choice;
import BankManagement.constant.LoginChoice;
import BankManagement.constant.TextColor;

import java.util.Scanner;

public class LoginMenu implements Menu {
    public static LoginMenu getInstance(){
        return new LoginMenu();
    }

    public void displayMenu() {
        boolean isExit = false;
        while (!isExit) {
            MenuService.refreshMenu();
            System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP " + TextColor.END_COLOR + "=================");
            System.out.println("1. Đăng nhập với quyền admin");
            System.out.println("2. Đăng nhập với quyền người dùng");
            System.out.println("3. Khôi phục mật khẩu");
            System.out.println("4. Đăng ký tài khoản người dùng");
            System.out.println("5. Hỗ trợ");
            System.out.println("6. Chọn ngôn ngữ");
            System.out.println("7. Tìm điểm giao dịch");
            System.out.println("8. Tra cứu tỷ giá");
            System.out.println("0. Đăng xuất");
            System.out.print("Nhập lựa chọn của bạn:");
            Choice.login = new Scanner(System.in).nextLine();
            switch (Choice.login) {
                case LoginChoice.LOGIN_AS_ADMIN:
                    AdminMenu.getInstance().displayMenu();
                    break;
                case LoginChoice.LOGIN_AS_USER:
                    UserMenu.getInstance().displayMenu();
                    break;
                case LoginChoice.RESET_PASSWORD:
                    UserManagement.resetPassword();
                    break;
                case LoginChoice.REGISTER_USER:
                    RegisterFormManagement.addNewRegisterForm();
                    break;
                case LoginChoice.SUPPORT:
                    break;
                case LoginChoice.EXIT:
                    isExit = true;
                    break;
                default:
                    System.out.println(TextColor.RED + "<!>Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
            }
        }
        System.out.println(TextColor.BLUE + "Hẹn gặp lại <3" + TextColor.END_COLOR);
    }
}
