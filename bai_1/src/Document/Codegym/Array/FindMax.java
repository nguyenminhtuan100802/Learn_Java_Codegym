package Document.Codegym.Array;

public class FindMax {
    public static void main(String[] args) {
        double[] arrayNumber = {21.5, 1.2, 3, 2.4, 5.3, 0.4, 142, 14, 65, 24.5, 54.5};
        double max = arrayNumber[0];

        for (int i = 1; i < arrayNumber.length; i++) {
            if (arrayNumber[i] >= max) {
                max = arrayNumber[i];
            }
        }
        System.out.println("Maximum number is " + max);
    }
}
