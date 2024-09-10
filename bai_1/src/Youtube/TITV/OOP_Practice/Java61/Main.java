package Youtube.TITV.OOP_Practice.Java61;

import java.util.Scanner;

public class Main {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static StudentList studentList = new StudentList();

    public static void main(String[] args) {
//        UserChoice userChoice = UserChoice;
//        System.out.println(UserChoice.ADD_NEW_STUDENT.value);
        initializeListStudentWith10Element();

//        drawLogin();
//        System.out.println("Enter your choice:");
//        int choiceLogin = new Scanner(System.in).nextInt();
//
//        if (true){}

        while (true){
            drawMenuHome();
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
                    drawMenuFindStudents();
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
                    drawMenuRemoveStudent();
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
                    drawMenuSort();
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
//    enum UserChoiceLogin{
//
//    }
//    enum UserChoice{
//
//    }
    enum UserChoiceFindStudents{
        FIND_BY_ID(1),
        FIND_BY_NAME(2),
        FIND_BY_YOB(3),
        SHOW_ALL(4),
        RETURN_HOME(5);

        private int value;
        private UserChoiceFindStudents(int value){
            this.value = value;
        }
    }
    enum UserChoiceRemoveStudents{
        REMOVE_BY_ID(1),
        REMOVE_BY_NAME(2),
        REMOVE_BY_YOB(3),
        SHOW_ALL(4),
        RETURN_HOME(5);

        private int value;
        private UserChoiceRemoveStudents(int value){
            this.value = value;
        }
    }
    enum UserChoiceSort{
        SORT_ASCENDING_BY_SCORE(1),
        SORT_DESCENDING_BY_SCORE(2),
        SHOW_ALL(3),
        RETURN_HOME(4);

        private int value;
        private UserChoiceSort(int value){
            this.value = value;
        }
    }
    public static void drawLogin(){
        System.out.println("===============" + ANSI_YELLOW + " LOGIN " + ANSI_RESET + "===============");
        System.out.println("1. Login as admin");
        System.out.println("2. Login as teacher");
        System.out.println("3. Login as student");
        System.out.println("4. Register for teacher");
        System.out.println("5. Register for student");
        System.out.println("6. Forgot password");
        System.out.println("15. Quit program");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
    public static void drawMenuHome(){
        System.out.println("===============" + ANSI_YELLOW + " HOME " + ANSI_RESET + "===============");
        System.out.println("1. Add new student");
        System.out.println("2. Check list student is empty");
        System.out.println("3. Show all students");
        System.out.println("4. Clear list students");
        System.out.println("5. Find students");
        System.out.println("6. Remove a student");
        System.out.println("7. Sort");
        System.out.println("15. Quit program");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
    public static void drawMenuFindStudents(){
        System.out.println("===============" + ANSI_YELLOW + " HOME > FIND STUDENTS " + ANSI_RESET + "===============");
        System.out.println("1. Find students by ID");
        System.out.println("2. Find students by name");
        System.out.println("3. Find students by year of birth");
        System.out.println("4. Show all students");
        System.out.println("5. Return home");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
    public static void drawMenuRemoveStudent(){
        System.out.println("===============" + ANSI_YELLOW + " HOME > REMOVE STUDENT " + ANSI_RESET + "===============");
        System.out.println("1. Remove a student by ID");
        System.out.println("2. Remove a student by name");
        System.out.println("3. Remove a student by year of birth");
        System.out.println("4. Show all students");
        System.out.println("5. Return home");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
    public static void drawMenuSort(){
        System.out.println("===============" + ANSI_YELLOW + " HOME > SORT STUDENT " + ANSI_RESET + "===============");
        System.out.println("1. Sort ascending by average score");
        System.out.println("2. Sort descending by average score");
        System.out.println("3. Show all students");
        System.out.println("4. Return home");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
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
