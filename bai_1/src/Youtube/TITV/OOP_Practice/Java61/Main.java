package Youtube.TITV.OOP_Practice.Java61;

import Youtube.TITV.OOP_Practice.Java61.EnumUserChoice.*;

import java.util.Scanner;

public class Main {
    public static StudentList studentList = new StudentList();
    public static void main(String[] args) {
        MenuAdmin menuAdmin = new MenuAdmin();
        Admin admin = new Admin();
        initializeListStudentWith10Element();

        while (true) {
            menuAdmin.drawMenuLogin();
            System.out.println("Enter your choice:");
            int choiceLogin = new Scanner(System.in).nextInt();

            if (choiceLogin == UserChoiceLogin.LOGIN_AS_ADMIN.value){
                System.out.print("Enter your username:");
                String userName = new Scanner(System.in).nextLine();
                System.out.print("Enter your password:");
                String password = new Scanner(System.in).nextLine();
                if (userName.equals(admin.getAccount().getUserName()) && password.equals(admin.getAccount().getPassword())){
                    System.out.println("Admin login successfully");
                    admin.actionsForAdmin(studentList);
                }
            }
            else if (choiceLogin == UserChoiceLogin.LOGIN_AS_TEACHER.value){}
            else if (choiceLogin == UserChoiceLogin.LOGIN_AS_STUDENT.value){

            }
            else if (choiceLogin == UserChoiceLogin.QUIT_PROGRAM.value){
                break;
            }
        }
    }

    public static void initializeListStudentWith10Element(){
        Student student1 = new Student("123", "tuan", 2002, 9);
        Student student2 = new Student("123", "minh", 2003, 8);
        Student student3 = new Student("456", "nguyen", 2004, 9.5);
        Student student4 = new Student("456", "le", 2005, 5.5);
        Student student5 = new Student("789", "yen", 2006, 7);
        Student student6 = new Student("789", "phuong", 2007, 8);
        Student student7 = new Student("321", "jenni", 2008, 7.5);
        Student student8 = new Student("321", "tuan1", 2009, 7.3);
        Student student9 = new Student("213", "tuan2", 2010, 8.4);
        Student student10 = new Student("213", "tuan3", 2011, 9.2);
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
