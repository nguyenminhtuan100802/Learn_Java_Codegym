package Youtube.TITV.OOP_Practice.Java61;

import Youtube.TITV.OOP_Practice.Java61.EnumUserChoice.UserChoice;
import Youtube.TITV.OOP_Practice.Java61.EnumUserChoice.UserChoiceFindStudents;
import Youtube.TITV.OOP_Practice.Java61.EnumUserChoice.UserChoiceRemoveStudents;
import Youtube.TITV.OOP_Practice.Java61.EnumUserChoice.UserChoiceSort;

import java.util.Scanner;

public class Admin {
    private Account account;
    private final MenuAdmin menuAdmin;
    public Admin() {
        this.menu = new MenuAdmin();
        this.account = new Account();
        this.account.setUserName("admin");
        this.account.setPassword("admin");
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public void actionsForAdmin(StudentList studentList) {
        while (true){
            menuAdmin.drawMenuHome();
            System.out.println("Enter your choice:");
            int choice = new Scanner(System.in).nextInt();

            if (choice == UserChoice.ADD_NEW_STUDENT.value){
                Student student = new Student();
                student = student.createNewStudent();
                studentList.addNewStudent(student);
            }
            else if (choice == UserChoice.CHECK_LIST_EMPTY.value){
                if (studentList.isListEmpty()) System.out.println("There are " + studentList.getListSize() + " student in your list");
                else System.out.println("There are " + studentList.getListSize() + " students in your list");
            }
            else if (choice == UserChoice.SHOW_ALL.value){
                studentList.printStudents();
            }
            else if (choice == UserChoice.CLEAR_ALL.value){
                studentList.ClearAllStudents();
            }
            else if (choice == UserChoice.FIND_STUDENTS.value){
                while (true){
                    menuAdmin.drawMenuFindStudents();
                    System.out.println("Enter your choice:");
                    int choiceFindStudents = new Scanner(System.in).nextInt();

                    if (choiceFindStudents == UserChoiceFindStudents.FIND_BY_ID.value){
                        System.out.print("Enter student ID:");
                        String inputID = new Scanner(System.in).nextLine();
                        studentList.findStudentsByID(inputID);
                    }
                    else if (choiceFindStudents == UserChoiceFindStudents.FIND_BY_NAME.value){
                        System.out.print("Enter student name:");
                        String inputName = new Scanner(System.in).nextLine();
                        studentList.findStudentsByName(inputName);
                    }
                    else if (choiceFindStudents == UserChoiceFindStudents.FIND_BY_YOB.value){
                        System.out.print("Enter student year of birth:");
                        int inputYearOfBirth = new Scanner(System.in).nextInt();
                        studentList.findStudentsByYearOfBirth(inputYearOfBirth);
                    }
                    else if (choiceFindStudents == UserChoiceFindStudents.RETURN_HOME.value) {
                        break;
                    }
                }
            }
            else if (choice == UserChoice.REMOVE_STUDENT.value){
                while (true){
                    menuAdmin.drawMenuRemoveStudent();
                    System.out.println("Enter your choice:");
                    int choiceRemoveStudent = new Scanner(System.in).nextInt();

                    if (choiceRemoveStudent == UserChoiceRemoveStudents.REMOVE_BY_ID.value){
                        System.out.print("Enter student ID:");
                        String inputID = new Scanner(System.in).nextLine();
                        studentList.removeStudentByID(inputID);
                    }
                    else if (choiceRemoveStudent == UserChoiceRemoveStudents.REMOVE_BY_NAME.value){
                        System.out.print("Enter student name:");
                        String inputName = new Scanner(System.in).nextLine();
                        studentList.removeStudentByName(inputName);
                    }
                    else if (choiceRemoveStudent == UserChoiceRemoveStudents.REMOVE_BY_YOB.value){
                        System.out.print("Enter student year of birth:");
                        int inputYearOfBirth = new Scanner(System.in).nextInt();
                        studentList.removeStudentByYearOfBirth(inputYearOfBirth);
                    }
                    else if (choiceRemoveStudent == UserChoiceRemoveStudents.RETURN_HOME.value) {
                        break;
                    }
                }
            }
            else if (choice == UserChoice.SORT.value){
                while (true){
                    menuAdmin.drawMenuSort();
                    System.out.println("Enter your choice:");
                    int choiceSort = new Scanner(System.in).nextInt();

                    if (choiceSort == UserChoiceSort.SORT_ASCENDING_BY_SCORE.value){
                        studentList.sortAscendingByScore();
                    }
                    else if (choiceSort == UserChoiceSort.SORT_DESCENDING_BY_SCORE.value) {
                        System.out.println("sort descending by score");
                        studentList.sortDescendingByScore();
                    }
                    else if (choiceSort == UserChoiceSort.RETURN_HOME.value) {
                        break;
                    }
                }
            }
            else if (choice == UserChoice.QUIT_PROGRAM.value){
                break;
            }
        }
    }
}
