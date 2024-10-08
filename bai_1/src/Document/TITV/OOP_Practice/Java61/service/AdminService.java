package Document.TITV.OOP_Practice.Java61.service;

import Document.TITV.OOP_Practice.Java61.const_variable.choice.*;
import Document.TITV.OOP_Practice.Java61.controller.menu.MenuAdmin;
import Document.TITV.OOP_Practice.Java61.model.Admin;

import java.util.Scanner;

public class AdminService {
    private final Admin admin;

    public AdminService() {
        this.admin = new Admin();
    }

    public void login(StudentService studentService) {
        System.out.print("Enter your username:");
        String userNameAdmin = new Scanner(System.in).nextLine();
        System.out.print("Enter your password:");
        String passwordAdmin = new Scanner(System.in).nextLine();
        if (userNameAdmin.equals(admin.getAccount().getUserName()) && passwordAdmin.equals(admin.getAccount().getPassword())) {
            System.out.println("Admin login successfully");
            this.manageStudents(studentService);
        } else {
            System.out.println("Username or password is incorrect");
        }
    }

    public void manageStudents(StudentService studentService) {
        while (true) {
            boolean exit = false;
            MenuAdmin.getInstance().drawMenuHome();
            System.out.println("Enter your choice:");
            int choiceHome = new Scanner(System.in).nextInt();

            switch (choiceHome) {
                case UserChoiceHome.ADD_NEW_STUDENT:
                    studentService.addNewStudent();
                    break;
                case UserChoiceHome.CHECK_LIST_EMPTY:
                    studentService.checkListEmpty();
                    break;
                case UserChoiceHome.SHOW_ALL:
                    studentService.printStudents();
                    break;
                case UserChoiceHome.CLEAR_ALL:
                    studentService.clearAllStudents();
                    break;
                case UserChoiceHome.FIND_STUDENTS:
                    this.findStudents(studentService);
                    break;
                case UserChoiceHome.REMOVE_STUDENT:
                    this.removeStudent(studentService);
                    break;
                case UserChoiceHome.SORT:
                    this.sortStudents(studentService);
                    break;
                case UserChoiceHome.EDIT_STUDENT:
                    this.editStudent(studentService);
                    break;
                case UserChoiceHome.RETURN_LOGIN:
                    exit = true;
                    break;
            }
            if (exit) {
                break;
            }
        }
    }

    public void findStudents(StudentService studentService) {
        while (true) {
            boolean exit = false;
            MenuAdmin.getInstance().drawMenuFindStudents();
            System.out.println("Enter your choice:");
            int choiceFindStudents = new Scanner(System.in).nextInt();

            switch (choiceFindStudents) {
                case UserChoiceFindStudents.FIND_BY_ID:
                    studentService.findStudentsByID();
                    break;
                case UserChoiceFindStudents.FIND_BY_NAME:
                    studentService.findStudentsByName();
                    break;
                case UserChoiceFindStudents.FIND_BY_YOB:
                    studentService.findStudentsByYearOfBirth();
                    break;
                case UserChoiceFindStudents.SHOW_ALL:
                    studentService.printStudents();
                    break;
                case UserChoiceFindStudents.RETURN_HOME:
                    exit = true;
                    break;
            }
            if (exit) {
                break;
            }
        }
    }

    public void removeStudent(StudentService studentService) {
        while (true) {
            boolean exit = false;
            MenuAdmin.getInstance().drawMenuRemoveStudent();
            System.out.println("Enter your choice:");
            int choiceRemoveStudent = new Scanner(System.in).nextInt();

            switch (choiceRemoveStudent) {
                case UserChoiceRemoveStudents.REMOVE_BY_ID:
                    studentService.removeStudentByID();
                    break;
                case UserChoiceRemoveStudents.REMOVE_BY_NAME:
                    studentService.removeStudentByName();
                    break;
                case UserChoiceRemoveStudents.REMOVE_BY_YOB:
                    studentService.removeStudentByYearOfBirth();
                    break;
                case UserChoiceRemoveStudents.SHOW_ALL:
                    studentService.printStudents();
                    break;
                case UserChoiceRemoveStudents.RETURN_HOME:
                    exit = true;
                    break;
            }
            if (exit) {
                break;
            }
        }
    }

    public void sortStudents(StudentService studentService) {
        while (true) {
            boolean exit = false;
            MenuAdmin.getInstance().drawMenuSort();
            System.out.println("Enter your choice:");
            int choiceSort = new Scanner(System.in).nextInt();

            switch (choiceSort) {
                case UserChoiceSort.SORT_ASCENDING_BY_SCORE:
                    studentService.sortByScore("ascend");
                    break;
                case UserChoiceSort.SORT_DESCENDING_BY_SCORE:
                    studentService.sortByScore("descend");
                    break;
                case UserChoiceSort.SHOW_ALL:
                    studentService.printStudents();
                    break;
                case UserChoiceSort.RETURN_HOME:
                    exit = true;
                    break;
            }
            if (exit) {
                break;
            }
        }
    }

    public void editStudent(StudentService studentService) {
        while (true) {
            boolean exit = false;
            MenuAdmin.getInstance().drawMenuEditStudent();
            System.out.print("Enter your choice:");
            int choiceEditStudent = new Scanner(System.in).nextInt();

            switch (choiceEditStudent) {
                case UserChoiceEditStudent.EDIT_ID:
                    studentService.editStudentId();
                    break;
                case UserChoiceEditStudent.SHOW_ALL:
                    studentService.printStudents();
                    break;
                case UserChoiceEditStudent.RETURN_HOME:
                    exit = true;
                    break;
            }
            if (exit) {
                break;
            }
        }
    }
}
