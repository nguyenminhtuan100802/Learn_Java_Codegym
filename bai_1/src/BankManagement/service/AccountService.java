package BankManagement.service;

import BankManagement.entity.Transaction;
import BankManagement.entity.User;
import BankManagement.management.TransactionManagement;
import BankManagement.management.UserManagement;
import BankManagement.constant.TextColor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountService {
    public static void deposit(User user) {
        System.out.print("Nhập số tiền bạn muốn gửi: ");
        double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
        System.out.print("Nhập mã PIN của bạn để hoàn tất giao dịch: ");
        String inputPin = (new Scanner(System.in)).nextLine();

        if (user.getPin().equals(inputPin)) {
            System.out.println(TextColor.BLUE + "Gửi tiền thành công, vui lòng kiểm tra tài khoản của bạn" + TextColor.END_COLOR);
            user.setBalance(user.getBalance() + inputAmountOfMoney);
            FileService.saveAndLoadData();

            TransactionManagement.addTransaction(new Transaction(
                    user.getPhoneNumber(),
                    DateTimeFormatter.ofPattern("HH:mm:ss-dd/MM/yyyy").format(LocalDateTime.now()),
                    inputAmountOfMoney,
                    (user.getBalance() - inputAmountOfMoney),
                    user.getBalance(),
                    "Gửi tiền từ người dùng"));

            FileService.saveAndLoadData();
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
                FileService.saveAndLoadData();

                TransactionManagement.addTransaction(new Transaction(
                        user.getPhoneNumber(),
                        DateTimeFormatter.ofPattern("HH:mm:ss-dd/MM/yyyy").format(LocalDateTime.now()),
                        -inputAmountOfMoney,
                        (user.getBalance() + inputAmountOfMoney),
                        user.getBalance(),
                        "Rút tiền từ người dùng"));
                FileService.saveAndLoadData();
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
        for (User user : UserManagement.getUserArrayList()) {
            if (user.getPhoneNumber().equals(inputId)) {
                isFound = true;
                System.out.println(">>" + user.getFullName());
                System.out.print("Nhập số tiền bạn muốn chuyển: ");
                double inputAmountOfMoney = (new Scanner(System.in)).nextDouble();
                if (inputAmountOfMoney <= userSend.getBalance()) {
                    System.out.print("Nhập mô tả cho giao dịch: ");
                    String inputUserSendDescription = (new Scanner(System.in)).nextLine();
                    if (inputUserSendDescription.isEmpty()) {
                        inputUserSendDescription = userSend.getFullName() + " gửi tiền";
                    }
                    else {
                        inputUserSendDescription = userSend.getFullName() + ": " + inputUserSendDescription;
                    }
                    System.out.print("Nhập mã PIN của bạn để hoàn tất giao dịch: ");
                    String inputPin = (new Scanner(System.in)).nextLine();
                    if (inputPin.equals(userSend.getPin())) {
                        System.out.println(TextColor.BLUE + "Giao dịch thành công, vui lòng kiểm tra tài khoản của bạn" + TextColor.END_COLOR);
                        userSend.setBalance(userSend.getBalance() - inputAmountOfMoney);
                        user.setBalance(user.getBalance() + inputAmountOfMoney);
                        FileService.saveAndLoadData();

                        TransactionManagement.addTransaction(new Transaction(
                                userSend.getId(),
                                DateTimeFormatter.ofPattern("HH:mm:ss-dd/MM/yyyy").format(LocalDateTime.now()),
                                -inputAmountOfMoney,
                                (userSend.getBalance() + inputAmountOfMoney),
                                userSend.getBalance(),
                                inputUserSendDescription));

                        TransactionManagement.addTransaction(new Transaction(
                                user.getId(),
                                DateTimeFormatter.ofPattern("HH:mm:ss-dd/MM/yyyy").format(LocalDateTime.now()),
                                inputAmountOfMoney,
                                (user.getBalance() - inputAmountOfMoney),
                                user.getBalance(),
                                inputUserSendDescription));
                        FileService.saveAndLoadData();
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
}
