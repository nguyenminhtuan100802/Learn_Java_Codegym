package BankManagement.service;

import BankManagement.model.Admin;
import BankManagement.variable.Choice.Choice;
import BankManagement.variable.TextColor.TextColor;
import BankManagement.variable.UserChoice.UserChoiceHome;

import java.util.Scanner;

public class AdminService {
    Admin admin;

    public AdminService() {
        this.admin = new Admin();
    }

    public void login(UserService userService) {
        System.out.print("Enter username:");
        String username = new Scanner(System.in).nextLine();
        System.out.print("Enter password:");
        String password = new Scanner(System.in).nextLine();
        if (this.admin.getAccount().getUsername().equals(username) && this.admin.getAccount().getPassword().equals(password)) {
            this.manage(userService);
        }
        else {
            System.out.println(TextColor.RED + "<!>Incorrect username or password" + TextColor.END_COLOR);
        }
    }

    public void manage(UserService userService) {
        System.out.println("Admin login successfully");
        while (true) {
            boolean isExit = false;
            System.out.println("=================" + TextColor.YELLOW + " LOGIN > HOME (Admin)" + TextColor.END_COLOR + "=================");
            System.out.println("1. Add new user");
            System.out.println("2. Find user");
            System.out.println("3. Edit user");
            System.out.println("4. Delete user");
            System.out.println("5. Show all users");
            System.out.println("6. Delete all user");
            System.out.println("10. Return login");
            System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
            System.out.print("Enter your choice:");
            Choice.home = new Scanner(System.in).nextInt();
            switch (Choice.home) {
                case UserChoiceHome.ADD_NEW_USER:
                    userService.addUser();
                    break;
                case UserChoiceHome.FIND_USER:
                    userService.findUser();
                    break;
                case UserChoiceHome.EDIT_USER:
                    break;
                case UserChoiceHome.DELETE_USER:
                    break;
                case UserChoiceHome.SHOW_ALL_USERS:
                    userService.showAllUsers();
                    break;
                case UserChoiceHome.DELETE_ALL_USERS:
                    userService.deleteAllUsers();
                    break;
                case UserChoiceHome.RETURN_LOGIN:
                    isExit = true;
                    break;
            }
            if (isExit) {
                break;
            }
        }
    }
}
