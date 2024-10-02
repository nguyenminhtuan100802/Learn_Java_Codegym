package BankManagement.management;

import BankManagement.entity.RegisterForm;
import BankManagement.management.FileManagement.FileRegisterFormManagement;


import java.util.ArrayList;
import java.util.Scanner;

public class RegisterFormManagement {
    public static ArrayList<RegisterForm> registerFormArrayList = new ArrayList<>();

    public static void addNewRegisterForm() {
        System.out.print("Enter your full name:");
        String inputFullName = new Scanner(System.in).nextLine();
        System.out.print("Enter your phone number:");
        String inputPhoneNumber = new Scanner(System.in).nextLine();
        System.out.print("Enter your email:");
        String inputEmail = new Scanner(System.in).nextLine();

        registerFormArrayList.add(new RegisterForm(inputFullName, inputPhoneNumber, inputEmail));
        FileRegisterFormManagement.getInstance().saveToFile(registerFormArrayList);
    }
    public static void showRegisterForms() {
        for (int i = 0; i < registerFormArrayList.size(); i++) {
            System.out.println(registerFormArrayList.get(i).toString());
        }
    }
    public void deleteRegisterForm() {

    }
    public void deleteAllRegisterForm() {
        registerFormArrayList.clear();
    }
}
