package BankManagement.menu;

import BankManagement.entity.Language;
import BankManagement.management.TransactionManagement;
import BankManagement.management.UserManagement;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.UserChoiceHome;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class UserMenu {
    private final UserManagement userManagement;
    private final TransactionManagement transactionManagement;

    public UserMenu() {
        userManagement = new UserManagement();
        transactionManagement = new TransactionManagement();
    }

    public void login() {
        userManagement.saveAndLoadData(transactionManagement);

        boolean isFoundUser = false;
        if (Language.languageName.equals("English")) System.out.print("Enter your username:");
        else if (Language.languageName.equals("Vietnamese")) System.out.print("Nhập tên người dùng của bạn:");
        String username = (new Scanner(System.in)).nextLine();
        if (Language.languageName.equals("English")) System.out.print("Enter your password:");
        else if (Language.languageName.equals("Vietnamese")) System.out.print("Nhập mật khẩu của bạn:");
        String password = (new Scanner(System.in)).nextLine();

        for (int i = 0; i < userManagement.getUserArrayList().size(); i++) {
            if (userManagement.getUserArrayList().get(i).getUsername().equals(username) && userManagement.getUserArrayList().get(i).getPassword().equals(password)) {
                isFoundUser = true;
                if (Language.languageName.equals("English"))
                    System.out.println(TextColor.BLUE + "Welcome " + userManagement.getUserArrayList().get(i).getFullName() + TextColor.END_COLOR);
                else if (Language.languageName.equals("Vietnamese"))
                    System.out.println(TextColor.BLUE + "Chào mừng " + userManagement.getUserArrayList().get(i).getFullName() + TextColor.END_COLOR);
                boolean isExit = false;
                while (!isExit) {
                    if (Language.languageName.equals("English")) {
                        System.out.println("=================" + TextColor.YELLOW + " LOGIN > HOME (User) " + TextColor.END_COLOR + "=================");
                        System.out.println("1. Deposit money");
                        System.out.println("2. Withdraw money");
                        System.out.println("3. Transact money");
                        System.out.println("4. Set up PIN for account");
                        System.out.println("5. Change PIN for account");
                        System.out.println("6. Change password for account");
                        System.out.println("7. Show your information");
                        System.out.println("8. Show your transactions history");
                        System.out.println("10. Return login");
                        System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
                        System.out.print("Enter your choice:");
                    } else if (Language.languageName.equals("Vietnamese")) {
                        System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP > TRANG CHỦ (Người dùng) " + TextColor.END_COLOR + "=================");
                        System.out.println("1. Gửi tiền");
                        System.out.println("2. Rút tiền");
                        System.out.println("3. Chuyển tiền");
                        System.out.println("4. Thiết lập mã PIN cho tài khoản");
                        System.out.println("5. Thay đổi mã PIN cho tài khoản");
                        System.out.println("6. Thay đổi mật khẩu cho tài khoản");
                        System.out.println("7. Xem thông tin của bạn");
                        System.out.println("8. Xem lịch sử giao dịch của bạn");
                        System.out.println("10. Quay lại đăng nhập");
                        System.out.println("=================" + TextColor.YELLOW + " KẾT THÚC " + TextColor.END_COLOR + "=================");
                        System.out.print("Nhập lựa chọn của bạn:");
                    }
                    Choice.home = new Scanner(System.in).nextLine();
                    switch (Choice.home) {
                        case UserChoiceHome.DEPOSIT_MONEY:
                            userManagement.deposit(userManagement.getUserArrayList().get(i), transactionManagement);
                            break;
                        case UserChoiceHome.WITHDRAW_MONEY:
                            userManagement.withdraw(userManagement.getUserArrayList().get(i), transactionManagement);
                            break;
                        case UserChoiceHome.TRANSACT_MONEY:
                            userManagement.transact(userManagement.getUserArrayList().get(i), transactionManagement);
                            break;
                        case UserChoiceHome.SET_UP_PIN_ACCOUNT:
                            userManagement.setUpPinForAccount(userManagement.getUserArrayList().get(i));
                            break;
                        case UserChoiceHome.CHANGE_PIN_ACCOUNT:
                            userManagement.changePinForAccount(userManagement.getUserArrayList().get(i));
                            break;
                        case UserChoiceHome.CHANGE_PASSWORD:
                            userManagement.changePasswordForAccount(userManagement.getUserArrayList().get(i));
                            break;
                        case UserChoiceHome.SHOW_USER_INFORMATION:
                            userManagement.showUserInformation(userManagement.getUserArrayList().get(i), transactionManagement);
                            break;
                        case UserChoiceHome.SHOW_TRANSACTION_HISTORY:
                            userManagement.showUserTransactionHistory(userManagement.getUserArrayList().get(i), transactionManagement);
                            break;
                        case UserChoiceHome.RETURN_LOGIN:
                            isExit = true;
                            break;
                        default:
                            if (Language.languageName.equals("English"))
                                System.out.println(TextColor.RED + "<!>Your choice is not valid!" + TextColor.END_COLOR);
                            else if (Language.languageName.equals("Vietnamese"))
                                System.out.println(TextColor.RED + "<!>Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
                    }
                }
            }
        }
        if (!isFoundUser) {
            if (Language.languageName.equals("English"))
                System.out.println(TextColor.RED + "<!>Invalid username or password" + TextColor.END_COLOR);
            else if (Language.languageName.equals("Vietnamese"))
                System.out.println(TextColor.RED + "<!>Tên người dùng hoặc mật khẩu không hợp lệ" + TextColor.END_COLOR);
        }
    }
}
