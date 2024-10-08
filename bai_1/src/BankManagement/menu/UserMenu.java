package BankManagement.menu;

import BankManagement.management.UserManagement;
import BankManagement.service.AccountService;
import BankManagement.service.FileService;
import BankManagement.service.MenuService;
import BankManagement.utility.Choice;
import BankManagement.constant.UserHomeChoice;
import BankManagement.constant.TextColor;

import java.util.Scanner;

public class UserMenu implements Menu {
    public static UserMenu getInstance(){
        return new UserMenu();
    }
    public void displayMenu() {
        FileService.saveAndLoadData();

        boolean isFound = false;
        System.out.print("Nhập tên đăng nhập của bạn:");
        String username = (new Scanner(System.in)).nextLine();
        System.out.print("Nhập mật khẩu của bạn:");
        String password = (new Scanner(System.in)).nextLine();

        for (int i = 0; i < UserManagement.getUserArrayList().size(); i++) {
            if (UserManagement.getUserArrayList().get(i).getUsername().equals(username) && UserManagement.getUserArrayList().get(i).getPassword().equals(password)){
                isFound = true;
                System.out.println(TextColor.BLUE + "Xin chào " + UserManagement.getUserArrayList().get(i).getFullName() + TextColor.END_COLOR);
                boolean isExit = false;
                while (!isExit) {
                    MenuService.refreshMenu();
                    System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP > TRANG CHỦ (Người dùng) " + TextColor.END_COLOR + "=================");
                    System.out.println("1. Nạp tiền");
                    System.out.println("2. Rút tiền");
                    System.out.println("3. Chuyển tiền");
                    System.out.println("4. Tiết kiệm");
                    System.out.println("5. Nạp tiền điện thoại");
                    System.out.println("6. Thanh toán hóa đơn");
                    System.out.println("7. Xem thông tin của bạn");
                    System.out.println("8. Xem lịch sử giao dịch của bạn");
                    System.out.println("9. Bảo mật");
                    System.out.println("0. Trở về đăng nhập");
                    System.out.print("Nhập lựa chọn của bạn:");
                    Choice.home = new Scanner(System.in).nextLine();
                    switch (Choice.home) {
                        case UserHomeChoice.DEPOSIT_MONEY:
                            AccountService.deposit(UserManagement.getUserArrayList().get(i));
                            break;
                        case UserHomeChoice.WITHDRAW_MONEY:
                            AccountService.withdraw(UserManagement.getUserArrayList().get(i));
                            break;
                        case UserHomeChoice.TRANSACT_MONEY:
                            AccountService.transact(UserManagement.getUserArrayList().get(i));
                            break;
                        case UserHomeChoice.SAVING_MONEY:
                            break;
                        case UserHomeChoice.RECHARGE_PHONE:
                            break;
                        case UserHomeChoice.PAY_BILLS:
                            break;
                        case UserHomeChoice.SHOW_USER_INFORMATION:
                            UserManagement.showUserInformation(UserManagement.getUserArrayList().get(i));
                            break;
                        case UserHomeChoice.SHOW_TRANSACTION_HISTORY:
                            UserManagement.showUserTransactionHistory(UserManagement.getUserArrayList().get(i));
                            break;
                        case UserHomeChoice.SECURITY:
                            SecurityMenu.displayMenu(UserManagement.getUserArrayList().get(i));
                            break;
                        case UserHomeChoice.RETURN_LOGIN:
                            isExit = true;
                            break;
                        default:
                            System.out.println(TextColor.RED + "<!> Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
                    }
                }
            }
        }
        if (!isFound){
            System.out.println(TextColor.RED + "<!> Tên đăng nhập hoặc mật khẩu không đúng!" + TextColor.END_COLOR);
        }
    }
}
