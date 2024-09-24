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
                fileWriter.write(userArrayList.get(i).getAccount().getPassword() + "-");
                fileWriter.write(userArrayList.get(i).getAccount().getPin() + "-");
                fileWriter.write(userArrayList.get(i).getAccount().getBalance() + "|\n");
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
        String pin = "";
        String balance = "";
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
                else if (count == 3 && (char)character != '-'){
                    password += (char)character;
                }
                else if (count == 4 && (char)character != '-'){
                    pin += (char)character;
                }
                else if (count == 5 && (char)character != '-' && (char)character != '|'){
                    balance += (char)character;
                }
                if ((char)character == '|'){
//                    System.out.println();
//                    System.out.println("Full Name: " + fullName);
//                    System.out.println("Phone: " + phoneNumber);
//                    System.out.println("User Name: " + userName);
//                    System.out.println("Password: " + password);
//                    System.out.println("Pin: " + pin);
//                    System.out.println("Balance: " + balance);

                    userArrayList.add(new User(fullName, phoneNumber, userName, password, pin, Double.parseDouble(balance)));

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
