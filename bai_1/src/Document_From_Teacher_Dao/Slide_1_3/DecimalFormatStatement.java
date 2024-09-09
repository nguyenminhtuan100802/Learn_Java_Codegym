package Document_From_Teacher_Dao.Slide_1_3;

import java.text.DecimalFormat;

public class DecimalFormatStatement {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double number = 1/0.9;
        System.out.println("value number before format: " + number);
        System.out.println("value number after format: " + decimalFormat.format(number));
    }
}
