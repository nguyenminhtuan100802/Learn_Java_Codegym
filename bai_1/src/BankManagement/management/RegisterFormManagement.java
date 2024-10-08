package BankManagement.management;

import BankManagement.entity.RegisterForm;
import BankManagement.service.RegisterFileService;
import BankManagement.service.InputDataService;


import java.util.ArrayList;

public class RegisterFormManagement {
    private static ArrayList<RegisterForm> registerFormArrayList = new ArrayList<>();

    public static ArrayList<RegisterForm> getRegisterFormArrayList() {
        return registerFormArrayList;
    }

    public static void setRegisterFormArrayList(ArrayList<RegisterForm> registerFormArrayList) {
        RegisterFormManagement.registerFormArrayList = registerFormArrayList;
    }

    public static void addNewRegisterForm() {
        String userFullName = InputDataService.inputAndCheckFullName();
        String userPhoneNumber = InputDataService.inputAndCheckPhoneNumber();
        String userEmail = InputDataService.inputAndCheckEmail();

        registerFormArrayList.add(new RegisterForm(userFullName, userPhoneNumber, userEmail));
        RegisterFileService.getInstance().saveToFile(registerFormArrayList);
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
