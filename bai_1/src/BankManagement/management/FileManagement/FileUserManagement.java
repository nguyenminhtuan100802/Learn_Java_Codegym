package BankManagement.management.FileManagement;

import BankManagement.entity.User;
import BankManagement.utility.File.FileReadUser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUserManagement implements FileManagement<List<User>> {
    public static FileUserManagement getInstance(){
        return new FileUserManagement();
    }

    @Override
    public void saveToFile(List<User> userList) {
        if (!userList.isEmpty()){
            try {
                String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\data\\user.txt";
                FileWriter fileWriter = new FileWriter(fileName);
                for (User user : userList) {
                    fileWriter.write(user.getFullName() + "-");
                    fileWriter.write(user.getPhoneNumber() + "-");
                    fileWriter.write(user.getEmail() + "-");
                    fileWriter.write(user.getUsername() + "-");
                    fileWriter.write(user.getPassword() + "-");
                    fileWriter.write(user.getPin() + "-");
                    fileWriter.write(user.getBalance() + "|\n");
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
    public List<User> loadFromFile() {
        int count = 0;
        StringBuilder fullName = new StringBuilder();
        StringBuilder phoneNumber = new StringBuilder();
        StringBuilder email = new StringBuilder();
        StringBuilder userName = new StringBuilder();
        StringBuilder password = new StringBuilder();
        StringBuilder pin = new StringBuilder();
        StringBuilder balance = new StringBuilder();
        List<User> userList = new ArrayList<>();

        try {
            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\data\\user.txt";
            FileReader fileReader = new FileReader(fileName);
            while (true){
                int character = fileReader.read();
//                System.out.print((char) character);
                if (character == FileReadUser.END_FILE){
                    break;
                }
                if ((char)character == FileReadUser.DATA_SEPARATION){
                    count++;

                }
                if (count == FileReadUser.READING_FULL_NAME && (char)character != FileReadUser.DATA_SEPARATION && (char)character != FileReadUser.NEW_LINE){
                    fullName.append((char) character);
                }
                else if (count == FileReadUser.READING_PHONE_NUMBER && (char)character != FileReadUser.DATA_SEPARATION){
                    phoneNumber.append((char) character);
                }
                else if (count == FileReadUser.READING_EMAIL && (char)character != FileReadUser.DATA_SEPARATION){
                    email.append((char) character);
                }
                else if (count == FileReadUser.READING_USERNAME && (char)character != FileReadUser.DATA_SEPARATION){
                    userName.append((char) character);
                }
                else if (count == FileReadUser.READING_PASSWORD && (char)character != FileReadUser.DATA_SEPARATION){
                    password.append((char) character);
                }
                else if (count == FileReadUser.READING_PIN && (char)character != FileReadUser.DATA_SEPARATION){
                    pin.append((char) character);
                }
                else if (count == FileReadUser.READING_BALANCE && (char)character != FileReadUser.DATA_SEPARATION && (char)character != FileReadUser.END_ONE_LINE){
                    balance.append((char) character);
                }
                if ((char)character == FileReadUser.END_ONE_LINE){
//                    System.out.println();
//                    System.out.println("Full Name: " + fullName);
//                    System.out.println("Phone: " + phoneNumber);
//                    System.out.println("User Name: " + userName);
//                    System.out.println("Password: " + password);
//                    System.out.println("Pin: " + pin);
//                    System.out.println("Balance: " + balance);

                    userList.add(new User(fullName.toString(), phoneNumber.toString(), email.toString(), userName.toString(), password.toString(), pin.toString(), Double.parseDouble(balance.toString())));

                    count = 0;
                    fullName = new StringBuilder();
                    phoneNumber = new StringBuilder();
                    email = new StringBuilder();
                    userName = new StringBuilder();
                    password = new StringBuilder();
                    pin = new StringBuilder();
                    balance = new StringBuilder();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
