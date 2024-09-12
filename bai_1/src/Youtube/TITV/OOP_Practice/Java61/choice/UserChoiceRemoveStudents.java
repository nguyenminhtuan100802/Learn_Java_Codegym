package Youtube.TITV.OOP_Practice.Java61.choice;

public enum UserChoiceRemoveStudents {
    REMOVE_BY_ID(1),
    REMOVE_BY_NAME(2),
    REMOVE_BY_YOB(3),
    SHOW_ALL(4),
    RETURN_HOME(5);

    public int value;
    private UserChoiceRemoveStudents(int value){
        this.value = value;
    }
}
