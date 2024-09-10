package Youtube.TITV.OOP_Practice.Java61;

public enum UserChoiceLogin {
    LOGIN_AS_ADMIN(1),
    LOGIN_AS_TEACHER(2),
    LOGIN_AS_STUDENT(3),
    REGISTER_AS_TEACHER(4),
    REGISTER_AS_STUDENT(5),
    FORGOT_PASSWORD(6),
    QUIT_PROGRAM(10);
    private int value;
    private UserChoiceLogin(int value){
        this.value = value;
    }
}
