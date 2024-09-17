package Youtube.TITV.OOP_Practice.Java61.application;

import Youtube.TITV.OOP_Practice.Java61.choice.UserChoiceLogin;
import Youtube.TITV.OOP_Practice.Java61.menu.MenuAdmin;
import Youtube.TITV.OOP_Practice.Java61.user.Admin;
import Youtube.TITV.OOP_Practice.Java61.user.Student;
import Youtube.TITV.OOP_Practice.Java61.user.StudentList;

import java.util.Scanner;

public class Application {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void runApplication() {
        StudentList studentList = new StudentList();
        Admin admin = new Admin();
        Student student = new Student();
        int choiceLogin = 0;

        studentList.loadStudentsFromDatabase();
        while (true) {
            boolean exit = false;
            MenuAdmin.getInstance().drawMenuLogin();
            try {
                System.out.print("Enter your choice:");
                choiceLogin = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                choiceLogin = 0;
                System.out.println(ANSI_RED + "<!>Invalid choice, please enter number!" + ANSI_RESET);
            }

            switch (choiceLogin) {
                case UserChoiceLogin.LOGIN_AS_ADMIN:
                    admin.login(studentList);
                    break;
                case UserChoiceLogin.LOGIN_AS_TEACHER:
                    break;
                case UserChoiceLogin.LOGIN_AS_STUDENT:
                    student.login(studentList);
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
