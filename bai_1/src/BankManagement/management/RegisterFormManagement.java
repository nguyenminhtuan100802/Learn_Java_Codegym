package BankManagement.management;

import BankManagement.entity.RegisterForm;
import BankManagement.management.FileManagement.FileRegisterFormManagement;


import java.util.ArrayList;
import java.util.Scanner;

public class RegisterFormManagement {
    private static ArrayList<RegisterForm> registerFormArrayList = new ArrayList<>();

    public static void addNewRegisterForm() {
        String userFullName = InputDataManagement.inputAndCheckFullName();
        String userPhoneNumber = InputDataManagement.inputAndCheckPhoneNumber();
        String userEmail = InputDataManagement.inputAndCheckEmail();

        registerFormArrayList.add(new RegisterForm(userFullName, userPhoneNumber, userEmail));
        FileRegisterFormManagement.getInstance().saveToFile(registerFormArrayList);
    }
    public static void showRegisterForms() {
        for (RegisterForm registerForm : registerFormArrayList) {
            System.out.println(registerForm.toString());
        }
    }
    public void deleteRegisterForm() {

    }
    public void deleteAllRegisterForm() {
        registerFormArrayList.clear();
    }
}
