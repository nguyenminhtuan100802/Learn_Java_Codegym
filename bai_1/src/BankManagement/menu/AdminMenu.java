package BankManagement.menu;

import BankManagement.service.AdminService;
import BankManagement.management.RegisterFormManagement;
import BankManagement.management.UserManagement;
import BankManagement.service.FileService;
import BankManagement.service.MenuService;
import BankManagement.utility.Choice;
import BankManagement.constant.TextColor;
import BankManagement.constant.AdminHomeChoice;

import java.util.Scanner;

public class AdminMenu implements Menu {
    public static AdminMenu getInstance() {
        return new AdminMenu();
    }
    public void displayMenu() {
        FileService.saveAndLoadData();
        if (AdminService.verifyLogin()){
            boolean isExit = false;
            while (!isExit) {
                MenuService.refreshMenu();
                System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP > TRANG CHỦ (Quản trị viên) " + TextColor.END_COLOR + "=================");
                System.out.println("1. Thêm người dùng mới");
                System.out.println("2. Tìm người dùng");
                System.out.println("3. Chỉnh sửa thông tin người dùng");
                System.out.println("4. Xoá người dùng");
                System.out.println("5. Khoá tài khoản người dùng");
                System.out.println("6. Hiển thị tất cả người dùng");
                System.out.println("7. Xoá tất cả người dùng");
                System.out.println("8. Hiển thị lịch sử giao dịch của tất cả người dùng");
                System.out.println("9. Hiển thị tất cả đơn đăng ký của người dùng");
                System.out.println("0. Quay lại đăng nhập");
                System.out.print("Nhập lựa chọn của bạn: ");
                Choice.home = new Scanner(System.in).nextLine();
                switch (Choice.home) {
                    case AdminHomeChoice.ADD_NEW_USER:
                        UserManagement.addUser();
                        break;
                    case AdminHomeChoice.FIND_USER:
                        AdminFindUserMenu.getInstance().displayMenu();
                        break;
                    case AdminHomeChoice.EDIT_USER:
                        AdminEditUserMenu.getInstance().displayMenu();
                        break;
                    case AdminHomeChoice.DELETE_USER:
                        break;
                    case AdminHomeChoice.LOCK_USER:
                        break;
                    case AdminHomeChoice.SHOW_ALL_USERS:
                        UserManagement.showAllUsers();
                        break;
                    case AdminHomeChoice.DELETE_ALL_USERS:
                        UserManagement.deleteAllUsers();
                        break;
                    case AdminHomeChoice.SHOW_ALL_USER_TRANSACTION:
                        UserManagement.showAllUserTransactionsHistory();
                        break;
                    case AdminHomeChoice.SHOW_ALL_USER_REGISTER_FORM:
                        RegisterFormManagement.showRegisterForms();
                        break;
                    case AdminHomeChoice.RETURN_LOGIN:
                        isExit = true;
                        break;
                    default:
                        System.out.println(TextColor.RED + "<!>Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
                }
            }
        }
    }



    public void deleteUser() {
    }

    public void lockUser() {
    }
}
