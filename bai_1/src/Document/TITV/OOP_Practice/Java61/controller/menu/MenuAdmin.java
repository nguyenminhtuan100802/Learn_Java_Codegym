package Document.TITV.OOP_Practice.Java61.controller.menu;

import Document.TITV.OOP_Practice.Java61.const_variable.color.ColorText;

public class MenuAdmin extends MenuLogin {
    public static MenuAdmin getInstance(){
        return new MenuAdmin();
    }
    public void drawMenuHome(){
        System.out.println("===============" + ColorText.YELLOW + " LOGIN > HOME " + ColorText.END_COLOR + "===============");
        System.out.println("1. Add new student");
        System.out.println("2. Check list student is empty");
        System.out.println("3. Show all students");
        System.out.println("4. Clear list students");
        System.out.println("5. Find students");
        System.out.println("6. Remove a student");
        System.out.println("7. Sort");
        System.out.println("8. Edit student ");
        System.out.println("15. Return login");
        System.out.println("===============" + ColorText.YELLOW + " END " + ColorText.END_COLOR + "===============");
    }
    public void drawMenuFindStudents(){
        System.out.println("===============" + ColorText.YELLOW + " LOGIN > HOME > FIND STUDENTS " + ColorText.END_COLOR + "===============");
        System.out.println("1. Find students by ID");
        System.out.println("2. Find students by name");
        System.out.println("3. Find students by year of birth");
        System.out.println("4. Show all students");
        System.out.println("5. Return home");
        System.out.println("===============" + ColorText.YELLOW + " END " + ColorText.END_COLOR + "===============");
    }
    public void drawMenuRemoveStudent(){
        System.out.println("===============" + ColorText.YELLOW + " LOGIN > HOME > REMOVE STUDENT " + ColorText.END_COLOR + "===============");
        System.out.println("1. Remove a student by ID");
        System.out.println("2. Remove a student by name");
        System.out.println("3. Remove a student by year of birth");
        System.out.println("4. Show all students");
        System.out.println("5. Return home");
        System.out.println("===============" + ColorText.YELLOW + " END " + ColorText.END_COLOR + "===============");
    }
    public void drawMenuSort(){
        System.out.println("===============" + ColorText.YELLOW + " LOGIN > HOME > SORT STUDENT " + ColorText.END_COLOR + "===============");
        System.out.println("1. Sort ascending by average score");
        System.out.println("2. Sort descending by average score");
        System.out.println("3. Show all students");
        System.out.println("4. Return home");
        System.out.println("===============" + ColorText.YELLOW + " END " + ColorText.END_COLOR + "===============");
    }
    public void drawMenuEditStudent(){
        System.out.println("===============" + ColorText.YELLOW + " LOGIN > HOME > EDIT STUDENT " + ColorText.END_COLOR + "===============");
        System.out.println("1. Edit id");
        System.out.println("2. Edit name");
        System.out.println("3. Edit year of birth");
        System.out.println("4. Edit score");
        System.out.println("5. Edit id, name, yob, score");
        System.out.println("6. Edit user name");
        System.out.println("7. Edit password");
        System.out.println("9. Show all students");
        System.out.println("10. Return home");
        System.out.println("===============" + ColorText.YELLOW + " END " + ColorText.END_COLOR + "===============");
    }
}
