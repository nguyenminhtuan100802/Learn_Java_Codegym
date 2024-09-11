package Youtube.TITV.OOP_Practice.Java61.EnumUserChoice;

public enum UserChoiceEditStudent {
    EDIT_ID(1),
    EDIT_NAME(2),
    EDIT_YOB(3),
    EDIT_SCORE(4),
    EDIT_ID_NAME_YOB_SCORE(5),
    EDIT_USERNAME(6),
    EDIT_PASSWORD(7),
    SHOW_ALL(9),
    RETURN_HOME(10);

    public int value;
    private UserChoiceEditStudent(int value){
        this.value = value;
    }
}
