package Codegym;

public class PhanLoaiTamGiac {
    public static String PhanLoaiTamGiac(double a, double b, double c) {
        // Kiểm tra điều kiện tạo thành một tam giác
        if (a + b > c && a + c > b && b + c > a) {
            // Kiểm tra tam giác đều
            if (a == b && b == c) {
                return "tam giác đều";
            }
            // Kiểm tra tam giác cân
            else if (a == b || b == c || a == c) {
                return "tam giác cân";
            }
            // Tam giác thường
            else {
                return "tam giác thường";
            }
        } else {
            return "không phải tam giác";
        }
    }
}
