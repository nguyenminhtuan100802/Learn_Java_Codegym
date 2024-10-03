package BankManagement.menu;

import BankManagement.entity.User;
import BankManagement.management.UserManagement;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.UserChoiceHome;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class UserMenu {

    public static void displayMenu() {
        UserManagement.saveAndLoadData();

        User user;
        if ((user = UserManagement.verifyLogin()) != null) {
            boolean isExit = false;
            while (!isExit) {
                System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP > TRANG CHỦ (Người dùng) " + TextColor.END_COLOR + "=================");
                System.out.println("1. Nạp tiền");
                System.out.println("2. Rút tiền");
                System.out.println("3. Chuyển tiền");
                System.out.println("4. Thiết lập PIN cho tài khoản");
                System.out.println("5. Đổi PIN cho tài khoản");
                System.out.println("6. Đổi mật khẩu cho tài khoản");
                System.out.println("7. Hiển thị thông tin của bạn");
                System.out.println("8. Hiển thị lịch sử giao dịch của bạn");
                System.out.println("10. Trở về đăng nhập");
                System.out.print("Nhập lựa chọn của bạn:");
                Choice.home = new Scanner(System.in).nextLine();
                switch (Choice.home) {
                    case UserChoiceHome.DEPOSIT_MONEY:
                        UserManagement.deposit(user);
                        break;
                    case UserChoiceHome.WITHDRAW_MONEY:
                        UserManagement.withdraw(user);
                        break;
                    case UserChoiceHome.TRANSACT_MONEY:
                        UserManagement.transact(user);
                        break;
                    case UserChoiceHome.SET_UP_PIN_ACCOUNT:
                        UserManagement.setUpPinForAccount(user);
                        break;
                    case UserChoiceHome.CHANGE_PIN_ACCOUNT:
                        UserManagement.changePinForAccount(user);
                        break;
                    case UserChoiceHome.CHANGE_PASSWORD:
                        UserManagement.changePasswordForAccount(user);
                        break;
                    case UserChoiceHome.SHOW_USER_INFORMATION:
                        UserManagement.showUserInformation(user);
                        break;
                    case UserChoiceHome.SHOW_TRANSACTION_HISTORY:
                        UserManagement.showUserTransactionHistory(user);
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
