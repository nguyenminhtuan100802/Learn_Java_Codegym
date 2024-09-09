package Youtube.TITV.OOP_Practice.Java61;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        Student student1 = new Student("123", "Tuan", 2002, 8.5);
//        Student student2 = new Student("456", "Tu", 2003, 8.5);
//        Student student3 = new Student("789", "Phuong", 2004, 8.5);
        StudentList studentList = new StudentList();
//        student1.printStudentInfo();
//
//
//        studentList.addNewStudent(student1);
//        studentList.addNewStudent(student2);
//        studentList.printStudents();
        while (true){
            System.out.println("=================================");
            System.out.println("1. Add new student");
            System.out.println("2. Check list student is empty");
            System.out.println("3. Show all students");
            System.out.println("4. Quit program");
            System.out.println("=================================");
            System.out.println("Enter your choice:");
            int choice = input.nextInt();
            if (choice == 1){
                Student student = new Student();
                student = student.createNewStudent();
                studentList.addNewStudent(student);
            }
            else if (choice == 2){}
            else if (choice == 3){
                studentList.printStudents();
            }
            else if (choice == 4){
                break;
            }
        }
    }
}
