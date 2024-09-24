package BankManagement.service;

import BankManagement.model.User;
import BankManagement.variable.Choice.Choice;
import BankManagement.variable.TextColor.TextColor;
import BankManagement.variable.ChoiceFromUser.AdminChoiceFind;
import BankManagement.variable.ChoiceFromUser.UserChoiceHome;


import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private ArrayList<User> userArrayList;

    public UserService() {
        userArrayList = new ArrayList<>();
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public void login() {
        boolean isFoundUser = false;
        System.out.print("Enter your username:");
        String username = (new Scanner(System.in)).nextLine();
        System.out.print("Enter your password:");
        String password = (new Scanner(System.in)).nextLine();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getAccount().getUsername().equals(username) && userArrayList.get(i).getAccount().getPassword().equals(password)) {
                isFoundUser = true;
                System.out.println(TextColor.BLUE + "Welcome " + userArrayList.get(i).getFullName() + TextColor.END_COLOR);
                while (true) {
                    boolean isExit = false;
                    System.out.println("=================" + TextColor.YELLOW + " LOGIN > HOME (User)" + TextColor.END_COLOR + "=================");
                    System.out.println("1. Deposit money");
                    System.out.println("2. Withdraw money");
                    System.out.println("3. Transact money");
                    System.out.println("4. Set up PIN for account");
                    System.out.println("5. Change PIN for account");
                    System.out.println("6. Change password for account");
                    System.out.println("7. Show your information");
                    System.out.println("10. Return login");
                    System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
                    System.out.print("Enter your choice:");
                    Choice.home = new Scanner(System.in).nextInt();
                    switch (Choice.home) {
                        case UserChoiceHome.DEPOSIT_MONEY:
                            this.deposit(userArrayList.get(i));
                            break;
                        case UserChoiceHome.WITHDRAW_MONEY:
                            break;
                        case UserChoiceHome.TRANSACT_MONEY:
                            break;
                        case UserChoiceHome.SET_UP_PIN_ACCOUNT:
                            this.setUpPinForAccount(userArrayList.get(i));
                            break;
                        case UserChoiceHome.CHANGE_PIN_ACCOUNT:
                            break;
                        case UserChoiceHome.CHANGE_PASSWORD:
                            break;
                        case UserChoiceHome.SHOW_USER_INFORMATION:
                            this.showUserInformation(userArrayList.get(i));
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
        if (!isFoundUser) {
            System.out.println(TextColor.RED + "<!>Invalid username or password" + TextColor.END_COLOR);
        }
    }
    private void deposit(User user) {
        System.out.print("Enter amount of money to deposit:");
        double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
        System.out.print("Enter your PIN to complete the deposit:");
        String inputPin = (new Scanner(System.in)).nextLine();

        if (user.getAccount().getPin().equals(inputPin)){
            System.out.println(TextColor.BLUE + "Deposit successfully, please check your account" + TextColor.END_COLOR);
            user.getAccount().setBalance(user.getAccount().getBalance() + inputAmountOfMoney);
            FileService.saveUserToFile(userArrayList);
        }
        else if (user.getAccount().getPin().isEmpty()){
            System.out.println(TextColor.RED + "<!>Please set up PIN for your account" + TextColor.END_COLOR);
        }
        else {
            System.out.println(TextColor.RED + "<!>Your PIN is wrong, please check again" + TextColor.END_COLOR);
        }
    }
    private void setUpPinForAccount(User user) {
        if (user.getAccount().getPin().isEmpty()) {
            System.out.print("Enter the PIN you want to set up:");
            String inputNewPin = (new Scanner(System.in)).nextLine();
            System.out.print("Enter your new PIN to confirm:");
            String inputPinConfirm = (new Scanner(System.in)).nextLine();
            if (inputPinConfirm.equals(inputNewPin)) {
                System.out.println(TextColor.BLUE + "Set up PIN Successfully" + TextColor.END_COLOR);
                user.getAccount().setPin(inputNewPin);
                FileService.saveUserToFile(userArrayList);
            }
            else {
                System.out.println(TextColor.RED + "<!>Your PIN confirm is wrong, please check again" + TextColor.END_COLOR);
            }
        }
        else {
            System.out.println(TextColor.RED + "<!>You already have an account PIN for your account" + TextColor.END_COLOR);
        }
    }
    private void showUserInformation(User user) {
        System.out.println("Your account information: " + " name: " + user.getFullName() +
                " || phone: " + user.getPhoneNumber() +
                " || balance: " + user.getAccount().getBalance() +
                " || pin: " + user.getAccount().getPin());
    }

    public void addUser() {
        userArrayList.add(this.createNewUser());
        FileService.saveUserToFile(userArrayList);
    }

    public void findUser() {
        while (true) {
            boolean isExist = false;
            System.out.println("=================" + TextColor.YELLOW + " LOGIN > HOME (Admin) > FIND USER (Admin)" + TextColor.END_COLOR + "=================");
            System.out.println("1. Find user by full name");
            System.out.println("2. Find user by phone number");
            System.out.println("3. Show all users");
            System.out.println("10. Return home");
            System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
            System.out.print("Enter your choice:");
            Choice.find = new Scanner(System.in).nextInt();

            switch (Choice.find) {
                case AdminChoiceFind.FIND_BY_FULL_NAME:
                    break;
                case AdminChoiceFind.FIND_BY_PHONE_NUMBER:
                    break;
                case AdminChoiceFind.SHOW_ALL_USERS:
                    this.showAllUsers();
                    break;
                case AdminChoiceFind.RETURN_HOME:
                    isExist = true;
                    break;
            }
            if (isExist) {
                break;
            }
        }
    }

    public void editUser(User user) {
    }

    public void deleteUser(User user) {
    }

    public void showAllUsers() {
        userArrayList = FileService.loadUserFromFile();
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i).toString());
        }
    }

    public void deleteAllUsers() {
        userArrayList.clear();
    }

    private User createNewUser() {
        System.out.print("Enter user full name:");
        String userFullName = new Scanner(System.in).nextLine();
        System.out.print("Enter user phone number:");
        String userPhoneNumber = new Scanner(System.in).nextLine();

        return new User(userFullName, userPhoneNumber);
    }

    private void findUserByFullName() {
        System.out.print("Enter user full name: you want to find:");
        String userFullName = new Scanner(System.in).nextLine();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getFullName().equals(userFullName)) {
                System.out.println(userArrayList.get(i).toString());
            }
        }
    }

    private void findUserByPhoneNumber() {

    }
}
