package Youtube.TITV.OOP_Practice.Java61;

public class MenuAdmin {
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_YELLOW = "\u001B[33m";

    public void drawMenuLogin(){
        System.out.println("===============" + this.ANSI_YELLOW + " LOGIN " + ANSI_RESET + "===============");
        System.out.println("1. Login as admin");
        System.out.println("2. Login as teacher");
        System.out.println("3. Login as student");
        System.out.println("4. Register for teacher");
        System.out.println("5. Register for student");
        System.out.println("6. Forgot password");
        System.out.println("15. Quit program");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
    public void drawMenuHome(){
        System.out.println("===============" + ANSI_YELLOW + " LOGIN > HOME " + ANSI_RESET + "===============");
        System.out.println("1. Add new student");
        System.out.println("2. Check list student is empty");
        System.out.println("3. Show all students");
        System.out.println("4. Clear list students");
        System.out.println("5. Find students");
        System.out.println("6. Remove a student");
        System.out.println("7. Sort");
        System.out.println("15. Return login");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
    public void drawMenuFindStudents(){
        System.out.println("===============" + ANSI_YELLOW + " LOGIN > HOME > FIND STUDENTS " + ANSI_RESET + "===============");
        System.out.println("1. Find students by ID");
        System.out.println("2. Find students by name");
        System.out.println("3. Find students by year of birth");
        System.out.println("4. Show all students");
        System.out.println("5. Return home");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
    public void drawMenuRemoveStudent(){
        System.out.println("===============" + ANSI_YELLOW + " LOGIN > HOME > REMOVE STUDENT " + ANSI_RESET + "===============");
        System.out.println("1. Remove a student by ID");
        System.out.println("2. Remove a student by name");
        System.out.println("3. Remove a student by year of birth");
        System.out.println("4. Show all students");
        System.out.println("5. Return home");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
    public void drawMenuSort(){
        System.out.println("===============" + ANSI_YELLOW + " LOGIN > HOME > SORT STUDENT " + ANSI_RESET + "===============");
        System.out.println("1. Sort ascending by average score");
        System.out.println("2. Sort descending by average score");
        System.out.println("3. Show all students");
        System.out.println("4. Return home");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
}
