package BankManagement.utility.FormatAndCheckInputData;

public class CheckInputData {
    public static boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0';
    }
    public static boolean checkEmail(String email) {
        return email.contains("@gmail.com");
    }
}
