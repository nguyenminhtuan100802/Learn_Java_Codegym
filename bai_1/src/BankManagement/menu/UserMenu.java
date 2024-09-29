package BankManagement.menu;

import BankManagement.management.TransactionManagement;
import BankManagement.management.UserManagement;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.UserChoiceHome;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class UserMenu {

    public static void login() {
        UserManagement.saveAndLoadData();

        boolean isFoundUser = false;
        System.out.print("Enter your username:");
        String username = (new Scanner(System.in)).nextLine();
        System.out.print("Enter your password:");
        String password = (new Scanner(System.in)).nextLine();

        for (int i = 0; i < UserManagement.userArrayList.size(); i++) {
            if (UserManagement.userArrayList.get(i).getUsername().equals(username) && UserManagement.userArrayList.get(i).getPassword().equals(password)) {
                isFoundUser = true;
                System.out.println(TextColor.BLUE + "Welcome " + UserManagement.userArrayList.get(i).getFullName() + TextColor.END_COLOR);
                boolean isExit = false;
                while (!isExit) {
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
                    Choice.home = new Scanner(System.in).nextLine();
                    switch (Choice.home) {
                        case UserChoiceHome.DEPOSIT_MONEY:
                            UserManagement.deposit(UserManagement.userArrayList.get(i));
                            break;
                        case UserChoiceHome.WITHDRAW_MONEY:
                            UserManagement.withdraw(UserManagement.userArrayList.get(i));
                            break;
                        case UserChoiceHome.TRANSACT_MONEY:
                            UserManagement.transact(UserManagement.userArrayList.get(i));
                            break;
                        case UserChoiceHome.SET_UP_PIN_ACCOUNT:
                            UserManagement.setUpPinForAccount(UserManagement.userArrayList.get(i));
                            break;
                        case UserChoiceHome.CHANGE_PIN_ACCOUNT:
                            UserManagement.changePinForAccount(UserManagement.userArrayList.get(i));
                            break;
                        case UserChoiceHome.CHANGE_PASSWORD:
                            UserManagement.changePasswordForAccount(UserManagement.userArrayList.get(i));
                            break;
                        case UserChoiceHome.SHOW_USER_INFORMATION:
                            UserManagement.showUserInformation(UserManagement.userArrayList.get(i));
                            break;
                        case UserChoiceHome.SHOW_TRANSACTION_HISTORY:
                            UserManagement.showUserTransactionHistory(UserManagement.userArrayList.get(i));
                            break;
                        case UserChoiceHome.RETURN_LOGIN:
                            isExit = true;
                            break;
                        default:
                            System.out.println(TextColor.RED + "<!>Your choice is not valid!" + TextColor.END_COLOR);

                    }
                }
            }
        }
        if (!isFoundUser) {
            System.out.println(TextColor.RED + "<!>Invalid username or password" + TextColor.END_COLOR);
        }
    }
}
