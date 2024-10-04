package BankManagement.menu.Admin;

import BankManagement.management.UserManagement;
import BankManagement.service.AdminService;
import BankManagement.menu.Menu;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.AdminChoiceFind;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class AdminFindUserMenu implements Menu {
    public static AdminFindUserMenu getInstance() {
        return new AdminFindUserMenu();
    }
    public void displayMenu() {
        boolean isExist = false;
        while (!isExist) {
            System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP > TRANG CHỦ (Quản trị viên) > TÌM NGƯỜI DÙNG (Quản trị viên) " + TextColor.END_COLOR + "=================");
            System.out.println("1. Tìm người dùng theo tên");
            System.out.println("2. Tìm người dùng theo số điện thoại");
            System.out.println("3. Tìm người dùng theo tên đăng nhập");
            System.out.println("4. Tìm người dùng theo email");
            System.out.println("5. Hiện tất cả người dùng");
            System.out.println("10. Quay lại trang chủ");
            System.out.print("Nhập lựa chọn của bạn:");
            Choice.find = new Scanner(System.in).nextLine();

            switch (Choice.find) {
                case AdminChoiceFind.FIND_BY_FULL_NAME:
                    UserManagement.findUserByName();
                    break;
                case AdminChoiceFind.FIND_BY_PHONE_NUMBER:
                    UserManagement.findUserByPhoneNumber();
                    break;
                case AdminChoiceFind.FIND_BY_USERNAME:
                    break;
                case AdminChoiceFind.FIND_BY_EMAIL:
                    break;
                case AdminChoiceFind.SHOW_ALL_USERS:
                    UserManagement.showAllUsers();
                    break;
                case AdminChoiceFind.RETURN_HOME:
                    isExist = true;
                    break;
                default:
                    System.out.println(TextColor.RED + "<!> Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
            }
        }
    }

}
