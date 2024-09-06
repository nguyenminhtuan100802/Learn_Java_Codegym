package Document_From_Teacher_Dao.Slide_1_3;

public class AccessArray {
    public static void main(String[] args) {
        int a[] = {3, 5, 7, 9};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        a[2] = a[1] * 4;
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
