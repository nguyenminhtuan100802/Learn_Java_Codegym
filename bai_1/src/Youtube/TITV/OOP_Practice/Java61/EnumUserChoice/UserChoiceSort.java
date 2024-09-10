package Youtube.TITV.OOP_Practice.Java61.EnumUserChoice;

public enum UserChoiceSort {
    SORT_ASCENDING_BY_SCORE(1),
    SORT_DESCENDING_BY_SCORE(2),
    SHOW_ALL(3),
    RETURN_HOME(4);

    public int value;
    private UserChoiceSort(int value){
        this.value = value;
    }
}
