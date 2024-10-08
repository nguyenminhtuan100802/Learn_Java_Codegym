package Document.Document_From_Teacher_Dao.Slide_1_3;

public class DeclareArray {
    public static void main(String[] args) {
        double[] d1 = new double[]{1,2,3,4,5};
        double[] d2 = {6,7,8,9,10};

        for (int i = 0; i < d1.length; i++) {
            System.out.println("d1[" + i + "] = " + d1[i]);
        }
        for (int i = 0; i < d2.length; i++) {
            System.out.println("d2[" + i + "] = " + d2[i]);
        }
    }
}
