package Codegym.Array;

public class BT1 {
    public static void main(String[] args) {
        int sum = 0;
        int[] numbers = {1, 4, 7, 8};
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        System.out.println("Sum: " + sum);

    }
}
