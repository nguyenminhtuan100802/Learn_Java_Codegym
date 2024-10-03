package BankManagement.management;

import BankManagement.entity.Transaction;
import BankManagement.entity.User;
import BankManagement.management.FileManagement.FileTransactionManagement;
import BankManagement.management.FileManagement.FileUserManagement;
import BankManagement.utility.TextColor.TextColor;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
    private static List<User> userList = new ArrayList<>();

    public static List<User> getUserArrayList() {
        return userList;
    }

    public static void setUserArrayList(List<User> userList) {
        UserManagement.userList = userList;
    }

    public static User verifyLogin() {
        System.out.print("Enter your username:");
        String username = (new Scanner(System.in)).nextLine();
        System.out.print("Enter your password:");
        String password = (new Scanner(System.in)).nextLine();

        for (int i = 0; i < userList.size(); i++) {
            if (UserManagement.getUserArrayList().get(i).getUsername().equals(username) && UserManagement.getUserArrayList().get(i).getPassword().equals(password)) {
                System.out.println(TextColor.BLUE + "Welcome " + UserManagement.getUserArrayList().get(i).getFullName() + TextColor.END_COLOR);
                return UserManagement.getUserArrayList().get(i);
            }
        }
        System.out.println(TextColor.RED + "<!> Tên đăng nhập hoặc mật khẩu không đúng!" + TextColor.END_COLOR);
        return null;
    }
    public static void deposit(User user) {
        System.out.print("Nhập số tiền bạn muốn gửi: ");
        double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
        System.out.print("Nhập mã PIN của bạn để hoàn tất giao dịch: ");
        String inputPin = (new Scanner(System.in)).nextLine();

        if (user.getPin().equals(inputPin)) {
            System.out.println(TextColor.BLUE + "Gửi tiền thành công, vui lòng kiểm tra tài khoản của bạn" + TextColor.END_COLOR);
            user.setBalance(user.getBalance() + inputAmountOfMoney);

            TransactionManagement.addTransaction(new Transaction(
                    user.getPhoneNumber(),
                    DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                    inputAmountOfMoney,
                    (user.getBalance() - inputAmountOfMoney),
                    user.getBalance(),
                    "Gửi tiền từ người dùng"));

            saveAndLoadData();
        } else if (user.getPin().isEmpty()) {
            System.out.println(TextColor.RED + "<!> Vui lòng thiết lập mã PIN cho tài khoản của bạn" + TextColor.END_COLOR);
        } else {
            System.out.println(TextColor.RED + "<!> Mã PIN của bạn không đúng, vui lòng kiểm tra lại" + TextColor.END_COLOR);
        }
    }


    public static void withdraw(User user) {
        System.out.print("Nhập số tiền bạn muốn rút: ");
        double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
        if (user.getBalance() >= inputAmountOfMoney) {
            System.out.print("Nhập mã PIN của bạn để hoàn tất giao dịch: ");
            String inputPin = (new Scanner(System.in)).nextLine();
            if (user.getPin().equals(inputPin)) {
                System.out.println(TextColor.BLUE + "Rút tiền thành công, vui lòng kiểm tra tài khoản của bạn" + TextColor.END_COLOR);
                user.setBalance(user.getBalance() - inputAmountOfMoney);

                TransactionManagement.addTransaction(new Transaction(
                        user.getPhoneNumber(),
                        DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                        inputAmountOfMoney,
                        (user.getBalance() + inputAmountOfMoney),
                        user.getBalance(),
                        "Rút tiền từ người dùng"));
                saveAndLoadData();
            } else if (user.getPin().isEmpty()) {
                System.out.println(TextColor.RED + "<!> Vui lòng thiết lập mã PIN cho tài khoản của bạn" + TextColor.END_COLOR);
            } else {
                System.out.println(TextColor.RED + "<!> Mã PIN của bạn không đúng, vui lòng kiểm tra lại" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!> Số dư của bạn không đủ để thực hiện giao dịch" + TextColor.END_COLOR);
        }
    }

    public static void transact(User userSend) {
        System.out.print("Nhập mã số người dùng bạn muốn giao dịch: ");
        String inputId = (new Scanner(System.in)).nextLine();
        boolean isFound = false;
        for (User user : userList) {
            if (user.getPhoneNumber().equals(inputId)) {
                isFound = true;
                System.out.println(">>" + user.getUsername());
                System.out.print("Nhập số tiền bạn muốn chuyển: ");
                double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
                if (inputAmountOfMoney <= userSend.getBalance()) {
                    System.out.print("Nhập mô tả cho giao dịch: ");
                    String inputUserSendDescription = (new Scanner(System.in)).nextLine();
                    if (inputUserSendDescription.isEmpty()) {
                        inputUserSendDescription = userSend.getFullName() + " gửi tiền";
                    }
                    System.out.print("Nhập mã PIN của bạn để hoàn tất giao dịch: ");
                    String inputPin = (new Scanner(System.in)).nextLine();
                    if (inputPin.equals(userSend.getPin())) {
                        System.out.println(TextColor.BLUE + "Giao dịch thành công, vui lòng kiểm tra tài khoản của bạn" + TextColor.END_COLOR);
                        userSend.setBalance(userSend.getBalance() - inputAmountOfMoney);
                        user.setBalance(user.getBalance() + inputAmountOfMoney);

                        TransactionManagement.addTransaction(new Transaction(
                                userSend.getId(),
                                DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                                inputAmountOfMoney,
                                (userSend.getBalance() + inputAmountOfMoney),
                                userSend.getBalance(),
                                inputUserSendDescription));

                        TransactionManagement.addTransaction(new Transaction(
                                user.getId(),
                                DateTimeFormatter.ofPattern("HH:mm:ss,dd/MM/yyyy").format(LocalDateTime.now()),
                                inputAmountOfMoney,
                                (user.getBalance() - inputAmountOfMoney),
                                user.getBalance(),
                                inputUserSendDescription));
                        saveAndLoadData();
                    } else {
                        System.out.println(TextColor.RED + "<!> Mã PIN của bạn không đúng" + TextColor.END_COLOR);
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


    public static void setUpPinForAccount(User user) {
        if (user.getPin().isEmpty()) {
            System.out.print("Nhập mã PIN bạn muốn thiết lập: ");
            String inputNewPin = (new Scanner(System.in)).nextLine();
            System.out.print("Nhập lại mã PIN của bạn để xác nhận: ");
            String inputPinConfirm = (new Scanner(System.in)).nextLine();
            if (inputPinConfirm.equals(inputNewPin)) {
                System.out.println(TextColor.BLUE + "Thiết lập mã PIN thành công" + TextColor.END_COLOR);
                user.setPin(inputNewPin);
                saveAndLoadData();
            } else {
                System.out.println(TextColor.RED + "<!> Mã xác nhận không đúng, vui lòng kiểm tra lại" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!> Bạn đã có mã PIN cho tài khoản của mình" + TextColor.END_COLOR);
        }
    }


    public static void changePinForAccount(User user) {
        System.out.print("Nhập mã PIN cũ của bạn: ");
        String inputOldPin = (new Scanner(System.in)).nextLine();
        if (inputOldPin.equals(user.getPin())) {
            System.out.print("Nhập mã PIN mới của bạn: ");
            String inputNewPin = (new Scanner(System.in)).nextLine();
            System.out.print("Nhập lại mã PIN mới của bạn để xác nhận: ");
            String inputPinConfirm = (new Scanner(System.in)).nextLine();
            if (inputPinConfirm.equals(inputNewPin)) {
                System.out.println(TextColor.BLUE + "Thay đổi mã PIN thành công" + TextColor.END_COLOR);
                user.setPin(inputNewPin);
                saveAndLoadData();
            } else {
                System.out.println(TextColor.RED + "<!> Xác nhận mã PIN không đúng, vui lòng kiểm tra lại" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!> Mã PIN cũ của bạn không đúng" + TextColor.END_COLOR);
        }
    }


    public static void changePasswordForAccount(User user) {
        System.out.print("Nhập mật khẩu cũ của bạn: ");
        String inputOldPassword = (new Scanner(System.in)).nextLine();
        if (inputOldPassword.equals(user.getPassword())) {
            System.out.print("Nhập mật khẩu mới của bạn: ");
            String inputNewPassword = (new Scanner(System.in)).nextLine();
            System.out.print("Nhập lại mật khẩu mới của bạn để xác nhận: ");
            String inputNewPasswordConfirm = (new Scanner(System.in)).nextLine();
            if (inputNewPasswordConfirm.equals(inputNewPassword)) {
                System.out.println(TextColor.BLUE + "Thay đổi mật khẩu thành công" + TextColor.END_COLOR);
                user.setPassword(inputNewPassword);
                saveAndLoadData();
            } else {
                System.out.println(TextColor.RED + "<!> Xác nhận mật khẩu không đúng, vui lòng kiểm tra lại" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!> Mật khẩu cũ của bạn không đúng" + TextColor.END_COLOR);
        }
    }


    public static void showUserInformation(User user) {
        saveAndLoadData();

        System.out.println("------------------" + TextColor.BLUE + " Thông tin của bạn " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-30s %-15s %-40s %-30s %-30s%n", "| Họ tên", "| Số điện thoại", "| Email", "| Tài khoản", "| Mật khẩu");
        System.out.printf("%-30s %-15s %-40s %-30s %-30s%n",
                "| " + user.getFullName(),
                "| " + user.getPhoneNumber(),
                "| " + user.getEmail(),
                "| " + user.getUsername(),
                "| " + user.getPassword());
    }

    public static void showUserTransactionHistory(User user) {
        saveAndLoadData();
        System.out.println("------------------" + TextColor.BLUE + " Lịch sử giao dịch của bạn " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-15s %-35s %-15s %-30s %-30s %-40s%n", "| Tài khoản", "| Mã giao dịch", "| Giao dịch", "| Số dư trước giao dịch", "| Số dư sau giao dịch", "| Mô tả");

        for (int j = 0; j < TransactionManagement.getTransactionList().size(); j++) {
            if (TransactionManagement.getTransactionList().get(j).getUserTransact().equals(user.getPhoneNumber())) {
                System.out.printf("%-15s %-35s %-15s %-30s %-30s %-40s%n",
                        "| " + TransactionManagement.getTransactionList().get(j).getUserTransact(),
                        "| " + TransactionManagement.getTransactionList().get(j).getId(),
                        "| " + TransactionManagement.getTransactionList().get(j).getAmountOfTransactMoney(),
                        "| " + TransactionManagement.getTransactionList().get(j).getBalanceBeforeTransaction(),
                        "| " + TransactionManagement.getTransactionList().get(j).getBalanceAfterTransaction(),
                        "| " + TransactionManagement.getTransactionList().get(j).getDescription());
            }
        }
    }

    public static void resetPassword() {
        boolean isFound = false;
        saveAndLoadData();
        System.out.print("Nhập tên tài khoản của bạn:");
        String inputUserName = new Scanner(System.in).nextLine();
        for (User user : userList) {
            if (user.getUsername().equals(inputUserName)) {
                isFound = true;
                System.out.print("Nhập địa chỉ email của bạn:");
                String inputUserEmail = new Scanner(System.in).nextLine();
                if (user.getEmail().equals(inputUserEmail)) {
                    System.out.print("NHập mã PIN của bạn:");
                    String inputUserPin = new Scanner(System.in).nextLine();
                    if (user.getPin().equals(inputUserPin)) {
                        user.setPassword("0123456789");
                        saveAndLoadData();
                        MailManagement.sendEmailResetPassword(inputUserEmail, user.getFullName(), user.getUsername(), user.getPassword());
                    } else {
                        System.out.println(TextColor.RED + "<!> Mã PIN không đúng" + TextColor.END_COLOR);
                    }
                } else {
                    System.out.println(TextColor.RED + "<!> Địa chỉ email không đúng" + TextColor.END_COLOR);
                }
            }
        }
        if (!isFound) {
            System.out.println(TextColor.RED + "<!> Không tìm thấy tên tài khoản" + TextColor.END_COLOR);
        }
    }

    public static void saveAndLoadData() {
        FileUserManagement.getInstance().saveToFile(userList);
        userList = FileUserManagement.getInstance().loadFromFile();
        FileTransactionManagement.getInstance().saveToFile(TransactionManagement.getTransactionList());
        TransactionManagement.setTransactionList(FileTransactionManagement.getInstance().loadFromFile());
    }
}
