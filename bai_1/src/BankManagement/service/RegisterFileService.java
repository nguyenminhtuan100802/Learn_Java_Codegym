package BankManagement.service;

import BankManagement.entity.RegisterForm;

import java.io.FileWriter;
import java.util.List;

public class RegisterFileService implements File<List<RegisterForm>> {
    public static RegisterFileService getInstance(){
        return new RegisterFileService();
    }

    @Override
    public void saveToFile(List<RegisterForm> registerFormList) {
        if (!registerFormList.isEmpty()){
            try {
                String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\data\\register_form.txt";
                FileWriter fileWriter = new FileWriter(fileName);
                for (RegisterForm registerForm : registerFormList) {
                    fileWriter.write(registerForm.getFullName() + "-");
                    fileWriter.write(registerForm.getPhoneNumber() + "-");
                    fileWriter.write(registerForm.getEmail() + "|\n");
                }
                fileWriter.flush();
                fileWriter.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<RegisterForm> loadFromFile() {
        return null;
    }
}
