package Document_From_Teacher_Dao.Slide_1_3;

import java.util.Arrays;

public class SortIncreaseDecrease {
    public static void main(String[] args) {
        int a[] = {5,3,7,3,8,34,22,98,24,66,51,23,65,47};
        int b[] = {5,3,7,3,8,34,22,98,24,66,51,23,65,47};
        System.out.println("Mảng gốc a: " + Arrays.toString(a));
        System.out.println("Mảng gốc b: " + Arrays.toString(b));

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                if (b[i] < b[j]) {
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        System.out.println("Mảng a sau sắp xếp: " + Arrays.toString(a));
        System.out.println("Mảng b sau sắp xếp: " + Arrays.toString(b));
    }
}
