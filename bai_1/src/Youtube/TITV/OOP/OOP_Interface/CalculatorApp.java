package Youtube.TITV.OOP.OOP_Interface;

public class CalculatorApp implements Calculator, Sort {
//    a class can implement lots of interface
    @Override
    public double plus(double a, double b) {
        return a + b;
    }

    @Override
    public double minus(double a, double b) {
        return a - b;
    }

    @Override
    public double multiple(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b != 0) return a / b;
        return 0;
    }

    @Override
    public void sortIncrease(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] và arr[i]
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    @Override
    public void sortDecrease(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] < arr[j + 1]) {
                    // swap arr[j+1] và arr[i]
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
