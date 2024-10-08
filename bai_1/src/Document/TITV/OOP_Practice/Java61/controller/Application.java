package Document.TITV.OOP_Practice.Java61.controller;

import Document.TITV.OOP_Practice.Java61.const_variable.choice.UserChoiceLogin;
import Document.TITV.OOP_Practice.Java61.const_variable.color.ColorText;
import Document.TITV.OOP_Practice.Java61.controller.menu.MenuAdmin;

import java.util.Scanner;

public class Application {
    public static void runApplication() {
        StudentManagement studentManagement = new StudentManagement();
        AdminManagement adminManagement = new AdminManagement();
        int choiceLogin = 0;

//        studentList.loadStudentsFromDatabase();
        studentManagement.getStudentService().loadStudentsFromFile();
        while (true) {
            boolean exit = false;
            MenuAdmin.getInstance().drawMenuLogin();
            try {
                System.out.print("Enter your choice:");
                choiceLogin = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                choiceLogin = 0;
                System.out.println(ColorText.RED + "<!>Invalid choice, please enter number!" + ColorText.END_COLOR);
            }

            switch (choiceLogin) {
                case UserChoiceLogin.LOGIN_AS_ADMIN:
                    adminManagement.getAdminService().login(studentManagement.getStudentService());
                    break;
                case UserChoiceLogin.LOGIN_AS_TEACHER:
                    break;
                case UserChoiceLogin.LOGIN_AS_STUDENT:
                    studentManagement.getStudentService().login();
                    break;
                case UserChoiceLogin.QUIT_PROGRAM:
                    exit = true;
                    break;
            }
            if (exit){
                break;
            }
        }
    }
}
