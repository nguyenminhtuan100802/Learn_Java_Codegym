package BankManagement.menu;

import BankManagement.management.RegisterFormManagement;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.ChoiceLogin;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class LoginMenu {

    public void run() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("=================" + TextColor.YELLOW + " LOGIN " + TextColor.END_COLOR + "=================");
            System.out.println("1. Login as admin");
            System.out.println("2. Login as user");
            System.out.println("3. Reset password");
            System.out.println("4. Register as user");
            System.out.println("5. Support");
            System.out.println("6. Choose language");
            System.out.println("7. Find a transaction point");
            System.out.println("8. Look up exchange rate");
            System.out.println("10. Logout");
            System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
            System.out.print("Enter your choice:");
            Choice.login = new Scanner(System.in).nextLine();
            switch (Choice.login) {
                case ChoiceLogin.LOGIN_AS_ADMIN:
                    AdminMenu.login();
                    break;
                case ChoiceLogin.LOGIN_AS_USER:
                    UserMenu.login();
                    break;
                case ChoiceLogin.RESET_PASSWORD:
                    break;
                case ChoiceLogin.REGISTER_USER:
                    RegisterFormManagement.addNewRegisterForm();
                    break;
                case ChoiceLogin.SUPPORT:
                    break;
                case ChoiceLogin.EXIT:
                    isExit = true;
                    break;
                default:
                    System.out.println(TextColor.RED + "<!>Your choice is not valid!" + TextColor.END_COLOR);
            }
        }
        System.out.println(TextColor.BLUE + "See you again <3" + TextColor.END_COLOR);

    }
}
