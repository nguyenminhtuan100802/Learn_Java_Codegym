package Document.Document_From_Teacher_Dao.Slide_1_3;

import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        Random randomNumber = new Random();
//        random in [0....99]
        System.out.println("random number: " + randomNumber.nextInt(100) );
//        random in [0...1] type double / but multiple with 200 we will have [0...200] type double
        System.out.println("random number: " + randomNumber.nextDouble() * 200);
    }
}
