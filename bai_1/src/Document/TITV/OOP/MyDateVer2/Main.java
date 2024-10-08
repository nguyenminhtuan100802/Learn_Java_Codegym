package Document.TITV.OOP.MyDateVer2;

public class Main {
    public static void main(String[] args) {
        MyDate myDate = new MyDate(10, 8, 2002);
        MyDate myDate1 = new MyDate(30, 8, 2002);
        System.out.println("Day: " + myDate.getDay());
        myDate.setDay(35);
        System.out.println("Day: " + myDate.getDay());
        myDate.setDay(30);
        System.out.println("Day: " + myDate.getDay());

        System.out.println(myDate);
        System.out.println(myDate.toString());

//        không thể so sánh == giữa 2 đối tượng
//        ta nên dùng phương thức equal để so sánh 2 đối tượng
//        if (myDate == myDate1) {
//            System.out.println("mdDate == mdDate1");
//        }else {
//            System.out.println("mdDate != mdDate1");
//        }
        System.out.println("myDate == myDate1: " + myDate.equals(myDate1));
        System.out.println("hashcode myDate: " + myDate.hashCode());
        System.out.println("hashcode myDate1: " + myDate1.hashCode());

    }
}
