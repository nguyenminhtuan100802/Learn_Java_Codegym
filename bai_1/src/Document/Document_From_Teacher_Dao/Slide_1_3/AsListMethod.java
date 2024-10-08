package Document.Document_From_Teacher_Dao.Slide_1_3;

import java.util.Arrays;
import java.util.List;

public class AsListMethod {
    public static void main(String[] args) {
        Integer a[] = {1, 2, 3, 4, 5, 6, 7 ,8 , 9};
        System.out.println("Mảng a: " + a);
        System.out.println("Mảng a: " + Arrays.toString(a));

        List<Integer> integerList = Arrays.asList(a);
        System.out.println(integerList);
    }
}
