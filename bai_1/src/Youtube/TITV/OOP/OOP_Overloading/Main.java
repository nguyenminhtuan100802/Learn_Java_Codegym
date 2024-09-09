package Youtube.TITV.OOP.OOP_Overloading;

public class Main {
    public static void main(String[] args) {
        MyMath myMath = new MyMath();
//        overloading: lots of functions in class have same name but receive different parameter type
        System.out.println("Sum: " + myMath.calculateSum(2, 6));
        System.out.println("Sum: " + myMath.calculateSum(2.78, 6.65));
    }
}
