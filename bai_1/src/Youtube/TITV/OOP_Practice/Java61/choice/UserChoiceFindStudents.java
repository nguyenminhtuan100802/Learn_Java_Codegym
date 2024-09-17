package Youtube.TITV.OOP_Practice.Java61.choice;

public enum UserChoiceFindStudents {
    FIND_BY_ID(1),
    FIND_BY_NAME(2),
    FIND_BY_YOB(3),
    SHOW_ALL(4),
    RETURN_HOME(5);

    public final int value;
    private UserChoiceFindStudents(int value){
        this.value = value;
    }
}
