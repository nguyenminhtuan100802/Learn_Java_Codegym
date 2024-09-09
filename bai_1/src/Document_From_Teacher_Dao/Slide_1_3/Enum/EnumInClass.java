package Document_From_Teacher_Dao.Slide_1_3.Enum;
// declare enum outside a class
enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class EnumInClass {
//    declare enum inside a class
    enum Season{
        SPRING(0), SUMMER(1),AUTUMN(2),WINTER(3);

        private int value;
        private Season(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
//        enum inside  class
        Season season = Season.SUMMER;
//        enum outside class
        Day day = Day.FRIDAY;
//        enum in another class
        Season2 season2 = Season2.SPRING;

        System.out.println(season);
        System.out.println(day);
        System.out.println(season2);

        System.out.println("We have 4 seasons: ");
        for (Season s : Season.values()){
            System.out.println(s + " has value: " + s.value);
        }

    }
}
