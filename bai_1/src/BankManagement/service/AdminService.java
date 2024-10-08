package BankManagement.service;

import BankManagement.entity.Admin;
import BankManagement.constant.TextColor;

import java.util.Scanner;

public class AdminService {
    private static final Admin admin = new Admin();

    public static boolean verifyLogin() {
        System.out.print("Nhập tên đăng nhập:");
        String username = new Scanner(System.in).nextLine();
        System.out.print("Nhập mật khẩu:");
        String password = new Scanner(System.in).nextLine();
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println(TextColor.BLUE + "Đăng nhập quản trị viên thành công" + TextColor.END_COLOR);
            return true;
        } else {
            System.out.println(TextColor.RED + "<!> Sai tên đăng nhập hoặc mật khẩu" + TextColor.END_COLOR);
            return false;
        }
    }


//    public static void addUser() {
//        String userFullName = InputDataManagement.inputAndCheckFullName();
//        String userPhoneNumber = InputDataManagement.inputAndCheckPhoneNumber();
//        String userEmail = InputDataManagement.inputAndCheckEmail();
//
//        UserManagement.getUserArrayList().add(new User(userFullName, userPhoneNumber, userEmail));
//        UserManagement.saveAndLoadData();
//        System.out.println(TextColor.BLUE + "Thêm người dùng thành công" + TextColor.END_COLOR);
//
//        MailManagement.sendEmailAccountCreated(userEmail, userFullName, userPhoneNumber);
//    }
//
//    public static void findUserByName() {
//        System.out.print("Nhập tên người dùng bạn muốn tìm:");
//        String inputUserFullName = new Scanner(System.in).nextLine();
//        System.out.println("------------------" + TextColor.BLUE + " Người dùng đã tìm thấy " + TextColor.END_COLOR + "------------------");
//        System.out.printf("%-20s %-15s %-15s %-30s %-30s%n", "Họ và tên", "Số điện thoại", "ID", "Tên người dùng", "Mật khẩu");
//        for (User user : UserManagement.getUserArrayList()) {
//            if (user.getFullName().equals(inputUserFullName)) {
//                System.out.printf("%-20s %-15s %-15s %-30s %-30s%n",
//                        user.getFullName(),
//                        user.getPhoneNumber(),
//                        user.getId(),
//                        user.getUsername(),
//                        user.getPassword());
//            }
//        }
//    }
//
//    private static User findUserByPhoneNumber(String phoneNumber) {
//        for (User user : UserManagement.getUserArrayList()) {
//            if (user.getPhoneNumber().equals(phoneNumber)) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public static void findUserByPhoneNumber() {
//        System.out.print("Nhập số điện thoại người dùng bạn muốn tìm:");
//        String inputUserPhoneNumber = new Scanner(System.in).nextLine();
//        System.out.println("------------------" + TextColor.BLUE + " Người dùng đã tìm thấy " + TextColor.END_COLOR + "------------------");
//        System.out.printf("%-20s %-15s %-15s %-30s %-30s%n", "Họ và tên", "Số điện thoại", "ID", "Tên người dùng", "Mật khẩu");
//        for (User user : UserManagement.getUserArrayList()) {
//            if (user.getPhoneNumber().equals(inputUserPhoneNumber)) {
//                System.out.printf("%-20s %-15s %-15s %-30s %-30s%n",
//                        user.getFullName(),
//                        user.getPhoneNumber(),
//                        user.getId(),
//                        user.getUsername(),
//                        user.getPassword());
//            }
//        }
//    }
//
//
//    public static void editUserName() {
//        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa tên: ");
//        String phoneNumber = new Scanner(System.in).nextLine();
//        User user = findUserByPhoneNumber(phoneNumber);
//        if (user != null) {
//            System.out.print("Nhập tên mới: ");
//            String newName = new Scanner(System.in).nextLine();
//            user.setFullName(newName);
//            UserManagement.saveAndLoadData();
//            System.out.println(TextColor.BLUE + "Chỉnh sửa tên thành công" + TextColor.END_COLOR);
//        } else {
//            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
//        }
//    }
//    public static void editUserPhoneNumber() {
//        System.out.print("Nhập số điện thoại hiện tại của người dùng: ");
//        String oldPhoneNumber = new Scanner(System.in).nextLine();
//        User user = findUserByPhoneNumber(oldPhoneNumber);
//        if (user != null) {
//            System.out.print("Nhập số điện thoại mới: ");
//            String newPhoneNumber = new Scanner(System.in).nextLine();
//            user.setPhoneNumber(newPhoneNumber);
//            UserManagement.saveAndLoadData();
//            System.out.println(TextColor.BLUE + "Chỉnh sửa số điện thoại thành công" + TextColor.END_COLOR);
//        } else {
//            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
//        }
//    }
//
//    public static void editUserPassword() {
//        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa mật khẩu: ");
//        String phoneNumber = new Scanner(System.in).nextLine();
//        User user = findUserByPhoneNumber(phoneNumber);
//        if (user != null) {
//            System.out.print("Nhập mật khẩu mới: ");
//            String newPassword = new Scanner(System.in).nextLine();
//            user.setPassword(newPassword);
//            UserManagement.saveAndLoadData();
//            System.out.println(TextColor.BLUE + "Chỉnh sửa mật khẩu thành công" + TextColor.END_COLOR);
//        } else {
//            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
//        }
//    }
//
//    public static void editUserPIN() {
//        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa PIN: ");
//        String phoneNumber = new Scanner(System.in).nextLine();
//        User user = findUserByPhoneNumber(phoneNumber);
//        if (user != null) {
//            System.out.print("Nhập PIN mới: ");
//            String newPIN = new Scanner(System.in).nextLine();
//            user.setPin(newPIN);
//            UserManagement.saveAndLoadData();
//            System.out.println(TextColor.BLUE + "Chỉnh sửa PIN thành công" + TextColor.END_COLOR);
//        } else {
//            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
//        }
//    }
//
//    public static void editUserEmail() {
//        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa email: ");
//        String phoneNumber = new Scanner(System.in).nextLine();
//        User user = findUserByPhoneNumber(phoneNumber);
//        if (user != null) {
//            System.out.print("Nhập email mới: ");
//            String newEmail = new Scanner(System.in).nextLine();
//            user.setEmail(newEmail);
//            UserManagement.saveAndLoadData();
//            System.out.println(TextColor.BLUE + "Chỉnh sửa email thành công" + TextColor.END_COLOR);
//        } else {
//            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
//        }
//    }
//
//    public static void editAllUserInfo() {
//        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa: ");
//        String phoneNumber = new Scanner(System.in).nextLine();
//        User user = findUserByPhoneNumber(phoneNumber);
//        if (user != null) {
//            System.out.print("Nhập tên mới: ");
//            String newName = new Scanner(System.in).nextLine();
//            System.out.print("Nhập số điện thoại mới: ");
//            String newPhoneNumber = new Scanner(System.in).nextLine();
//            System.out.print("Nhập mật khẩu mới: ");
//            String newPassword = new Scanner(System.in).nextLine();
//            System.out.print("Nhập PIN mới: ");
//            String newPIN = new Scanner(System.in).nextLine();
//            System.out.print("Nhập email mới: ");
//            String newEmail = new Scanner(System.in).nextLine();
//
//            user.setFullName(newName);
//            user.setPhoneNumber(newPhoneNumber);
//            user.setPassword(newPassword);
//            user.setPin(newPIN);
//            user.setEmail(newEmail);
//
//            UserManagement.saveAndLoadData();
//            System.out.println(TextColor.BLUE + "Chỉnh sửa tất cả thông tin thành công" + TextColor.END_COLOR);
//        } else {
//            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
//        }
//    }
//
//    public static void showAllUsers() {
//        UserManagement.saveAndLoadData();
//        System.out.println("------------------" + TextColor.BLUE + " Danh sách người dùng " + TextColor.END_COLOR + "------------------");
//        System.out.printf("%-30s %-15s %-40s %-30s %-30s%n",
//                "Họ và tên", "Số điện thoại", "Email", "Tên người dùng", "Mật khẩu");
//        for (User user : UserManagement.getUserArrayList()) {
//            System.out.printf("%-30s %-15s %-40s %-30s %-30s%n",
//                    user.getFullName(),
//                    user.getPhoneNumber(),
//                    user.getEmail(),
//                    user.getUsername(),
//                    user.getPassword());
//        }
//    }
//
//    public static void deleteAllUsers() {
//        System.out.print("Bạn có muốn xóa tất cả người dùng không? (Y/N):");
//        String inputAnswer = (new Scanner(System.in)).nextLine();
//        if (inputAnswer.equals("Y")) {
//            UserManagement.getUserArrayList().clear();
//            UserManagement.saveAndLoadData();
//            System.out.println(TextColor.BLUE + "Xóa tất cả người dùng thành công" + TextColor.END_COLOR);
//        }
//    }
//
//
//    public static void showAllUserTransactionsHistory() {
//        UserManagement.saveAndLoadData();
//
//        System.out.println("------------------" + TextColor.BLUE + " Lịch sử giao dịch của tất cả người dùng " + TextColor.END_COLOR + "------------------");
//        System.out.printf("%-15s %-35s %-15s %-30s %-30s %-40s%n", "Tài khoản", "ID giao dịch", "Giao dịch", "Số dư trước giao dịch", "Số dư sau giao dịch", "Mô tả");
//
//        for (int j = 0; j < TransactionManagement.getTransactionList().size(); j++) {
//            System.out.printf("%-15s %-35s %-15s %-30s %-30s %-40s%n",
//                    TransactionManagement.getTransactionList().get(j).getUserTransact(),
//                    TransactionManagement.getTransactionList().get(j).getId(),
//                    TransactionManagement.getTransactionList().get(j).getAmountOfTransactMoney(),
//                    TransactionManagement.getTransactionList().get(j).getBalanceBeforeTransaction(),
//                    TransactionManagement.getTransactionList().get(j).getBalanceAfterTransaction(),
//                    TransactionManagement.getTransactionList().get(j).getDescription());
//        }
//    }
}
