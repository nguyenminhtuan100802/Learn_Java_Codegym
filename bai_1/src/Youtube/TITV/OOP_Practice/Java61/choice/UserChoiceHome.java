package Youtube.TITV.OOP_Practice.Java61.choice;

public enum UserChoiceHome {
    ADD_NEW_STUDENT(1),
    CHECK_LIST_EMPTY(2),
    SHOW_ALL(3),
    CLEAR_ALL(4),
    FIND_STUDENTS(5),
    REMOVE_STUDENT(6),
    SORT(7),
    EDIT_STUDENT(8),
    RETURN_LOGIN(15);

    public int value;
    private UserChoiceHome(int value){
        this.value = value;
    }
}
