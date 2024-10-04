package BankManagement.menu;

import BankManagement.entity.User;
import BankManagement.management.UserManagement;
import BankManagement.service.AccountService;
import BankManagement.service.File.FileService;
import BankManagement.service.UserService;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.UserChoiceHome;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class UserMenu implements Menu {
    public static UserMenu getInstance(){
        return new UserMenu();
    }
    public void displayMenu() {
        FileService.saveAndLoadData();

        User user;
        if ((user = UserService.verifyLogin()) != null) {
            boolean isExit = false;
            while (!isExit) {
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
                    case UserChoiceHome.DEPOSIT_MONEY:
                        AccountService.deposit(user);
                        break;
                    case UserChoiceHome.WITHDRAW_MONEY:
                        AccountService.withdraw(user);
                        break;
                    case UserChoiceHome.TRANSACT_MONEY:
                        AccountService.transact(user);
                        break;
                    case UserChoiceHome.SAVING_MONEY:
                        break;
                    case UserChoiceHome.RECHARGE_PHONE:
                        break;
                    case UserChoiceHome.PAY_BILLS:
                        break;
                    case UserChoiceHome.SHOW_USER_INFORMATION:
                        UserManagement.showUserInformation(user);
                        break;
                    case UserChoiceHome.SHOW_TRANSACTION_HISTORY:
                        UserManagement.showUserTransactionHistory(user);
                        break;
                    case UserChoiceHome.SECURITY:
                        SecurityMenu.displayMenu(user);
                        break;
                    case UserChoiceHome.RETURN_LOGIN:
                        isExit = true;
                        break;
                    default:
                        System.out.println(TextColor.RED + "<!> Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
                }
            }
        }
    }
}
