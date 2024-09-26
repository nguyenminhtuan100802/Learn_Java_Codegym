package BankManagement.service;

import BankManagement.model.Transaction;
import BankManagement.model.User;
import BankManagement.variable.Choice.Choice;
import BankManagement.variable.TextColor.TextColor;
import BankManagement.variable.ChoiceFromUser.AdminChoiceFind;
import BankManagement.variable.ChoiceFromUser.UserChoiceHome;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void login(TransactionService transactionService) {
        boolean isFoundUser = false;
        System.out.print("Enter your username:");
        String username = (new Scanner(System.in)).nextLine();
        System.out.print("Enter your password:");
        String password = (new Scanner(System.in)).nextLine();
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getUsername().equals(username) && userArrayList.get(i).getPassword().equals(password)) {
                isFoundUser = true;
                System.out.println(TextColor.BLUE + "Welcome " + userArrayList.get(i).getFullName() + TextColor.END_COLOR);
                while (true) {
                    boolean isExit = false;
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
                    Choice.home = new Scanner(System.in).nextInt();
                    switch (Choice.home) {
                        case UserChoiceHome.DEPOSIT_MONEY:
                            this.deposit(userArrayList.get(i), transactionService);
                            break;
                        case UserChoiceHome.WITHDRAW_MONEY:
                            this.withdraw(userArrayList.get(i), transactionService);
                            break;
                        case UserChoiceHome.TRANSACT_MONEY:
                            break;
                        case UserChoiceHome.SET_UP_PIN_ACCOUNT:
                            this.setUpPinForAccount(userArrayList.get(i));
                            break;
                        case UserChoiceHome.CHANGE_PIN_ACCOUNT:
                            this.changePinForAccount(userArrayList.get(i));
                            break;
                        case UserChoiceHome.CHANGE_PASSWORD:
                            break;
                        case UserChoiceHome.SHOW_USER_INFORMATION:
                            this.showUserInformation(userArrayList.get(i), transactionService);
                            break;
                        case UserChoiceHome.SHOW_TRANSACTION_HISTORY:
                            this.showUserTransactionHistory(userArrayList.get(i), transactionService);
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

    private void deposit(User user, TransactionService transactionService) {
        System.out.print("Enter amount of money to deposit:");
        double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
        System.out.print("Enter your PIN to complete the deposit:");
        String inputPin = (new Scanner(System.in)).nextLine();

        if (user.getPin().equals(inputPin)) {
            System.out.println(TextColor.BLUE + "Deposit successfully, please check your account" + TextColor.END_COLOR);
            user.setBalance(user.getBalance() + inputAmountOfMoney);

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy");
            transactionService.addTransaction(new Transaction(
                    user.getPhoneNumber(),
                    myFormatObj.format(myDateObj),
                    inputAmountOfMoney,
                    (user.getBalance() - inputAmountOfMoney),
                    user.getBalance(),
                    "Deposit from user"));

            this.saveAndLoadData(transactionService);

        } else if (user.getPin().isEmpty()) {
            System.out.println(TextColor.RED + "<!>Please set up PIN for your account" + TextColor.END_COLOR);
        } else {
            System.out.println(TextColor.RED + "<!>Your PIN is wrong, please check again" + TextColor.END_COLOR);
        }
    }

    private void withdraw(User user, TransactionService transactionService) {
        System.out.print("Enter amount of money to withdraw:");
        double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
        if (user.getBalance() >= inputAmountOfMoney) {
            System.out.print("Enter your PIN to complete the withdraw:");
            String inputPin = (new Scanner(System.in)).nextLine();
            if (user.getPin().equals(inputPin)) {
                System.out.println(TextColor.BLUE + "Withdraw successfully, please check your account" + TextColor.END_COLOR);
                user.setBalance(user.getBalance() - inputAmountOfMoney);

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy");
                transactionService.addTransaction(new Transaction(
                        user.getPhoneNumber(),
                        myFormatObj.format(myDateObj),
                        inputAmountOfMoney,
                        (user.getBalance() + inputAmountOfMoney),
                        user.getBalance(),
                        "Withdraw from user"));
                this.saveAndLoadData(transactionService);
            } else if (user.getPin().isEmpty()) {
                System.out.println(TextColor.RED + "<!>Please set up PIN for your account" + TextColor.END_COLOR);
            } else {
                System.out.println(TextColor.RED + "<!>Your PIN is wrong, please check again" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!>Your balance is not enough for withdraw" + TextColor.END_COLOR);
        }
    }

    private void setUpPinForAccount(User user) {
        if (user.getPin().isEmpty()) {
            System.out.print("Enter the PIN you want to set up:");
            String inputNewPin = (new Scanner(System.in)).nextLine();
            System.out.print("Enter your new PIN to confirm:");
            String inputPinConfirm = (new Scanner(System.in)).nextLine();
            if (inputPinConfirm.equals(inputNewPin)) {
                System.out.println(TextColor.BLUE + "Set up PIN Successfully" + TextColor.END_COLOR);
                user.setPin(inputNewPin);
                FileService.saveUserToFile(userArrayList);
            } else {
                System.out.println(TextColor.RED + "<!>Your PIN confirm is wrong, please check again" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!>You already have an account PIN for your account" + TextColor.END_COLOR);
        }
    }

    private void changePinForAccount(User user) {
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
                FileService.saveUserToFile(userArrayList);
            } else {
                System.out.println(TextColor.RED + "<!>Your PIN confirm is wrong, please check again" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!>Your PIN is not match with the old you set" + TextColor.END_COLOR);
        }
    }

    private void showUserInformation(User user, TransactionService transactionService) {
        this.saveAndLoadData(transactionService);

        System.out.println("------------------" + TextColor.BLUE + " Your Information " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-30s %-30s%n",
                "Full name", "Phone number", "Username", "Password");
        System.out.printf("%-20s %-15s %-30s %-30s%n",
                user.getFullName(),
                user.getPhoneNumber(),
                user.getUsername(),
                user.getPassword());
    }

    private void showUserTransactionHistory(User user, TransactionService transactionService) {
        this.saveAndLoadData(transactionService);

        System.out.println("------------------" + TextColor.BLUE + " Your Transaction History " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n", "Account", "Id transaction", "Transact", "Balance before transact", "Balance after transact", "Description");

        for (int j = 0; j < transactionService.getTransactions().size(); j++) {
            if (transactionService.getTransactions().get(j).getUserTransact().equals(user.getPhoneNumber())){
                System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n",
                        transactionService.getTransactions().get(j).getUserTransact(),
                        transactionService.getTransactions().get(j).getId(),
                        transactionService.getTransactions().get(j).getAmountOfTransactMoney(),
                        transactionService.getTransactions().get(j).getBalanceBeforeTransaction(),
                        transactionService.getTransactions().get(j).getBalanceAfterTransaction(),
                        transactionService.getTransactions().get(j).getDescription());
            }
        }
    }

    public void addUser(TransactionService transactionService) {
        userArrayList.add(this.createNewUser());
        this.saveAndLoadData(transactionService);
        System.out.println(TextColor.BLUE + "Add user successfully" + TextColor.END_COLOR);
    }

    public void findUser() {
        while (true) {
            boolean isExist = false;
            System.out.println("=================" + TextColor.YELLOW + " LOGIN > HOME (Admin) > FIND USER (Admin) " + TextColor.END_COLOR + "=================");
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

        System.out.println("------------------" + TextColor.BLUE + " User List " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-30s %-30s%n",
                "Full name", "Phone number", "Username", "Password");
        for (int i = 0; i < this.userArrayList.size(); i++) {
            System.out.printf("%-20s %-15s %-30s %-30s%n",
                    this.userArrayList.get(i).getFullName(),
                    this.userArrayList.get(i).getPhoneNumber(),
                    this.userArrayList.get(i).getUsername(),
                    this.userArrayList.get(i).getPassword());
        }
    }

    public void deleteAllUsers(TransactionService transactionService) {
        System.out.print("Do you want to delete all users? (Y/N):");
        String inputAnswer = (new Scanner(System.in)).nextLine();
        if (inputAnswer.equals("Y")) {
            userArrayList.clear();
            this.saveAndLoadData(transactionService);
            System.out.println(TextColor.BLUE + "Delete all users successfully" + TextColor.END_COLOR);
        }
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

    public void showAllUserTransactionsHistory(TransactionService transactionService) {
        this.saveAndLoadData(transactionService);

        System.out.println("------------------" + TextColor.BLUE + " All User Transaction History " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n", "Account", "Id transaction", "Transact", "Balance before transact", "Balance after transact", "Description");

        for (int j = 0; j < transactionService.getTransactions().size(); j++) {
            System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n",
                    transactionService.getTransactions().get(j).getUserTransact(),
                    transactionService.getTransactions().get(j).getId(),
                    transactionService.getTransactions().get(j).getAmountOfTransactMoney(),
                    transactionService.getTransactions().get(j).getBalanceBeforeTransaction(),
                    transactionService.getTransactions().get(j).getBalanceAfterTransaction(),
                    transactionService.getTransactions().get(j).getDescription());
    }

    }
    public void saveAndLoadData(TransactionService transactionService){
        FileService.saveUserToFile(userArrayList);
        userArrayList = FileService.loadUserFromFile();
        FileService.saveTransactionToFile(transactionService);
        transactionService.setTransactions(FileService.loadTransactionFromFile());

    }

}
