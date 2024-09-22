package BankManagement.service;

import BankManagement.model.User;
import Youtube.TITV.OOP_Practice.Java61.model.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileService {
    public static void saveUserToFile(ArrayList<User> userArrayList) {
        try {
            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\repository\\user.txt";
            FileWriter fileWriter = new FileWriter(fileName);
            for (int i = 0; i < userArrayList.size(); i++) {
                fileWriter.write(userArrayList.get(i).getFullName() + "-");
                fileWriter.write(userArrayList.get(i).getPhoneNumber() + "-");
                fileWriter.write(userArrayList.get(i).getAccount().getUsername() + "-");
                fileWriter.write(userArrayList.get(i).getAccount().getPassword() + "|\n");
            }
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<User> loadUserFromFile() {
        int count = 0;
        String fullName = "";
        String phoneNumber = "";
        String userName = "";
        String password = "";
        ArrayList<User> userArrayList = new ArrayList<>();

        try {
            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\repository\\user.txt";
            FileReader fileReader = new FileReader(fileName);
            while (true){
                int character = fileReader.read();
//                System.out.print((char) character);
                if (character == -1){
                    break;
                }
                if ((char)character == '-'){
                    count++;

                }
                if (count == 0 && (char)character != '-' && (char)character != '\n'){
                    fullName += (char)character;
                }
                else if (count == 1 && (char)character != '-'){
                    phoneNumber += (char)character;
                }
                else if (count == 2 && (char)character != '-'){
                    userName += (char)character;
                }
                else if (count == 3 && (char)character != '-' && (char)character != '|'){
                    password += (char)character;
                }
                if ((char)character == '|'){
//                    System.out.println();
//                    System.out.println("Full Name: " + fullName);
//                    System.out.println("Phone: " + phoneNumber);
//                    System.out.println("User Name: " + userName);
//                    System.out.println("Password: " + password);

                    userArrayList.add(new User(fullName, phoneNumber, userName, password));

                    count = 0;
                    fullName = "";
                    phoneNumber = "";
                    userName = "";
                    password = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userArrayList;
    }
}
