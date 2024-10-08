package Document.Codegym;

public class DemPhanTuTrungLap {
    public static void main(String[] args) {
        int count = 0;
        int arr[] = new int[]{1, 3, 4, 1, 2, 4, 2, 3, 5, 7};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    break;
                }
            }
        }
        System.out.println("count: " + count);
    }
}
