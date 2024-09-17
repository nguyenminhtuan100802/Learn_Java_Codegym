package Youtube.TITV.OOP_Practice.Java61.user;

import Youtube.TITV.OOP_Practice.Java61.choice.*;
import Youtube.TITV.OOP_Practice.Java61.menu.MenuAdmin;

import java.util.Scanner;

public class Admin {
    private Account account = new Account();
    private final MenuAdmin menuAdmin = new MenuAdmin();
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
    public void manageStudents(StudentList studentList) {
        while (true){
            menuAdmin.drawMenuHome();
            System.out.println("Enter your choice:");
            int choiceHome = new Scanner(System.in).nextInt();

            if (choiceHome == UserChoiceHome.ADD_NEW_STUDENT){
                Student student = new Student();
                student = student.createNewStudent();
                studentList.addNewStudent(student);
            }
            else if (choiceHome == UserChoiceHome.CHECK_LIST_EMPTY){
                if (studentList.isListEmpty()) System.out.println("There are " + studentList.getListSize() + " student in your list");
                else System.out.println("There are " + studentList.getListSize() + " students in your list");
            }
            else if (choiceHome == UserChoiceHome.SHOW_ALL){
                studentList.printStudents();
            }
            else if (choiceHome == UserChoiceHome.CLEAR_ALL){
                studentList.clearAllStudents();
            }
            else if (choiceHome == UserChoiceHome.FIND_STUDENTS){
                this.findStudents(studentList);
            }
            else if (choiceHome == UserChoiceHome.REMOVE_STUDENT){
                this.removeStudent(studentList);
            }
            else if (choiceHome == UserChoiceHome.SORT){
                this.sortStudents(studentList);
            }
            else if (choiceHome == UserChoiceHome.EDIT_STUDENT) {
                this.editStudent(studentList);
            }
            else if (choiceHome == UserChoiceHome.RETURN_LOGIN){
                break;
            }
        }
    }
    public void findStudents(StudentList studentList){
        while (true){
            menuAdmin.drawMenuFindStudents();
            System.out.println("Enter your choice:");
            int choiceFindStudents = new Scanner(System.in).nextInt();

            if (choiceFindStudents == UserChoiceFindStudents.FIND_BY_ID){
                System.out.print("Enter student ID:");
                String inputID = new Scanner(System.in).nextLine();
                studentList.findStudentsByID(inputID);
            }
            else if (choiceFindStudents == UserChoiceFindStudents.FIND_BY_NAME){
                System.out.print("Enter student name:");
                String inputName = new Scanner(System.in).nextLine();
                studentList.findStudentsByName(inputName);
            }
            else if (choiceFindStudents == UserChoiceFindStudents.FIND_BY_YOB){
                System.out.print("Enter student year of birth:");
                int inputYearOfBirth = new Scanner(System.in).nextInt();
                studentList.findStudentsByYearOfBirth(inputYearOfBirth);
            }
            else if (choiceFindStudents == UserChoiceFindStudents.SHOW_ALL) {
                studentList.printStudents();
            }
            else if (choiceFindStudents == UserChoiceFindStudents.RETURN_HOME) {
                break;
            }
        }
    }
    public void removeStudent(StudentList studentList){
        while (true){
            menuAdmin.drawMenuRemoveStudent();
            System.out.println("Enter your choice:");
            int choiceRemoveStudent = new Scanner(System.in).nextInt();

            if (choiceRemoveStudent == UserChoiceRemoveStudents.REMOVE_BY_ID){
                System.out.print("Enter student ID:");
                String inputID = new Scanner(System.in).nextLine();
                studentList.removeStudentByID(inputID);
            }
            else if (choiceRemoveStudent == UserChoiceRemoveStudents.REMOVE_BY_NAME){
                System.out.print("Enter student name:");
                String inputName = new Scanner(System.in).nextLine();
                studentList.removeStudentByName(inputName);
            }
            else if (choiceRemoveStudent == UserChoiceRemoveStudents.REMOVE_BY_YOB){
                System.out.print("Enter student year of birth:");
                int inputYearOfBirth = new Scanner(System.in).nextInt();
                studentList.removeStudentByYearOfBirth(inputYearOfBirth);
            }
            else if (choiceRemoveStudent == UserChoiceRemoveStudents.SHOW_ALL) {
                studentList.printStudents();
            }
            else if (choiceRemoveStudent == UserChoiceRemoveStudents.RETURN_HOME) {
                break;
            }
        }
    }
    public void sortStudents(StudentList studentList){
        while (true){
            menuAdmin.drawMenuSort();
            System.out.println("Enter your choice:");
            int choiceSort = new Scanner(System.in).nextInt();

            if (choiceSort == UserChoiceSort.SORT_ASCENDING_BY_SCORE){
                studentList.sortByScore("ascend");
            }
            else if (choiceSort == UserChoiceSort.SORT_DESCENDING_BY_SCORE) {
                studentList.sortByScore("descend");
            }
            else if (choiceSort == UserChoiceSort.SHOW_ALL) {
                studentList.printStudents();
            }
            else if (choiceSort == UserChoiceSort.RETURN_HOME) {
                break;
            }
        }
    }
    public void editStudent(StudentList studentList){
        while (true){
            menuAdmin.drawMenuEditStudent();
            System.out.print("Enter your choice:");
            int choiceEditStudent = new Scanner(System.in).nextInt();

            if (choiceEditStudent == UserChoiceEditStudent.EDIT_ID){
                System.out.print("Enter student ID you want to find:");
                String inputID = new Scanner(System.in).nextLine();

                for (int i = 0; i < studentList.getListSize(); i++) {
                    if(studentList.getStudentByID(inputID) != null){
                        System.out.println("Found student:" + studentList.getStudentByID(inputID));
                        System.out.print("Enter ID you want to edit:");
                        String editID = new Scanner(System.in).nextLine();
                        studentList.setStudentId(inputID, editID);
                    }
                    else {
                        System.out.println("Student not found");
                    }
                }
            }
            else if (choiceEditStudent == UserChoiceEditStudent.SHOW_ALL) {
                studentList.printStudents();

            }
            else if (choiceEditStudent == UserChoiceEditStudent.RETURN_HOME){
                break;
            }

        }
    }
}
