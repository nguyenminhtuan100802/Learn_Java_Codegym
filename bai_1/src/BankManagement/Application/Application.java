package BankManagement.Application;

import BankManagement.controller.AdminManagement;
import BankManagement.model.Admin;
import BankManagement.variable.Choice.Choice;
import BankManagement.variable.UserChoice.UserChoiceLogin;
import BankManagement.variable.TextColor.TextColor;

import java.util.Scanner;

public class Application {
    public static void run(){
        AdminManagement adminManagement = new AdminManagement();
        while (true) {
            boolean isExit = false;
            System.out.println("=================" + TextColor.YELLOW + " LOGIN " + TextColor.END_COLOR + "=================");
            System.out.println("1. Login as admin");
            System.out.println("2. Login as user");
            System.out.println("3. Exit");
            System.out.println("=================" + TextColor.YELLOW + " END " + TextColor.END_COLOR + "=================");
            System.out.print("Enter your choice:");
            Choice.login = new Scanner(System.in).nextInt();
            switch (Choice.login) {
                case UserChoiceLogin.LOGIN_AS_ADMIN:
                    if (adminManagement.getAdminService().loginVerify()) {
                        adminManagement.getAdminService().manage();
                    }
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
