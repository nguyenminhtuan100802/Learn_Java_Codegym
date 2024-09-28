package BankManagement.menu;

import BankManagement.entity.Language;
import BankManagement.utility.Choice.Choice;
import BankManagement.utility.ChoiceFromUser.ChoiceLanguage;
import BankManagement.utility.ChoiceFromUser.ChoiceLogin;
import BankManagement.utility.TextColor.TextColor;

import java.util.Scanner;

public class LoginMenu {
    private final AdminMenu adminMenu;
    private final UserMenu userMenu;

    public LoginMenu() {
        adminMenu = new AdminMenu();
        userMenu = new UserMenu();
    }

    public void run() {
        Language.languageName = "English";
        boolean isExit = false;
        while (!isExit) {
            if (Language.languageName.equals("English")) {
                System.out.println("=================" + TextColor.YELLOW + " LOGIN " + TextColor.END_COLOR + "=================");
                System.out.println("1. Login as admin");
                System.out.println("2. Login as user");
                System.out.println("3. Reset password");
                System.out.println("4. Register as user");
                System.out.println("5. Support");
                System.out.println("6. Choose language");
                System.out.println("7. Find a transaction point");
                System.out.println("8. Look up exchange rate");
                System.out.println("10. Logout");
                System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
                System.out.print("Enter your choice:");
            } else if (Language.languageName.equals("Vietnamese")) {
                System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP " + TextColor.END_COLOR + "=================");
                System.out.println("1. Đăng nhập với tư cách admin");
                System.out.println("2. Đăng nhập với tư cách người dùng");
                System.out.println("3. Đặt lại mật khẩu");
                System.out.println("4. Đăng ký tài khoản người dùng");
                System.out.println("5. Hỗ trợ");
                System.out.println("6. Chọn ngôn ngữ");
                System.out.println("7. Tìm điểm giao dịch");
                System.out.println("8. Tra cứu tỷ giá hối đoái");
                System.out.println("10. Đăng xuất");
                System.out.println("=================" + TextColor.YELLOW + " KẾT THÚC " + TextColor.END_COLOR + "=================");
                System.out.print("Nhập lựa chọn của bạn:");
            }
            Choice.login = new Scanner(System.in).nextLine();
            switch (Choice.login) {
                case ChoiceLogin.LOGIN_AS_ADMIN:
                    adminMenu.login();
                    break;
                case ChoiceLogin.LOGIN_AS_USER:
                    userMenu.login();
                    break;
                case ChoiceLogin.RESET_PASSWORD:
                    break;
                case ChoiceLogin.REGISTER_USER:
                    break;
                case ChoiceLogin.SUPPORT:
                    break;
                case ChoiceLogin.CHANGE_LANGUAGE:
                    this.changeLanguage();
                    break;
                case ChoiceLogin.EXIT:
                    isExit = true;
                    break;
                default:
                    if (Language.languageName.equals("English"))
                        System.out.println(TextColor.RED + "<!>Your choice is not valid!" + TextColor.END_COLOR);
                    else if (Language.languageName.equals("Vietnamese"))
                        System.out.println(TextColor.RED + "<!>Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);
            }
        }
        if (Language.languageName.equals("English"))
            System.out.println(TextColor.BLUE + "See you again <3" + TextColor.END_COLOR);
        else if (Language.languageName.equals("Vietnamese"))
            System.out.println(TextColor.BLUE + "Hẹn gặp lại <3" + TextColor.END_COLOR);

    }

    public void changeLanguage() {
        boolean isExit = false;
        while (!isExit) {
            if (Language.languageName.equals("English")) {
                System.out.println("=================" + TextColor.YELLOW + " LOGIN > SETTING LANGUAGE " + TextColor.END_COLOR + "=================");
                System.out.println("1. English");
                System.out.println("2. Vietnamese");
                System.out.println("10. Return to login");
                System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
                System.out.print("Enter your choice:");
            } else if (Language.languageName.equals("Vietnamese")) {
                System.out.println("=================" + TextColor.YELLOW + " ĐĂNG NHẬP > CÀI ĐẶT NGÔN NGỮ " + TextColor.END_COLOR + "=================");
                System.out.println("1. Tiếng Anh");
                System.out.println("2. Tiếng Việt");
                System.out.println("10. Quay lại đăng nhập");
                System.out.println("=================" + TextColor.YELLOW + " KẾT THÚC " + TextColor.END_COLOR + "=================");
                System.out.print("Nhập lựa chọn của bạn:");
            }
            Choice.language = new Scanner(System.in).nextLine();
            switch (Choice.language) {
                case ChoiceLanguage.ENGLISH:
                    Language.languageName = "English";
                    break;
                case ChoiceLanguage.VIETNAMESE:
                    Language.languageName = "Vietnamese";
                    break;
                case ChoiceLanguage.RETURN_LOGIN:
                    isExit = true;
                    break;
                default:
                    if (Language.languageName.equals("English"))
                        System.out.println(TextColor.RED + "<!>Your choice is not valid!" + TextColor.END_COLOR);
                    else if (Language.languageName.equals("Vietnamese"))
                        System.out.println(TextColor.RED + "<!>Lựa chọn của bạn không hợp lệ!" + TextColor.END_COLOR);

            }
        }
    }
}
