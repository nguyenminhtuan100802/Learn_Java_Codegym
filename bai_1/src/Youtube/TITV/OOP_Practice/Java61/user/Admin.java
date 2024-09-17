package Youtube.TITV.OOP_Practice.Java61.user;

import Youtube.TITV.OOP_Practice.Java61.choice.*;
import Youtube.TITV.OOP_Practice.Java61.menu.MenuAdmin;

import java.util.Scanner;

public class Admin {
    private Account account = new Account();

    public Admin() {
        this.account.setUserName("admin");
        this.account.setPassword("admin");
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void login(StudentList studentList) {
        System.out.print("Enter your username:");
        String userNameAdmin = new Scanner(System.in).nextLine();
        System.out.print("Enter your password:");
        String passwordAdmin = new Scanner(System.in).nextLine();
        if (userNameAdmin.equals(this.getAccount().getUserName()) && passwordAdmin.equals(this.getAccount().getPassword())) {
            System.out.println("Admin login successfully");
            this.manageStudents(studentList);
        } else {
            System.out.println("Username or password is incorrect");
        }
    }

    public void manageStudents(StudentList studentList) {
        while (true) {
            boolean exit = false;
            MenuAdmin.getInstance().drawMenuHome();
            System.out.println("Enter your choice:");
            int choiceHome = new Scanner(System.in).nextInt();

            switch (choiceHome) {
                case UserChoiceHome.ADD_NEW_STUDENT:
                    studentList.addNewStudent(Student.createNewStudent());
                    break;
                case UserChoiceHome.CHECK_LIST_EMPTY:
                    studentList.checkListEmpty();
                    break;
                case UserChoiceHome.SHOW_ALL:
                    studentList.printStudents();
                    break;
                case UserChoiceHome.CLEAR_ALL:
                    studentList.clearAllStudents();
                    break;
                case UserChoiceHome.FIND_STUDENTS:
                    this.findStudents(studentList);
                    break;
                case UserChoiceHome.REMOVE_STUDENT:
                    this.removeStudent(studentList);
                    break;
                case UserChoiceHome.SORT:
                    this.sortStudents(studentList);
                    break;
                case UserChoiceHome.EDIT_STUDENT:
                    this.editStudent(studentList);
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

    public void findStudents(StudentList studentList) {
        while (true) {
            boolean exit = false;
            MenuAdmin.getInstance().drawMenuFindStudents();
            System.out.println("Enter your choice:");
            int choiceFindStudents = new Scanner(System.in).nextInt();

            switch (choiceFindStudents) {
                case UserChoiceFindStudents.FIND_BY_ID:
                    studentList.findStudentsByID();
                    break;
                case UserChoiceFindStudents.FIND_BY_NAME:
                    studentList.findStudentsByName();
                    break;
                case UserChoiceFindStudents.FIND_BY_YOB:
                    studentList.findStudentsByYearOfBirth();
                    break;
                case UserChoiceFindStudents.SHOW_ALL:
                    studentList.printStudents();
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

    public void removeStudent(StudentList studentList) {
        while (true) {
            MenuAdmin.getInstance().drawMenuRemoveStudent();
            System.out.println("Enter your choice:");
            int choiceRemoveStudent = new Scanner(System.in).nextInt();

            if (choiceRemoveStudent == UserChoiceRemoveStudents.REMOVE_BY_ID) {
                System.out.print("Enter student ID:");
                String inputID = new Scanner(System.in).nextLine();
                studentList.removeStudentByID(inputID);
            } else if (choiceRemoveStudent == UserChoiceRemoveStudents.REMOVE_BY_NAME) {
                System.out.print("Enter student name:");
                String inputName = new Scanner(System.in).nextLine();
                studentList.removeStudentByName(inputName);
            } else if (choiceRemoveStudent == UserChoiceRemoveStudents.REMOVE_BY_YOB) {
                System.out.print("Enter student year of birth:");
                int inputYearOfBirth = new Scanner(System.in).nextInt();
                studentList.removeStudentByYearOfBirth(inputYearOfBirth);
            } else if (choiceRemoveStudent == UserChoiceRemoveStudents.SHOW_ALL) {
                studentList.printStudents();
            } else if (choiceRemoveStudent == UserChoiceRemoveStudents.RETURN_HOME) {
                break;
            }
        }
    }

    public void sortStudents(StudentList studentList) {
        while (true) {
            MenuAdmin.getInstance().drawMenuSort();
            System.out.println("Enter your choice:");
            int choiceSort = new Scanner(System.in).nextInt();

            if (choiceSort == UserChoiceSort.SORT_ASCENDING_BY_SCORE) {
                studentList.sortByScore("ascend");
            } else if (choiceSort == UserChoiceSort.SORT_DESCENDING_BY_SCORE) {
                studentList.sortByScore("descend");
            } else if (choiceSort == UserChoiceSort.SHOW_ALL) {
                studentList.printStudents();
            } else if (choiceSort == UserChoiceSort.RETURN_HOME) {
                break;
            }
        }
    }

    public void editStudent(StudentList studentList) {
        while (true) {
            MenuAdmin.getInstance().drawMenuEditStudent();
            System.out.print("Enter your choice:");
            int choiceEditStudent = new Scanner(System.in).nextInt();

            if (choiceEditStudent == UserChoiceEditStudent.EDIT_ID) {
                System.out.print("Enter student ID you want to find:");
                String inputID = new Scanner(System.in).nextLine();

                for (int i = 0; i < studentList.getListSize(); i++) {
                    if (studentList.getStudentByID(inputID) != null) {
                        System.out.println("Found student:" + studentList.getStudentByID(inputID));
                        System.out.print("Enter ID you want to edit:");
                        String editID = new Scanner(System.in).nextLine();
                        studentList.setStudentId(inputID, editID);
                    } else {
                        System.out.println("Student not found");
                    }
                }
            } else if (choiceEditStudent == UserChoiceEditStudent.SHOW_ALL) {
                studentList.printStudents();

            } else if (choiceEditStudent == UserChoiceEditStudent.RETURN_HOME) {
                break;
            }

        }
    }
}
