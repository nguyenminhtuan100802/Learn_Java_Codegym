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
        MenuAdmin menuAdmin = new MenuAdmin();
        Admin admin = new Admin();
        int choiceLogin = 0;

        studentList.loadStudentsFromFile();
        while (true) {
            menuAdmin.drawMenuLogin();
            System.out.print("Enter your choice:");
            try {
                choiceLogin = new Scanner(System.in).nextInt();
            }
            catch (Exception e) {
                choiceLogin = 0;
                System.out.println(ANSI_RED + "<!>Invalid choice, please enter number!" + ANSI_RESET);
            }

            if (choiceLogin == UserChoiceLogin.LOGIN_AS_ADMIN.value){
                System.out.print("Enter your username:");
                String userName = new Scanner(System.in).nextLine();
                System.out.print("Enter your password:");
                String password = new Scanner(System.in).nextLine();
                if (userName.equals(admin.getAccount().getUserName()) && password.equals(admin.getAccount().getPassword())){
                    System.out.println("Admin login successfully");
                    admin.manageStudents(studentList);
                }
                else {
                    System.out.println("Username or password is incorrect");
                }
            }
            else if (choiceLogin == UserChoiceLogin.LOGIN_AS_TEACHER.value){

            }
            else if (choiceLogin == UserChoiceLogin.LOGIN_AS_STUDENT.value){
                System.out.print("Enter your username:");
                String userName = new Scanner(System.in).nextLine();
                System.out.print("Enter your password:");
                String password = new Scanner(System.in).nextLine();

                Student student = new Student();
                student = studentList.verifyStudentAccountByUsernameAndPassword(userName, password);
                if (student != null){
                    System.out.println("Student login successfully");
//

                }
            }
            else if (choiceLogin == UserChoiceLogin.QUIT_PROGRAM.value){
                break;
            }
        }
    }
}
