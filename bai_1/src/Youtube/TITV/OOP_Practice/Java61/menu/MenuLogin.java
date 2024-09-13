package Youtube.TITV.OOP_Practice.Java61.menu;

public abstract class MenuLogin implements Menu{
    protected final String ANSI_RESET = "\u001B[0m";
    protected final String ANSI_YELLOW = "\u001B[33m";
    public void drawMenuLogin(){
        System.out.println("===============" + this.ANSI_YELLOW + " LOGIN " + ANSI_RESET + "===============");
        System.out.println("1. Login as admin");
        System.out.println("2. Login as teacher");
        System.out.println("3. Login as student");
        System.out.println("4. Register for teacher");
        System.out.println("5. Register for student");
        System.out.println("6. Forgot password");
        System.out.println("10. Quit program");
        System.out.println("===============" + ANSI_YELLOW + " END " + ANSI_RESET + "===============");
    }
}
