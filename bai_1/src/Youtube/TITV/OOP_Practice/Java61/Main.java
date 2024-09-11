package Youtube.TITV.OOP_Practice.Java61;

import Youtube.TITV.OOP_Practice.Java61.EnumUserChoice.*;
import Youtube.TITV.OOP_Practice.Java61.Menu.MenuAdmin;

import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static StudentList studentList = new StudentList();
    public static void main(String[] args) {
        MenuAdmin menuAdmin = new MenuAdmin();
        Admin admin = new Admin();
        int choiceLogin = 0;

        initializeListStudentWith10Element();
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
            }
            else if (choiceLogin == UserChoiceLogin.LOGIN_AS_TEACHER.value){

            }
            else if (choiceLogin == UserChoiceLogin.LOGIN_AS_STUDENT.value){

            }
            else if (choiceLogin == UserChoiceLogin.QUIT_PROGRAM.value){
                break;
            }
        }
    }

    public static void initializeListStudentWith10Element(){
        Student student1 = new Student("1", "tuan", 2002, 9);
        Student student2 = new Student("2", "minh", 2003, 8);
        Student student3 = new Student("3", "nguyen", 2004, 9.5);
        Student student4 = new Student("4", "le", 2005, 5.5);
        Student student5 = new Student("5", "yen", 2006, 7);
        Student student6 = new Student("6", "phuong", 2007, 8);
        Student student7 = new Student("7", "jenni", 2008, 7.5);
        Student student8 = new Student("8", "tuan1", 2009, 7.3);
        Student student9 = new Student("9", "tuan2", 2010, 8.4);
        Student student10 = new Student("10", "tuan3", 2011, 9.2);
        studentList.addNewStudent(student1);
        studentList.addNewStudent(student2);
        studentList.addNewStudent(student3);
        studentList.addNewStudent(student4);
        studentList.addNewStudent(student5);
        studentList.addNewStudent(student6);
        studentList.addNewStudent(student7);
        studentList.addNewStudent(student8);
        studentList.addNewStudent(student9);
        studentList.addNewStudent(student10);
    }
}
