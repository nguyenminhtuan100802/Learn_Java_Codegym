package BankManagement.menu.Admin;

import BankManagement.entity.Admin;
import BankManagement.management.AdminManagement;
import BankManagement.management.RegisterFormManagement;
import BankManagement.management.UserManagement;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.AdminChoiceEdit;
import BankManagement.utility.TextColor.TextColor;
import BankManagement.utility.ChoiceFromUser.AdminChoiceHome;

import java.util.Scanner;

public class AdminMenu {
    private static final Admin admin = new Admin();

    public static void displayMenu() {
        UserManagement.saveAndLoadData();
        if (AdminManagement.verifyLogin()){
            boolean isExit = false;
            while (!isExit) {
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
                System.out.println("10. Quay lại đăng nhập");
                System.out.print("Nhập lựa chọn của bạn: ");
                Choice.home = new Scanner(System.in).nextLine();
                switch (Choice.home) {
                    case AdminChoiceHome.ADD_NEW_USER:
                        AdminManagement.addUser();
                        break;
                    case AdminChoiceHome.FIND_USER:
                        AdminFindUserMenu.findUser();
                        break;
                    case AdminChoiceHome.EDIT_USER:
                        AdminEditUserMenu.editUser();
                        break;
                    case AdminChoiceHome.DELETE_USER:
                        break;
                    case AdminChoiceHome.LOCK_USER:
                        break;
                    case AdminChoiceHome.SHOW_ALL_USERS:
                        AdminManagement.showAllUsers();
                        break;
                    case AdminChoiceHome.DELETE_ALL_USERS:
                        AdminManagement.deleteAllUsers();
                        break;
                    case AdminChoiceHome.SHOW_ALL_USER_TRANSACTION:
                        AdminManagement.showAllUserTransactionsHistory();
                        break;
                    case AdminChoiceHome.SHOW_ALL_USER_REGISTER_FORM:
                        RegisterFormManagement.showRegisterForms();
                        break;
                    case AdminChoiceHome.RETURN_LOGIN:
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
