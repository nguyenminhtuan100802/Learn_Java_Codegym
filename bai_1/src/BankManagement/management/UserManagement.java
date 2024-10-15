package BankManagement.management;

import BankManagement.entity.User;
import BankManagement.service.*;
import BankManagement.constant.TextColor;


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

    public static void addUser() {
        String userFullName = InputDataService.inputAndCheckFullName();
        String userPhoneNumber = InputDataService.inputAndCheckPhoneNumber();
        String userEmail = InputDataService.inputAndCheckEmail();

        UserManagement.getUserArrayList().add(new User(userFullName, userPhoneNumber, userEmail));
        FileService.saveAndLoadData();
        System.out.println(TextColor.BLUE + "Thêm người dùng thành công" + TextColor.END_COLOR);

        MailService.sendEmailAccountCreated(userEmail, userFullName, userPhoneNumber);
    }

    public static void findUserByName() {
        System.out.print("Nhập tên người dùng bạn muốn tìm:");
        String inputUserFullName = new Scanner(System.in).nextLine();
        MenuService.moveMenuDown2Times();
        System.out.println(MenuService.displayTab60Times() + TextColor.BLUE + " Người dùng đã tìm thấy " + TextColor.END_COLOR + MenuService.displayTab60Times());
        System.out.printf("%-20s %-15s %-15s %-30s %-30s %-30s%n", "| Họ và tên", "| Số điện thoại", "| ID", "| Tên người dùng", "| Mật khẩu", "|");
        for (User user : UserManagement.getUserArrayList()) {
            if (user.getFullName().toLowerCase().contains(inputUserFullName.toLowerCase())) {
                System.out.printf("%-20s %-15s %-15s %-30s %-30s %-30s%n",
                        "| " + user.getFullName(),
                        "| " + user.getPhoneNumber(),
                        "| " + user.getId(),
                        "| " + user.getUsername(),
                        "| " + user.getPassword(),
                        "|");
            }
        }
    }

    private static User findUserByPhoneNumber(String phoneNumber) {
        for (User user : UserManagement.getUserArrayList()) {
            if (user.getPhoneNumber().contains(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    public static void findUserByPhoneNumber() {
        System.out.print("Nhập số điện thoại người dùng bạn muốn tìm:");
        String inputUserPhoneNumber = new Scanner(System.in).nextLine();
        MenuService.moveMenuDown2Times();
        System.out.println(MenuService.displayTab60Times() + TextColor.BLUE + " Người dùng đã tìm thấy " + TextColor.END_COLOR + MenuService.displayTab60Times());
        System.out.printf("%-20s %-15s %-15s %-30s %-30s %-30s%n", "| Họ và tên", "| Số điện thoại", "| ID", "| Tên người dùng", "| Mật khẩu", "|");
        for (User user : UserManagement.getUserArrayList()) {
            if (user.getPhoneNumber().contains(inputUserPhoneNumber)) {
                System.out.printf("%-20s %-15s %-15s %-30s %-30s %-30s%n",
                        "| " + user.getFullName(),
                        "| " + user.getPhoneNumber(),
                        "| " + user.getId(),
                        "| " + user.getUsername(),
                        "| " + user.getPassword(),
                        "|");
            }
        }
    }


    public static void editUserName() {
        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa tên: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        User user = findUserByPhoneNumber(phoneNumber);
        if (user != null) {
            System.out.print("Nhập tên mới: ");
            String newName = new Scanner(System.in).nextLine();
            user.setFullName(newName);
            FileService.saveAndLoadData();
            System.out.println(TextColor.BLUE + "Chỉnh sửa tên thành công" + TextColor.END_COLOR);
        } else {
            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
        }
    }
    public static void editUserPhoneNumber() {
        System.out.print("Nhập số điện thoại hiện tại của người dùng: ");
        String oldPhoneNumber = new Scanner(System.in).nextLine();
        User user = findUserByPhoneNumber(oldPhoneNumber);
        if (user != null) {
            System.out.print("Nhập số điện thoại mới: ");
            String newPhoneNumber = new Scanner(System.in).nextLine();
            user.setPhoneNumber(newPhoneNumber);
            FileService.saveAndLoadData();
            System.out.println(TextColor.BLUE + "Chỉnh sửa số điện thoại thành công" + TextColor.END_COLOR);
        } else {
            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
        }
    }

    public static void editUserPassword() {
        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa mật khẩu: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        User user = findUserByPhoneNumber(phoneNumber);
        if (user != null) {
            System.out.print("Nhập mật khẩu mới: ");
            String newPassword = new Scanner(System.in).nextLine();
            user.setPassword(newPassword);
            FileService.saveAndLoadData();
            System.out.println(TextColor.BLUE + "Chỉnh sửa mật khẩu thành công" + TextColor.END_COLOR);
        } else {
            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
        }
    }

    public static void editUserPIN() {
        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa PIN: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        User user = findUserByPhoneNumber(phoneNumber);
        if (user != null) {
            System.out.print("Nhập PIN mới: ");
            String newPIN = new Scanner(System.in).nextLine();
            user.setPin(newPIN);
            FileService.saveAndLoadData();
            System.out.println(TextColor.BLUE + "Chỉnh sửa PIN thành công" + TextColor.END_COLOR);
        } else {
            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
        }
    }

    public static void editUserEmail() {
        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa email: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        User user = findUserByPhoneNumber(phoneNumber);
        if (user != null) {
            System.out.print("Nhập email mới: ");
            String newEmail = new Scanner(System.in).nextLine();
            user.setEmail(newEmail);
            FileService.saveAndLoadData();
            System.out.println(TextColor.BLUE + "Chỉnh sửa email thành công" + TextColor.END_COLOR);
        } else {
            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
        }
    }

    public static void editAllUserInfo() {
        System.out.print("Nhập số điện thoại người dùng bạn muốn chỉnh sửa: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        User user = findUserByPhoneNumber(phoneNumber);
        if (user != null) {
            System.out.print("Nhập tên mới: ");
            String newName = new Scanner(System.in).nextLine();
            System.out.print("Nhập số điện thoại mới: ");
            String newPhoneNumber = new Scanner(System.in).nextLine();
            System.out.print("Nhập mật khẩu mới: ");
            String newPassword = new Scanner(System.in).nextLine();
            System.out.print("Nhập PIN mới: ");
            String newPIN = new Scanner(System.in).nextLine();
            System.out.print("Nhập email mới: ");
            String newEmail = new Scanner(System.in).nextLine();

            user.setFullName(newName);
            user.setPhoneNumber(newPhoneNumber);
            user.setPassword(newPassword);
            user.setPin(newPIN);
            user.setEmail(newEmail);

            FileService.saveAndLoadData();
            System.out.println(TextColor.BLUE + "Chỉnh sửa tất cả thông tin thành công" + TextColor.END_COLOR);
        } else {
            System.out.println(TextColor.RED + "<!> Người dùng không tồn tại" + TextColor.END_COLOR);
        }
    }

    public static void showAllUsers() {
        MenuService.moveMenuDown2Times();
        FileService.saveAndLoadData();
        System.out.println(MenuService.displayTab60Times() + TextColor.BLUE + " Danh sách người dùng " + TextColor.END_COLOR + MenuService.displayTab60Times());
        System.out.printf("%-30s %-15s %-40s %-30s %-30s %-30s%n",
                "| Họ và tên", "| Số điện thoại", "| Email", "| Tên người dùng", "| Mật khẩu", "|");
        for (User user : UserManagement.getUserArrayList()) {
            System.out.printf("%-30s %-15s %-40s %-30s %-30s %-30s%n",
                    "| " + user.getFullName(),
                    "| " + user.getPhoneNumber(),
                    "| " + user.getEmail(),
                    "| " + user.getUsername(),
                    "| " + user.getPassword(),
                    "|");
        }
    }

    public static void deleteAllUsers() {
        System.out.print("Bạn có muốn xóa tất cả người dùng không? (Y/N):");
        String inputAnswer = (new Scanner(System.in)).nextLine();
        if (inputAnswer.equals("Y")) {
            UserManagement.getUserArrayList().clear();
            FileService.saveAndLoadData();
            System.out.println(TextColor.BLUE + "Xóa tất cả người dùng thành công" + TextColor.END_COLOR);
        }
    }


    public static void showAllUserTransactionsHistory() {
        FileService.saveAndLoadData();
        MenuService.moveMenuDown2Times();
        System.out.println(MenuService.displayTab60Times() + TextColor.BLUE + " Lịch sử giao dịch của tất cả người dùng " + TextColor.END_COLOR + MenuService.displayTab60Times());
        System.out.printf("%-15s %-35s %-20s %-30s %-30s %-60s %-30s%n",
                "| Tài khoản", "| ID giao dịch", "| Giao dịch", "| Số dư trước giao dịch", "| Số dư sau giao dịch", "| Mô tả", "|");
        for (int j = 0; j < TransactionManagement.getTransactionList().size(); j++) {
            System.out.printf("%-15s %-35s %-20s %-30s %-30s %-60s %-30s%n",
                    "| " + TransactionManagement.getTransactionList().get(j).getUserTransact(),
                    "| " + TransactionManagement.getTransactionList().get(j).getId(),
                    "| " + FormatMoneyService.formatMoney(TransactionManagement.getTransactionList().get(j).getAmountOfTransactMoney()),
                    "| " + FormatMoneyService.formatMoney(TransactionManagement.getTransactionList().get(j).getBalanceBeforeTransaction()),
                    "| " + FormatMoneyService.formatMoney(TransactionManagement.getTransactionList().get(j).getBalanceAfterTransaction()),
                    "| " + TransactionManagement.getTransactionList().get(j).getDescription(),
                    "|");
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
                FileService.saveAndLoadData();
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
                FileService.saveAndLoadData();
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
                FileService.saveAndLoadData();
            } else {
                System.out.println(TextColor.RED + "<!> Xác nhận mật khẩu không đúng, vui lòng kiểm tra lại" + TextColor.END_COLOR);
            }
        } else {
            System.out.println(TextColor.RED + "<!> Mật khẩu cũ của bạn không đúng" + TextColor.END_COLOR);
        }
    }


    public static void showUserInformation(User user) {
        FileService.saveAndLoadData();
        MenuService.moveMenuDown2Times();
        System.out.println(MenuService.displayTab60Times() + TextColor.BLUE + " Thông tin của bạn " + TextColor.END_COLOR + MenuService.displayTab60Times());
        System.out.printf("%-30s %-15s %-40s %-30s %-30s %-30s %-30s%n", "| Họ tên", "| Số điện thoại", "| Email", "| Tài khoản", "| Mật khẩu", "| Số dư", "|");
        System.out.printf("%-30s %-15s %-40s %-30s %-30s %-30s %-30s%n",
                "| " + user.getFullName(),
                "| " + user.getPhoneNumber(),
                "| " + user.getEmail(),
                "| " + user.getUsername(),
                "| " + user.getPassword(),
                "| " + FormatMoneyService.formatMoney(user.getBalance()),
                "|");
//        for (int i = 0; i < UserManagement.getUserArrayList().size(); i++) {
//            System.out.println(UserManagement.getUserArrayList().get(i));
//        }
    }

    public static void showUserTransactionHistory(User user) {
        FileService.saveAndLoadData();
        MenuService.moveMenuDown2Times();
        System.out.println(MenuService.displayTab60Times() + TextColor.BLUE + " Lịch sử giao dịch của bạn " + TextColor.END_COLOR + MenuService.displayTab60Times());
        System.out.printf("%-15s %-35s %-30s %-30s %-30s %-60s %-30s%n",
                "| Tài khoản", "| Mã giao dịch", "| Giao dịch", "| Số dư trước giao dịch", "| Số dư sau giao dịch", "| Mô tả", "|");

        for (int j = 0; j < TransactionManagement.getTransactionList().size(); j++) {
            if (TransactionManagement.getTransactionList().get(j).getUserTransact().equals(user.getPhoneNumber())) {
                if (TransactionManagement.getTransactionList().get(j).getAmountOfTransactMoney() >= 0){
                    System.out.printf("%-15s %-35s %-30s %-30s %-30s %-60s %-30s%n",
                            "| " + TransactionManagement.getTransactionList().get(j).getUserTransact(),
                            "| " + TransactionManagement.getTransactionList().get(j).getId(),
                            "| +" + FormatMoneyService.formatMoney(TransactionManagement.getTransactionList().get(j).getAmountOfTransactMoney()),
                            "| " + FormatMoneyService.formatMoney(TransactionManagement.getTransactionList().get(j).getBalanceBeforeTransaction()),
                            "| " + FormatMoneyService.formatMoney(TransactionManagement.getTransactionList().get(j).getBalanceAfterTransaction()),
                            "| " + TransactionManagement.getTransactionList().get(j).getDescription(),
                            "|");
                }
                else {
                    System.out.printf("%-15s %-35s %-30s %-30s %-30s %-60s %-30s%n",
                            "| " + TransactionManagement.getTransactionList().get(j).getUserTransact(),
                            "| " + TransactionManagement.getTransactionList().get(j).getId(),
                            "| " + FormatMoneyService.formatMoney(TransactionManagement.getTransactionList().get(j).getAmountOfTransactMoney()),
                            "| " + FormatMoneyService.formatMoney(TransactionManagement.getTransactionList().get(j).getBalanceBeforeTransaction()),
                            "| " + FormatMoneyService.formatMoney(TransactionManagement.getTransactionList().get(j).getBalanceAfterTransaction()),
                            "| " + TransactionManagement.getTransactionList().get(j).getDescription(),
                            "|");
                }
            }
        }
    }

    public static void resetPassword() {
        boolean isFound = false;
        FileService.saveAndLoadData();
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
                        FileService.saveAndLoadData();
                        MailService.sendEmailResetPassword(inputUserEmail, user.getFullName(), user.getUsername(), user.getPassword());
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
}
