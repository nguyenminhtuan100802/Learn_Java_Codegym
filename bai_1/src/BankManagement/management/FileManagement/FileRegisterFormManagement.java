package BankManagement.management.FileManagement;

import BankManagement.entity.RegisterForm;

import java.io.FileWriter;
import java.util.ArrayList;

public class FileRegisterFormManagement implements FileManagement<ArrayList<RegisterForm>>{
    public static FileRegisterFormManagement getInstance(){
        return new FileRegisterFormManagement();
    }

    @Override
    public void saveToFile(ArrayList<RegisterForm> registerFormArrayList) {
        if (!registerFormArrayList.isEmpty()){
            try {
                String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\data\\register_form.txt";
                FileWriter fileWriter = new FileWriter(fileName);
                for (int i = 0; i < registerFormArrayList.size(); i++) {
                    fileWriter.write(registerFormArrayList.get(i).getFullName() + "-");
                    fileWriter.write(registerFormArrayList.get(i).getPhoneNumber() + "-");
                    fileWriter.write(registerFormArrayList.get(i).getEmail() + "|\n");
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
    public ArrayList<RegisterForm> loadFromFile() {
        return null;
    }
}
