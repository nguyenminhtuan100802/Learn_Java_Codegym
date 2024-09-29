package BankManagement.management;

import BankManagement.entity.Transaction;
import BankManagement.entity.User;
import BankManagement.utility.TextColor.TextColor;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement {
    public static ArrayList<User> userArrayList = new ArrayList<>();

    public static void deposit(User user) {
        System.out.print("Enter amount of money to deposit:");
        double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
        System.out.print("Enter your PIN to complete the deposit:");
        String inputPin = (new Scanner(System.in)).nextLine();

        if (user.getPin().equals(inputPin)) {
            System.out.println(TextColor.BLUE + "Deposit successfully, please check your account" + TextColor.END_COLOR);
            user.setBalance(user.getBalance() + inputAmountOfMoney);

            TransactionManagement.addTransaction(new Transaction(
                    user.getPhoneNumber(),
                    DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                    inputAmountOfMoney,
                    (user.getBalance() - inputAmountOfMoney),
                    user.getBalance(),
                    "Deposit from user"));

            saveAndLoadData();
        } else if (user.getPin().isEmpty()) {
            System.out.println(TextColor.RED + "<!> Please set up PIN for your account" + TextColor.END_COLOR);
        } else {
            System.out.println(TextColor.RED + "<!> Your PIN is wrong, please check again" + TextColor.END_COLOR);
        }
    }

    public static void withdraw(User user) {
        System.out.print("Enter amount of money to withdraw:");
        double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
        if (user.getBalance() >= inputAmountOfMoney) {
            System.out.print("Enter your PIN to complete the withdraw:");
            String inputPin = (new Scanner(System.in)).nextLine();
            if (user.getPin().equals(inputPin)) {
                System.out.println(TextColor.BLUE + "Withdraw successfully, please check your account" + TextColor.END_COLOR);
                user.setBalance(user.getBalance() - inputAmountOfMoney);

                TransactionManagement.addTransaction(new Transaction(
                        user.getPhoneNumber(),
                        DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                        inputAmountOfMoney,
                        (user.getBalance() + inputAmountOfMoney),
                        user.getBalance(),
                        "Withdraw from user"));
                saveAndLoadData();
            } else if (user.getPin().isEmpty()) {
                System.out.println(TextColor.RED + "<!> Please set up PIN for your account" + TextColor.END_COLOR);
            } else {
                System.out.println(TextColor.RED + "<!> Your PIN is wrong, please check again" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!> Your balance is not enough for withdraw" + TextColor.END_COLOR);
        }
    }

    public static void transact(User userSend) {
        System.out.print("Enter id of user you want to transact:");
        String inputId = (new Scanner(System.in)).nextLine();
        boolean isFound = false;
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getPhoneNumber().equals(inputId)) {
                isFound = true;
                System.out.println(">>" + userArrayList.get(i).getUsername());
                System.out.print("Enter amount of money to transact:");
                double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
                if (inputAmountOfMoney <= userSend.getBalance()) {
                    System.out.print("Enter your description:");
                    String inputUserSendDescription = (new Scanner(System.in)).nextLine();
                    if (inputUserSendDescription.isEmpty()) {
                        inputUserSendDescription = userSend.getFullName() + " send money";
                    }
                    System.out.print("Enter your PIN to complete the transact:");
                    String inputPin = (new Scanner(System.in)).nextLine();
                    if (inputPin.equals(userSend.getPin())) {
                        System.out.println(TextColor.BLUE + "Transact successfully, please check your account" + TextColor.END_COLOR);
                        userSend.setBalance(userSend.getBalance() - inputAmountOfMoney);
                        userArrayList.get(i).setBalance(userArrayList.get(i).getBalance() + inputAmountOfMoney);
                        TransactionManagement.addTransaction(new Transaction(
                                userSend.getId(),
                                DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                                inputAmountOfMoney,
                                (userSend.getBalance() + inputAmountOfMoney),
                                userSend.getBalance(),
                                inputUserSendDescription));

                        TransactionManagement.addTransaction(new Transaction(
                                userArrayList.get(i).getId(),
                                DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                                inputAmountOfMoney,
                                (userArrayList.get(i).getBalance() - inputAmountOfMoney),
                                userArrayList.get(i).getBalance(),
                                inputUserSendDescription));
                        saveAndLoadData();
                    } else {
                        System.out.println(TextColor.RED + "<!> Your PIN is wrong" + TextColor.END_COLOR);
                    }
                } else {
                    System.out.println(TextColor.RED + "<!> Your balance is not enough for transact" + TextColor.END_COLOR);
                }
            }
        }
        if (!isFound) {
            System.out.println(TextColor.RED + "<!> User not found" + TextColor.END_COLOR);
        }
    }

    public static void setUpPinForAccount(User user) {
        if (user.getPin().isEmpty()) {
            System.out.print("Enter the PIN you want to set up:");
            String inputNewPin = (new Scanner(System.in)).nextLine();
            System.out.print("Enter your new PIN to confirm:");
            String inputPinConfirm = (new Scanner(System.in)).nextLine();
            if (inputPinConfirm.equals(inputNewPin)) {
                System.out.println(TextColor.BLUE + "Set up PIN Successfully" + TextColor.END_COLOR);
                user.setPin(inputNewPin);
                FileManagement.saveUserToFile(userArrayList);
            } else {
                System.out.println(TextColor.RED + "<!> Your PIN confirm is wrong, please check again" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!> You already have an account PIN for your account" + TextColor.END_COLOR);
        }

    }

    public static void changePinForAccount(User user) {
        System.out.print("Enter your old PIN:");
        String inputOldPin = (new Scanner(System.in)).nextLine();
        if (inputOldPin.equals(user.getPin())) {
            System.out.print("Enter your new PIN:");
            String inputNewPin = (new Scanner(System.in)).nextLine();
            System.out.print("Enter your new PIN again to confirm:");
            String inputPinConfirm = (new Scanner(System.in)).nextLine();
            if (inputPinConfirm.equals(inputNewPin)) {
                System.out.println(TextColor.BLUE + "Your PIN change successfully" + TextColor.END_COLOR);
                user.setPin(inputNewPin);
                FileManagement.saveUserToFile(userArrayList);
            } else {
                System.out.println(TextColor.RED + "<!> Your PIN confirm is wrong, please check again" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!> Your old PIN is wrong" + TextColor.END_COLOR);
        }

    }

    public static void changePasswordForAccount(User user) {
        System.out.print("Enter your old password:");
        String inputOldPassword = (new Scanner(System.in)).nextLine();
        if (inputOldPassword.equals(user.getPassword())) {
            System.out.print("Enter your new password:");
            String inputNewPassword = (new Scanner(System.in)).nextLine();
            System.out.print("Enter your new password again to confirm:");
            String inputNewPasswordConfirm = (new Scanner(System.in)).nextLine();
            if (inputNewPasswordConfirm.equals(inputNewPassword)) {
                System.out.println(TextColor.BLUE + "Your password change successfully" + TextColor.END_COLOR);
                user.setPassword(inputNewPassword);
                FileManagement.saveUserToFile(userArrayList);
            } else {
                System.out.println(TextColor.RED + "<!> Your password confirm is wrong" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!> Your old password is wrong" + TextColor.END_COLOR);
        }

    }

    public static void showUserInformation(User user) {
        saveAndLoadData();

        System.out.println("------------------" + TextColor.BLUE + " Your Information " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-30s %-30s %-30s%n", "Full name", "Phone number", "Email", "Username", "Password");
        System.out.printf("%-20s %-15s %-30s %-30s %-30s%n",
                user.getFullName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword());
    }

    public static void showUserTransactionHistory(User user) {
        saveAndLoadData();
        System.out.println("------------------" + TextColor.BLUE + " Your Transaction History " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n", "Account", "Id transaction", "Transact", "Balance before transact", "Balance after transact", "Description");


        for (int j = 0; j < TransactionManagement.transactionArrayList.size(); j++) {
            if (TransactionManagement.transactionArrayList.get(j).getUserTransact().equals(user.getPhoneNumber())) {
                System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n",
                        TransactionManagement.transactionArrayList.get(j).getUserTransact(),
                        TransactionManagement.transactionArrayList.get(j).getId(),
                        TransactionManagement.transactionArrayList.get(j).getAmountOfTransactMoney(),
                        TransactionManagement.transactionArrayList.get(j).getBalanceBeforeTransaction(),
                        TransactionManagement.transactionArrayList.get(j).getBalanceAfterTransaction(),
                        TransactionManagement.transactionArrayList.get(j).getDescription());
            }
        }
    }

    public static void addUser() {
        System.out.print("Enter user full name:");
        String userFullName = new Scanner(System.in).nextLine();
        System.out.print("Enter user phone number:");
        String userPhoneNumber = new Scanner(System.in).nextLine();
        System.out.print("Enter user email:");
        String userEmail = new Scanner(System.in).nextLine();

        userArrayList.add(new User(userFullName, userPhoneNumber, userEmail));
        saveAndLoadData();
        System.out.println(TextColor.BLUE + "Add user successfully" + TextColor.END_COLOR);

    }

    public static void findUserByName() {
        System.out.print("Enter user's name you want to find:");
        String inputUserFullName = new Scanner(System.in).nextLine();
        System.out.println("------------------" + TextColor.BLUE + " User Found " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-15s %-30s %-30s%n", "Full name", "Phone number", "ID", "Username", "Password");
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getFullName().equals(inputUserFullName)) {
                System.out.printf("%-20s %-15s %-15s %-30s %-30s%n",
                        userArrayList.get(i).getFullName(),
                        userArrayList.get(i).getPhoneNumber(),
                        userArrayList.get(i).getId(),
                        userArrayList.get(i).getUsername(),
                        userArrayList.get(i).getPassword());
            }
        }
    }

    public static void findUserByPhoneNumber() {
        System.out.print("Enter user's phone number you want to find:");
        String inputUserPhoneNumber = new Scanner(System.in).nextLine();
        System.out.println("------------------" + TextColor.BLUE + " User Found " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-15s %-30s %-30s%n", "Full name", "Phone number", "ID", "Username", "Password");
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getFullName().equals(inputUserPhoneNumber)) {
                System.out.printf("%-20s %-15s %-15s %-30s %-30s%n",
                        userArrayList.get(i).getFullName(),
                        userArrayList.get(i).getPhoneNumber(),
                        userArrayList.get(i).getId(),
                        userArrayList.get(i).getUsername(),
                        userArrayList.get(i).getPassword());
            }
        }
    }

    public static void editUser(User user) {
    }

    public static void deleteUser(User user) {
    }

    public static void showAllUsers() {
        userArrayList = FileManagement.loadUserFromFile();

        System.out.println("------------------" + TextColor.BLUE + " User List " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-30s %-30s %-30s%n",
                "Full name", "Phone number", "Email", "Username", "Password");
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.printf("%-20s %-15s %-30s %-30s %-30s%n",
                    userArrayList.get(i).getFullName(),
                    userArrayList.get(i).getPhoneNumber(),
                    userArrayList.get(i).getEmail(),
                    userArrayList.get(i).getUsername(),
                    userArrayList.get(i).getPassword());
        }
    }

    public static void deleteAllUsers() {
        System.out.print("Do you want to delete all users? (Y/N):");
        String inputAnswer = (new Scanner(System.in)).nextLine();
        if (inputAnswer.equals("Y")) {
            userArrayList.clear();
            saveAndLoadData();
            System.out.println(TextColor.BLUE + "Delete all users successfully" + TextColor.END_COLOR);
        }
    }

    public static void showAllUserTransactionsHistory() {
        saveAndLoadData();

        System.out.println("------------------" + TextColor.BLUE + " All User Transaction History " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n", "Account", "Id transaction", "Transact", "Balance before transact", "Balance after transact", "Description");

        for (int j = 0; j < TransactionManagement.transactionArrayList.size(); j++) {
            System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n",
                    TransactionManagement.transactionArrayList.get(j).getUserTransact(),
                    TransactionManagement.transactionArrayList.get(j).getId(),
                    TransactionManagement.transactionArrayList.get(j).getAmountOfTransactMoney(),
                    TransactionManagement.transactionArrayList.get(j).getBalanceBeforeTransaction(),
                    TransactionManagement.transactionArrayList.get(j).getBalanceAfterTransaction(),
                    TransactionManagement.transactionArrayList.get(j).getDescription());
        }

    }

    public static void saveAndLoadData() {
        FileManagement.saveUserToFile(userArrayList);
        userArrayList = FileManagement.loadUserFromFile();
        FileManagement.saveTransactionToFile(TransactionManagement.transactionArrayList);
        TransactionManagement.transactionArrayList = FileManagement.loadTransactionFromFile();

    }

}
