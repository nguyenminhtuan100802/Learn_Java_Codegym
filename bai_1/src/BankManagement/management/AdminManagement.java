package BankManagement.management;

import BankManagement.entity.Admin;
import BankManagement.entity.User;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class AdminManagement {
    private static final Admin admin = new Admin();

    public static boolean verifyLogin() {
        System.out.print("Enter username:");
        String username = new Scanner(System.in).nextLine();
        System.out.print("Enter password:");
        String password = new Scanner(System.in).nextLine();
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println(TextColor.BLUE + "Admin login successfully" + TextColor.END_COLOR);
            return true;
        }
        else {
            System.out.println(TextColor.RED + "Incorrect username or password" + TextColor.END_COLOR);
            return false;
        }
    }

    public static void addUser() {
        String userFullName = InputDataManagement.inputAndCheckFullName();
        String userPhoneNumber = InputDataManagement.inputAndCheckPhoneNumber();
        String userEmail = InputDataManagement.inputAndCheckEmail();

        UserManagement.getUserArrayList().add(new User(userFullName, userPhoneNumber, userEmail));
        UserManagement.saveAndLoadData();
        System.out.println(TextColor.BLUE + "Thêm người dùng thành công" + TextColor.END_COLOR);

        MailManagement.sendEmailAccountCreated(userEmail, userFullName, userPhoneNumber);
    }

    public static void findUserByName() {
        System.out.print("Nhập tên người dùng bạn muốn tìm:");
        String inputUserFullName = new Scanner(System.in).nextLine();
        System.out.println("------------------" + TextColor.BLUE + " Người dùng đã tìm thấy " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-15s %-30s %-30s%n", "Họ và tên", "Số điện thoại", "ID", "Tên người dùng", "Mật khẩu");
        for (User user : UserManagement.getUserArrayList()) {
            if (user.getFullName().equals(inputUserFullName)) {
                System.out.printf("%-20s %-15s %-15s %-30s %-30s%n",
                        user.getFullName(),
                        user.getPhoneNumber(),
                        user.getId(),
                        user.getUsername(),
                        user.getPassword());
            }
        }
    }

    public static void findUserByPhoneNumber() {
        System.out.print("Nhập số điện thoại người dùng bạn muốn tìm:");
        String inputUserPhoneNumber = new Scanner(System.in).nextLine();
        System.out.println("------------------" + TextColor.BLUE + " Người dùng đã tìm thấy " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-20s %-15s %-15s %-30s %-30s%n", "Họ và tên", "Số điện thoại", "ID", "Tên người dùng", "Mật khẩu");
        for (User user : UserManagement.getUserArrayList()) {
            if (user.getPhoneNumber().equals(inputUserPhoneNumber)) {
                System.out.printf("%-20s %-15s %-15s %-30s %-30s%n",
                        user.getFullName(),
                        user.getPhoneNumber(),
                        user.getId(),
                        user.getUsername(),
                        user.getPassword());
            }
        }
    }


    public static void editUser(User user) {
    }

    public static void deleteUser(User user) {
    }

    public static void showAllUsers() {
        UserManagement.saveAndLoadData();
        System.out.println("------------------" + TextColor.BLUE + " Danh sách người dùng " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-30s %-15s %-40s %-30s %-30s%n",
                "Họ và tên", "Số điện thoại", "Email", "Tên người dùng", "Mật khẩu");
        for (User user : UserManagement.getUserArrayList()) {
            System.out.printf("%-30s %-15s %-40s %-30s %-30s%n",
                    user.getFullName(),
                    user.getPhoneNumber(),
                    user.getEmail(),
                    user.getUsername(),
                    user.getPassword());
        }
    }

    public static void deleteAllUsers() {
        System.out.print("Bạn có muốn xóa tất cả người dùng không? (Y/N):");
        String inputAnswer = (new Scanner(System.in)).nextLine();
        if (inputAnswer.equals("Y")) {
            UserManagement.getUserArrayList().clear();
            UserManagement.saveAndLoadData();
            System.out.println(TextColor.BLUE + "Xóa tất cả người dùng thành công" + TextColor.END_COLOR);
        }
    }


    public static void showAllUserTransactionsHistory() {
        UserManagement.saveAndLoadData();

        System.out.println("------------------" + TextColor.BLUE + " Lịch sử giao dịch của tất cả người dùng " + TextColor.END_COLOR + "------------------");
        System.out.printf("%-15s %-35s %-15s %-30s %-30s %-40s%n", "Tài khoản", "ID giao dịch", "Giao dịch", "Số dư trước giao dịch", "Số dư sau giao dịch", "Mô tả");

        for (int j = 0; j < TransactionManagement.getTransactionList().size(); j++) {
            System.out.printf("%-15s %-35s %-15s %-30s %-30s %-40s%n",
                    TransactionManagement.getTransactionList().get(j).getUserTransact(),
                    TransactionManagement.getTransactionList().get(j).getId(),
                    TransactionManagement.getTransactionList().get(j).getAmountOfTransactMoney(),
                    TransactionManagement.getTransactionList().get(j).getBalanceBeforeTransaction(),
                    TransactionManagement.getTransactionList().get(j).getBalanceAfterTransaction(),
                    TransactionManagement.getTransactionList().get(j).getDescription());
        }
    }
}
