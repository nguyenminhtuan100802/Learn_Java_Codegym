package BankManagement.management;

import BankManagement.entity.Language;
import BankManagement.entity.Transaction;
import BankManagement.entity.User;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.TextColor.TextColor;
import BankManagement.utility.ChoiceFromUser.AdminChoiceFind;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement {
    private ArrayList<User> userArrayList;

    public UserManagement() {
        userArrayList = new ArrayList<>();
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public void deposit(User user, TransactionManagement transactionManagement) {
        if (Language.languageName.equals("English")){
            System.out.print("Enter amount of money to deposit:");
            double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
            System.out.print("Enter your PIN to complete the deposit:");
            String inputPin = (new Scanner(System.in)).nextLine();

            if (user.getPin().equals(inputPin)) {
                System.out.println(TextColor.BLUE + "Deposit successfully, please check your account" + TextColor.END_COLOR);
                user.setBalance(user.getBalance() + inputAmountOfMoney);

                transactionManagement.addTransaction(new Transaction(
                        user.getPhoneNumber(),
                        DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                        inputAmountOfMoney,
                        (user.getBalance() - inputAmountOfMoney),
                        user.getBalance(),
                        "Deposit from user"));

                this.saveAndLoadData(transactionManagement);
            } else if (user.getPin().isEmpty()) {
                System.out.println(TextColor.RED + "<!> Please set up PIN for your account" + TextColor.END_COLOR);
            } else {
                System.out.println(TextColor.RED + "<!> Your PIN is wrong, please check again" + TextColor.END_COLOR);
            }
        }
        else if (Language.languageName.equals("Vietnamese")){
            System.out.print("Nhập số tiền bạn muốn gửi:");
            double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
            System.out.print("Nhập mã PIN của bạn để hoàn tất việc gửi tiền:");
            String inputPin = (new Scanner(System.in)).nextLine();

            if (user.getPin().equals(inputPin)) {
                System.out.println(TextColor.BLUE + "Gửi tiền thành công, vui lòng kiểm tra tài khoản của bạn" + TextColor.END_COLOR);
                user.setBalance(user.getBalance() + inputAmountOfMoney);

                transactionManagement.addTransaction(new Transaction(
                        user.getPhoneNumber(),
                        DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                        inputAmountOfMoney,
                        (user.getBalance() - inputAmountOfMoney),
                        user.getBalance(),
                        "Deposit from user"));

                this.saveAndLoadData(transactionManagement);
            } else if (user.getPin().isEmpty()) {
                System.out.println(TextColor.RED + "<!> Vui lòng thiết lập mã PIN cho tài khoản của bạn" + TextColor.END_COLOR);
            } else {
                System.out.println(TextColor.RED + "<!> Mã PIN của bạn sai, vui lòng kiểm tra lại" + TextColor.END_COLOR);
            }
        }
    }

    public void withdraw(User user, TransactionManagement transactionManagement) {
        if (Language.languageName.equals("English")){
            System.out.print("Enter amount of money to withdraw:");
            double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
            if (user.getBalance() >= inputAmountOfMoney) {
                System.out.print("Enter your PIN to complete the withdraw:");
                String inputPin = (new Scanner(System.in)).nextLine();
                if (user.getPin().equals(inputPin)) {
                    System.out.println(TextColor.BLUE + "Withdraw successfully, please check your account" + TextColor.END_COLOR);
                    user.setBalance(user.getBalance() - inputAmountOfMoney);

                    transactionManagement.addTransaction(new Transaction(
                            user.getPhoneNumber(),
                            DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                            inputAmountOfMoney,
                            (user.getBalance() + inputAmountOfMoney),
                            user.getBalance(),
                            "Withdraw from user"));
                    this.saveAndLoadData(transactionManagement);
                } else if (user.getPin().isEmpty()) {
                    System.out.println(TextColor.RED + "<!> Please set up PIN for your account" + TextColor.END_COLOR);
                } else {
                    System.out.println(TextColor.RED + "<!> Your PIN is wrong, please check again" + TextColor.END_COLOR);
                }
            } else {
                System.out.println(TextColor.RED + "<!> Your balance is not enough for withdraw" + TextColor.END_COLOR);
            }
        }
        else if (Language.languageName.equals("Vietnamese")){
            System.out.print("Nhập số tiền bạn muốn rút:");
            double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
            if (user.getBalance() >= inputAmountOfMoney) {
                System.out.print("Nhập mã PIN của bạn để hoàn tất việc rút tiền:");
                String inputPin = (new Scanner(System.in)).nextLine();
                if (user.getPin().equals(inputPin)) {
                    System.out.println(TextColor.BLUE + "Rút tiền thành công, vui lòng kiểm tra tài khoản của bạn" + TextColor.END_COLOR);
                    user.setBalance(user.getBalance() - inputAmountOfMoney);

                    transactionManagement.addTransaction(new Transaction(
                            user.getPhoneNumber(),
                            DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                            inputAmountOfMoney,
                            (user.getBalance() + inputAmountOfMoney),
                            user.getBalance(),
                            "Withdraw from user"));
                    this.saveAndLoadData(transactionManagement);
                } else if (user.getPin().isEmpty()) {
                    System.out.println(TextColor.RED + "<!> Vui lòng thiết lập mã PIN cho tài khoản của bạn" + TextColor.END_COLOR);
                } else {
                    System.out.println(TextColor.RED + "<!> Mã PIN của bạn sai, vui lòng kiểm tra lại" + TextColor.END_COLOR);
                }
            } else {
                System.out.println(TextColor.RED + "<!> Số dư của bạn không đủ để rút" + TextColor.END_COLOR);
            }
        }
    }

    public void transact(User userSend, TransactionManagement transactionManagement) {
        if (Language.languageName.equals("English")){
            System.out.print("Enter id of user you want to transact:");
            String inputId = (new Scanner(System.in)).nextLine();
            boolean isFound = false;
            for (int i = 0; i < userArrayList.size(); i++) {
                if (userArrayList.get(i).getPhoneNumber().equals(inputId)) {
                    isFound = true;
                    System.out.println(">>" + userArrayList.get(i).getUsername());
                    System.out.print("Enter amount of money to transact:");
                    double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
                    if (inputAmountOfMoney <= userSend.getBalance()){
                        System.out.print("Enter your description:");
                        String inputUserSendDescription = (new Scanner(System.in)).nextLine();
                        if (inputUserSendDescription.isEmpty()){
                            inputUserSendDescription = userSend.getFullName() + " send money";
                        }
                        System.out.print("Enter your PIN to complete the transact:");
                        String inputPin = (new Scanner(System.in)).nextLine();
                        if (inputPin.equals(userSend.getPin())) {
                            System.out.println(TextColor.BLUE + "Transact successfully, please check your account" + TextColor.END_COLOR);
                            userSend.setBalance(userSend.getBalance() - inputAmountOfMoney);
                            userArrayList.get(i).setBalance(userArrayList.get(i).getBalance() + inputAmountOfMoney);
                            transactionManagement.addTransaction(new Transaction(
                                    userSend.getId(),
                                    DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                                    inputAmountOfMoney,
                                    (userSend.getBalance() + inputAmountOfMoney),
                                    userSend.getBalance(),
                                    inputUserSendDescription));

                            transactionManagement.addTransaction(new Transaction(
                                    userArrayList.get(i).getId(),
                                    DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                                    inputAmountOfMoney,
                                    (userArrayList.get(i).getBalance() - inputAmountOfMoney),
                                    userArrayList.get(i).getBalance(),
                                    inputUserSendDescription));
                            this.saveAndLoadData(transactionManagement);
                        }
                        else {
                            System.out.println(TextColor.RED + "<!> Your PIN is wrong" + TextColor.END_COLOR);
                        }
                    }
                    else {
                        System.out.println(TextColor.RED + "<!> Your balance is not enough for transact" + TextColor.END_COLOR);
                    }
                }
            }
            if (!isFound) {
                System.out.println(TextColor.RED + "<!> User not found" + TextColor.END_COLOR);
            }
        }
        else if (Language.languageName.equals("Vietnamese")){
            System.out.print("Nhập mã người dùng bạn muốn giao dịch:");
            String inputId = (new Scanner(System.in)).nextLine();
            boolean isFound = false;
            for (int i = 0; i < userArrayList.size(); i++) {
                if (userArrayList.get(i).getPhoneNumber().equals(inputId)) {
                    isFound = true;
                    System.out.println(">>" + userArrayList.get(i).getUsername());
                    System.out.print("Nhập số tiền bạn muốn giao dịch:");
                    double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
                    if (inputAmountOfMoney <= userSend.getBalance()) {
                        System.out.println("Nhập mô tả cho giao dịch của bạn:");
                        String inputUserSendDescription = (new Scanner(System.in)).nextLine();
                        if (inputUserSendDescription.isEmpty()){
                            inputUserSendDescription = userSend.getFullName() + " send money";
                        }
                        System.out.println("Nhập mã PIN để hoàn tất giao dịch:");
                        String inputPin = (new Scanner(System.in)).nextLine();
                        if (inputPin.equals(userSend.getPin())) {
                            System.out.println(TextColor.BLUE + "Giao dịch thành công, vui lòng kiểm tra tài khoản của bạn" + TextColor.END_COLOR);
                            userSend.setBalance(userSend.getBalance() - inputAmountOfMoney);
                            userArrayList.get(i).setBalance(userArrayList.get(i).getBalance() + inputAmountOfMoney);
                            transactionManagement.addTransaction(new Transaction(
                                    userSend.getId(),
                                    DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                                    inputAmountOfMoney,
                                    (userSend.getBalance() + inputAmountOfMoney),
                                    userSend.getBalance(),
                                    inputUserSendDescription));

                            transactionManagement.addTransaction(new Transaction(
                                    userArrayList.get(i).getId(),
                                    DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                                    inputAmountOfMoney,
                                    (userArrayList.get(i).getBalance() - inputAmountOfMoney),
                                    userArrayList.get(i).getBalance(),
                                    inputUserSendDescription));
                            this.saveAndLoadData(transactionManagement);
                        } else {
                            System.out.println(TextColor.RED + "<!>Mã PIN của bạn sai" + TextColor.END_COLOR);
                        }
                    } else {
                        System.out.println(TextColor.RED + "<!> Số dư của bạn không đủ để thực hiện giao dịch" + TextColor.END_COLOR);
                    }
                }
            }
            if (!isFound) {
                System.out.println(TextColor.RED + "<!> Không tìm thấy người dùng" + TextColor.END_COLOR);
            }
        }
    }
    public void setUpPinForAccount(User user) {
        if (Language.languageName.equals("English")){
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
        else if (Language.languageName.equals("Vietnamese")){
            if (user.getPin().isEmpty()) {
                System.out.print("Nhập mã PIN bạn muốn thiết lập:");
                String inputNewPin = (new Scanner(System.in)).nextLine();
                System.out.print("Nhập mã PIN mới của bạn để xác nhận:");
                String inputPinConfirm = (new Scanner(System.in)).nextLine();
                if (inputPinConfirm.equals(inputNewPin)) {
                    System.out.println(TextColor.BLUE + "Thiết lập mã PIN thành công" + TextColor.END_COLOR);
                    user.setPin(inputNewPin);
                    FileManagement.saveUserToFile(userArrayList);
                } else {
                    System.out.println(TextColor.RED + "<!> Xác nhận mã PIN của bạn không đúng, vui lòng kiểm tra lại" + TextColor.END_COLOR);
                }
            } else {
                System.out.println(TextColor.RED + "<!> Bạn đã có mã PIN cho tài khoản của mình" + TextColor.END_COLOR);
            }
        }
    }

    public void changePinForAccount(User user) {
        if (Language.languageName.equals("English")){
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
        else if (Language.languageName.equals("Vietnamese")){
            System.out.print("Nhập mã PIN cũ của bạn:");
            String inputOldPin = (new Scanner(System.in)).nextLine();
            if (inputOldPin.equals(user.getPin())) {
                System.out.print("Nhập mã PIN mới của bạn:");
                String inputNewPin = (new Scanner(System.in)).nextLine();
                System.out.print("Nhập mã PIN mới của bạn một lần nữa để xác nhận:");
                String inputPinConfirm = (new Scanner(System.in)).nextLine();
                if (inputPinConfirm.equals(inputNewPin)) {
                    System.out.println(TextColor.BLUE + "Bạn đã thay đổi mã PIN thành công" + TextColor.END_COLOR);
                    user.setPin(inputNewPin);
                    FileManagement.saveUserToFile(userArrayList);
                } else {
                    System.out.println(TextColor.RED + "<!> Xác nhận mã PIN của bạn không đúng, vui lòng kiểm tra lại" + TextColor.END_COLOR);
                }
            } else {
                System.out.println(TextColor.RED + "<!> Mã PIN cũ của bạn không đúng" + TextColor.END_COLOR);
            }
        }
    }

    public void changePasswordForAccount(User user) {
        if (Language.languageName.equals("English")){
            System.out.print("Enter your old password:");
            String inputOldPassword = (new Scanner(System.in)).nextLine();
            if (inputOldPassword.equals(user.getPassword())){
                System.out.print("Enter your new password:");
                String inputNewPassword = (new Scanner(System.in)).nextLine();
                System.out.print("Enter your new password again to confirm:");
                String inputNewPasswordConfirm = (new Scanner(System.in)).nextLine();
                if (inputNewPasswordConfirm.equals(inputNewPassword)) {
                    System.out.println(TextColor.BLUE + "Your password change successfully" + TextColor.END_COLOR);
                    user.setPassword(inputNewPassword);
                    FileManagement.saveUserToFile(userArrayList);
                }
                else {
                    System.out.println(TextColor.RED + "<!> Your password confirm is wrong" + TextColor.END_COLOR);
                }
            }
            else {
                System.out.println(TextColor.RED + "<!> Your old password is wrong" + TextColor.END_COLOR);
            }
        }
        else if (Language.languageName.equals("Vietnamese")){
            System.out.print("Nhập mật khẩu cũ của bạn:");
            String inputOldPassword = (new Scanner(System.in)).nextLine();
            if (inputOldPassword.equals(user.getPassword())) {
                System.out.print("Nhập mật khẩu mới của bạn:");
                String inputNewPassword = (new Scanner(System.in)).nextLine();
                System.out.print("Nhập mật khẩu mới của bạn một lần nữa để xác nhận:");
                String inputNewPasswordConfirm = (new Scanner(System.in)).nextLine();
                if (inputNewPasswordConfirm.equals(inputNewPassword)) {
                    System.out.println(TextColor.BLUE + "Bạn đã thay đổi mật khẩu thành công" + TextColor.END_COLOR);
                    user.setPassword(inputNewPassword);
                    FileManagement.saveUserToFile(userArrayList);
                } else {
                    System.out.println(TextColor.RED + "<!> Xác nhận mật khẩu của bạn không đúng" + TextColor.END_COLOR);
                }
            } else {
                System.out.println(TextColor.RED + "<!> Mật khẩu cũ của bạn không đúng" + TextColor.END_COLOR);
            }
        }
    }

    public void showUserInformation(User user, TransactionManagement transactionManagement) {
        this.saveAndLoadData(transactionManagement);

        System.out.println("------------------" + TextColor.BLUE + " Your Information " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-30s %-30s%n",
                "Full name", "Phone number", "Username", "Password");
        System.out.printf("%-20s %-15s %-30s %-30s%n",
                user.getFullName(),
                user.getPhoneNumber(),
                user.getUsername(),
                user.getPassword());
    }

    public void showUserTransactionHistory(User user, TransactionManagement transactionManagement) {
        this.saveAndLoadData(transactionManagement);

        System.out.println("------------------" + TextColor.BLUE + " Your Transaction History " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n", "Account", "Id transaction", "Transact", "Balance before transact", "Balance after transact", "Description");

        for (int j = 0; j < transactionManagement.getTransactions().size(); j++) {
            if (transactionManagement.getTransactions().get(j).getUserTransact().equals(user.getPhoneNumber())){
                System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n",
                        transactionManagement.getTransactions().get(j).getUserTransact(),
                        transactionManagement.getTransactions().get(j).getId(),
                        transactionManagement.getTransactions().get(j).getAmountOfTransactMoney(),
                        transactionManagement.getTransactions().get(j).getBalanceBeforeTransaction(),
                        transactionManagement.getTransactions().get(j).getBalanceAfterTransaction(),
                        transactionManagement.getTransactions().get(j).getDescription());
            }
        }
    }

    public void addUser(TransactionManagement transactionManagement) {
        System.out.print("Enter user full name:");
        String userFullName = new Scanner(System.in).nextLine();
        System.out.print("Enter user phone number:");
        String userPhoneNumber = new Scanner(System.in).nextLine();

        userArrayList.add(new User(userFullName, userPhoneNumber));
        this.saveAndLoadData(transactionManagement);
        System.out.println(TextColor.BLUE + "Add user successfully" + TextColor.END_COLOR);
    }
    public void findUserByName() {
        System.out.print("Enter user's name you want to find:");
        String inputUserFullName = new Scanner(System.in).nextLine();
        System.out.println("------------------" + TextColor.BLUE + " User Found " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-15s %-30s %-30s%n", "Full name", "Phone number", "ID", "Username", "Password");
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getFullName().equals(inputUserFullName)) {
                System.out.printf("%-20s %-15s %-15s %-30s %-30s%n",
                        this.userArrayList.get(i).getFullName(),
                        this.userArrayList.get(i).getPhoneNumber(),
                        this.userArrayList.get(i).getId(),
                        this.userArrayList.get(i).getUsername(),
                        this.userArrayList.get(i).getPassword());
            }
        }
    }

    public void findUserByPhoneNumber() {
        System.out.print("Enter user's phone number you want to find:");
        String inputUserPhoneNumber = new Scanner(System.in).nextLine();
        System.out.println("------------------" + TextColor.BLUE + " User Found " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-15s %-30s %-30s%n", "Full name", "Phone number", "ID", "Username", "Password");
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getFullName().equals(inputUserPhoneNumber)) {
                System.out.printf("%-20s %-15s %-15s %-30s %-30s%n",
                        this.userArrayList.get(i).getFullName(),
                        this.userArrayList.get(i).getPhoneNumber(),
                        this.userArrayList.get(i).getId(),
                        this.userArrayList.get(i).getUsername(),
                        this.userArrayList.get(i).getPassword());
            }
        }
    }

    public void editUser(User user) {
    }

    public void deleteUser(User user) {
    }

    public void showAllUsers() {
        userArrayList = FileManagement.loadUserFromFile();

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

    public void deleteAllUsers(TransactionManagement transactionManagement) {
        System.out.print("Do you want to delete all users? (Y/N):");
        String inputAnswer = (new Scanner(System.in)).nextLine();
        if (inputAnswer.equals("Y")) {
            userArrayList.clear();
            this.saveAndLoadData(transactionManagement);
            System.out.println(TextColor.BLUE + "Delete all users successfully" + TextColor.END_COLOR);
        }
    }

    public void showAllUserTransactionsHistory(TransactionManagement transactionManagement) {
        this.saveAndLoadData(transactionManagement);

        System.out.println("------------------" + TextColor.BLUE + " All User Transaction History " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n", "Account", "Id transaction", "Transact", "Balance before transact", "Balance after transact", "Description");

        for (int j = 0; j < transactionManagement.getTransactions().size(); j++) {
            System.out.printf("%-10s %-35s %-15s %-30s %-30s %-40s%n",
                    transactionManagement.getTransactions().get(j).getUserTransact(),
                    transactionManagement.getTransactions().get(j).getId(),
                    transactionManagement.getTransactions().get(j).getAmountOfTransactMoney(),
                    transactionManagement.getTransactions().get(j).getBalanceBeforeTransaction(),
                    transactionManagement.getTransactions().get(j).getBalanceAfterTransaction(),
                    transactionManagement.getTransactions().get(j).getDescription());
    }

    }
    public void saveAndLoadData(TransactionManagement transactionManagement){
        FileManagement.saveUserToFile(userArrayList);
        userArrayList = FileManagement.loadUserFromFile();
        FileManagement.saveTransactionToFile(transactionManagement);
        transactionManagement.setTransactions(FileManagement.loadTransactionFromFile());

    }

}
