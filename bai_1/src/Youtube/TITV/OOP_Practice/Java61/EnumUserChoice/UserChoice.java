package Youtube.TITV.OOP_Practice.Java61.EnumUserChoice;

public enum UserChoice {
    ADD_NEW_STUDENT(1),
    CHECK_LIST_EMPTY(2),
    SHOW_ALL(3),
    CLEAR_ALL(4),
    FIND_STUDENTS(5),
    REMOVE_STUDENT(6),
    SORT(7),
    QUIT_PROGRAM(15);

    public int value;
    private UserChoice(int value){
        this.value = value;
    }
}
