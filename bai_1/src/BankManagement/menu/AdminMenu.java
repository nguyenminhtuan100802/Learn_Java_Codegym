package BankManagement.menu;

import BankManagement.entity.Admin;
import BankManagement.management.RegisterFormManagement;
import BankManagement.management.UserManagement;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.AdminChoiceEdit;
import BankManagement.utility.ChoiceFromUser.AdminChoiceFind;
import BankManagement.utility.TextColor.TextColor;
import BankManagement.utility.ChoiceFromUser.AdminChoiceHome;

import java.util.Scanner;

public class AdminMenu {
    private static final Admin admin = new Admin();

    public static void login() {
        UserManagement.saveAndLoadData();
        System.out.print("Enter username:");
        String username = new Scanner(System.in).nextLine();
        System.out.print("Enter password:");
        String password = new Scanner(System.in).nextLine();
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println(TextColor.BLUE + "Admin login successfully" + TextColor.END_COLOR);
            boolean isExit = false;
            while (!isExit) {
                System.out.println("=================" + TextColor.YELLOW + " LOGIN > HOME (Admin) " + TextColor.END_COLOR + "=================");
                System.out.println("1. Add new user");
                System.out.println("2. Find user");
                System.out.println("3. Edit user");
                System.out.println("4. Delete user");
                System.out.println("5. Lock user");
                System.out.println("6. Show all users");
                System.out.println("7. Delete all user");
                System.out.println("8. Show all user transaction history");
                System.out.println("9. Show all user's register form");
                System.out.println("10. Return login");
                System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
                System.out.print("Enter your choice:");
                Choice.home = new Scanner(System.in).nextLine();
                switch (Choice.home) {
                    case AdminChoiceHome.ADD_NEW_USER:
                        UserManagement.addUser();
                        break;
                    case AdminChoiceHome.FIND_USER:
                        findUser();
                        break;
                    case AdminChoiceHome.EDIT_USER:
                        break;
                    case AdminChoiceHome.DELETE_USER:
                        break;
                    case AdminChoiceHome.LOCK_USER:
                        break;
                    case AdminChoiceHome.SHOW_ALL_USERS:
                        UserManagement.showAllUsers();
                        break;
                    case AdminChoiceHome.DELETE_ALL_USERS:
                        UserManagement.deleteAllUsers();
                        break;
                    case AdminChoiceHome.SHOW_ALL_USER_TRANSACTION:
                        UserManagement.showAllUserTransactionsHistory();
                        break;
                    case AdminChoiceHome.SHOW_ALL_USER_REGISTER_FORM:
                        RegisterFormManagement.showRegisterForms();
                        break;
                    case AdminChoiceHome.RETURN_LOGIN:
                        isExit = true;
                        break;
                    default:
                        System.out.println(TextColor.RED + "<!>Your choice is not valid!" + TextColor.END_COLOR);
                }
            }
        } else {
            System.out.println(TextColor.RED + "<!>Incorrect username or password" + TextColor.END_COLOR);
        }
    }

    private static void findUser() {
        boolean isExist = false;
        while (!isExist) {
            System.out.println("=================" + TextColor.YELLOW + " LOGIN > HOME (Admin) > FIND USER (Admin) " + TextColor.END_COLOR + "=================");
            System.out.println("1. Find user by full name");
            System.out.println("2. Find user by phone number");
            System.out.println("3. Show all users");
            System.out.println("10. Return home");
            System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
            System.out.print("Enter your choice:");
            Choice.find = new Scanner(System.in).nextLine();

            switch (Choice.find) {
                case AdminChoiceFind.FIND_BY_FULL_NAME:
                    UserManagement.findUserByName();
                    break;
                case AdminChoiceFind.FIND_BY_PHONE_NUMBER:
                    UserManagement.findUserByPhoneNumber();
                    break;
                case AdminChoiceFind.SHOW_ALL_USERS:
                    UserManagement.showAllUsers();
                    break;
                case AdminChoiceFind.RETURN_HOME:
                    isExist = true;
                    break;
                default:
                    System.out.println(TextColor.RED + "<!>Your choice is not valid!" + TextColor.END_COLOR);
            }
        }
    }

    private static void editUser() {
        boolean isExist = false;
        while (!isExist) {
            System.out.println("=================" + TextColor.YELLOW + " LOGIN > HOME (Admin) > EDIT USER (Admin) " + TextColor.END_COLOR + "=================");
            System.out.println("1. Edit name");
            System.out.println("2. Edit phone number");
            System.out.println("3. Edit password");
            System.out.println("4. Edit PIN");
            System.out.println("5. Edit email");
            System.out.println("6. Edit name + phone + password + PIN + email");
            System.out.println("7. Show all users");
            System.out.println("10. Return home");
            System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
            System.out.print("Enter your choice:");
            Choice.edit = new Scanner(System.in).nextLine();

            switch (Choice.edit) {
                case AdminChoiceEdit.EDIT_NAME:
                    break;
                case AdminChoiceEdit.EDIT_PHONE:
                    break;
                case AdminChoiceEdit.EDIT_PASSWORD:
                    break;
                case AdminChoiceEdit.EDIT_PIN:
                    break;
                case AdminChoiceEdit.EDIT_EMAIL:
                    break;
                case AdminChoiceEdit.EDIT_ALL:
                    break;
                case AdminChoiceEdit.SHOW_ALL_USERS:
                    UserManagement.showAllUsers();
                    break;
                case AdminChoiceEdit.RETURN_HOME:
                    isExist = true;
                    break;
                default:
                    System.out.println(TextColor.RED + "<!>Your choice is not valid!" + TextColor.END_COLOR);
            }
        }
    }

    public void deleteUser() {
    }

    public void lockUser() {
    }
}
