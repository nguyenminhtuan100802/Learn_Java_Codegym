package BankManagement.service;

import BankManagement.variable.Choice.Choice;
import BankManagement.variable.TextColor.TextColor;
import BankManagement.variable.UserChoice.UserChoiceLogin;

import java.util.Scanner;

public class ApplicationService {
    private AdminService adminService;
    private UserService userService;

    public ApplicationService() {
        adminService = new AdminService();
        userService = new UserService();
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void run(){
        while (true) {
            boolean isExit = false;
            System.out.println("=================" + TextColor.YELLOW + " LOGIN " + TextColor.END_COLOR + "=================");
            System.out.println("1. Login as admin");
            System.out.println("2. Login as user");
            System.out.println("3. Logout");
            System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
            System.out.print("Enter your choice:");
            Choice.login = new Scanner(System.in).nextInt();
            switch (Choice.login) {
                case UserChoiceLogin.LOGIN_AS_ADMIN:
                    adminService.login(userService);
                    break;
                case UserChoiceLogin.LOGIN_AS_USER:
                    break;
                case UserChoiceLogin.EXIT:
                    isExit = true;
                    break;
            }
            if (isExit) {
                System.out.println(TextColor.YELLOW + "See you again <3" + TextColor.END_COLOR);
                break;
            }
        }
    }
}
