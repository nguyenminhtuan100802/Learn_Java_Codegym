package BankManagement.menu;

import BankManagement.management.UserManagement;
import BankManagement.constant.AdminEditChoice;
import BankManagement.constant.TextColor;
import BankManagement.utility.Choice;

import java.util.Scanner;

public class AdminEditUserMenu implements Menu {
    public static AdminMenu getInstance() {
        return new AdminMenu();
    }
    public void displayMenu() {
        boolean isExist = false;
        while (!isExist) {
            System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP > TRANG CHỦ (Quản trị viên) > CHỈNH SỬA NGƯỜI DÙNG (Quản trị viên) " + TextColor.END_COLOR + "=================");
            System.out.println("1. Chỉnh sửa tên");
            System.out.println("2. Chỉnh sửa số điện thoại");
            System.out.println("3. Chỉnh sửa mật khẩu");
            System.out.println("4. Chỉnh sửa PIN");
            System.out.println("5. Chỉnh sửa email");
            System.out.println("6. Chỉnh sửa tên + điện thoại + mật khẩu + PIN + email");
            System.out.println("7. Hiển thị tất cả người dùng");
            System.out.println("0. Trở về trang chủ");
            System.out.print("Nhập lựa chọn của bạn:");
            Choice.edit = new Scanner(System.in).nextLine();

            switch (Choice.edit) {
                case AdminEditChoice.EDIT_NAME:
                    UserManagement.editUserName();
                    break;
                case AdminEditChoice.EDIT_PHONE:
                    UserManagement.editUserPhoneNumber();
                    break;
                case AdminEditChoice.EDIT_PASSWORD:
                    UserManagement.editUserPassword();
                    break;
                case AdminEditChoice.EDIT_PIN:
                    UserManagement.editUserPIN();
                    break;
                case AdminEditChoice.EDIT_EMAIL:
                    UserManagement.editUserEmail();
                    break;
                case AdminEditChoice.EDIT_ALL:
                    UserManagement.editAllUserInfo();
                    break;
                case AdminEditChoice.SHOW_ALL_USERS:
                    UserManagement.showAllUsers();
                    break;
                case AdminEditChoice.RETURN_HOME:
                    isExist = true;
                    break;
                default:
                    System.out.println(TextColor.RED + "<!> Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
            }
        }
    }
}
