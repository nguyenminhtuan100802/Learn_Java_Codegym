package Document.Document_From_Teacher_Dao.Slide_1_1;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            int a, b, c;
            a = 5;
            b = a + 3;
            a = 5 / 10; // 0
            System.out.println("a = " + a);
            c = 8 / a; // error
            System.out.println("c = " + c);
        } catch (Exception e) {
            System.out.println("Chi tiết lỗi: ");
            e.printStackTrace();
        } finally {
            System.out.println("Lỗi hay không vẫn chạy");
        }
        System.out.println("Cảm ơn bạn đã dùng");
    }
}
