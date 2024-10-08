package Document.TITV.OOP_Practice.Java61.controller.menu;

import Document.TITV.OOP_Practice.Java61.const_variable.color.ColorText;

public abstract class MenuLogin implements Menu{
    public void drawMenuLogin(){
        System.out.println("===============" + ColorText.YELLOW + " LOGIN " + ColorText.END_COLOR + "===============");
        System.out.println("1. Login as admin");
        System.out.println("2. Login as teacher");
        System.out.println("3. Login as student");
        System.out.println("4. Register for teacher");
        System.out.println("5. Register for student");
        System.out.println("6. Forgot password");
        System.out.println("10. Quit program");
        System.out.println("===============" + ColorText.YELLOW + " END " + ColorText.END_COLOR + "===============");
    }
}
