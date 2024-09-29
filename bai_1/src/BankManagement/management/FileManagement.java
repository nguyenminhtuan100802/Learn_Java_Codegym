package BankManagement.management;

import BankManagement.entity.RegisterForm;
import BankManagement.entity.Transaction;
import BankManagement.entity.User;
import BankManagement.utility.File.FileReadUser;

import java.io.*;
import java.util.ArrayList;

public class FileManagement {
    public static void saveUserToFile(ArrayList<User> userArrayList) {
        if (!userArrayList.isEmpty()){
            try {
                String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\data\\user.txt";
                FileWriter fileWriter = new FileWriter(fileName);
                for (int i = 0; i < userArrayList.size(); i++) {
                    fileWriter.write(userArrayList.get(i).getFullName() + "-");
                    fileWriter.write(userArrayList.get(i).getPhoneNumber() + "-");
                    fileWriter.write(userArrayList.get(i).getEmail() + "-");
                    fileWriter.write(userArrayList.get(i).getUsername() + "-");
                    fileWriter.write(userArrayList.get(i).getPassword() + "-");
                    fileWriter.write(userArrayList.get(i).getPin() + "-");
                    fileWriter.write(userArrayList.get(i).getBalance() + "|\n");
                }
                fileWriter.flush();
                fileWriter.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static ArrayList<User> loadUserFromFile() {
        int count = 0;
        StringBuilder fullName = new StringBuilder();
        StringBuilder phoneNumber = new StringBuilder();
        StringBuilder email = new StringBuilder();
        StringBuilder userName = new StringBuilder();
        StringBuilder password = new StringBuilder();
        StringBuilder pin = new StringBuilder();
        StringBuilder balance = new StringBuilder();
        ArrayList<User> userArrayList = new ArrayList<>();

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

                    userArrayList.add(new User(fullName.toString(), phoneNumber.toString(), email.toString(), userName.toString(), password.toString(), pin.toString(), Double.parseDouble(balance.toString())));

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
        return userArrayList;
    }
    public static void saveTransactionToFile(ArrayList<Transaction> transactionArrayList) {
        if (!transactionArrayList.isEmpty()){
            try {
                String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\data\\transaction_history.txt";
                FileWriter fileWriter = new FileWriter(fileName);
                for (int i = 0; i < transactionArrayList.size(); i++) {
                    fileWriter.write(transactionArrayList.get(i).getUserTransact() + "-");
                    fileWriter.write(transactionArrayList.get(i).getId() + "-");
                    fileWriter.write(transactionArrayList.get(i).getAmountOfTransactMoney() + "-");
                    fileWriter.write(transactionArrayList.get(i).getBalanceBeforeTransaction() + "-");
                    fileWriter.write(transactionArrayList.get(i).getBalanceAfterTransaction() + "-");
                    fileWriter.write(transactionArrayList.get(i).getDescription() + "|\n");
                }
                fileWriter.flush();
                fileWriter.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static ArrayList<Transaction> loadTransactionFromFile() {
        int count = 0;
        StringBuilder transactionExecutionAccount = new StringBuilder();
        StringBuilder idTransaction = new StringBuilder();
        StringBuilder amountOfMoneyTransact = new StringBuilder();
        StringBuilder amountOfBalanceBeforeTransact = new StringBuilder();
        StringBuilder amountOfBalanceAfterTransact = new StringBuilder();
        StringBuilder description = new StringBuilder();
        ArrayList<Transaction> transactionArrayList = new ArrayList<>();
        try {
            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\data\\transaction_history.txt";
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
                    transactionExecutionAccount.append((char) character);
                }
                else if (count == 1 && (char)character != '-'){
                    idTransaction.append((char) character);
                }
                else if (count == 2 && (char)character != '-'){
                    amountOfMoneyTransact.append((char) character);
                }
                else if (count == 3 && (char)character != '-'){
                    amountOfBalanceBeforeTransact.append((char) character);
                }
                else if (count == 4 && (char)character != '-'){
                    amountOfBalanceAfterTransact.append((char) character);
                }
                else if (count == 5 && (char)character != '-' && (char)character != '|'){
                    description.append((char) character);
                }
                if ((char)character == '|'){
//                    System.out.println();
//                    System.out.println("transactionExecutionAccount: " + transactionExecutionAccount);
//                    System.out.println("idTransaction: " + idTransaction);
//                    System.out.println("amountOfMoneyTransact: " + amountOfMoneyTransact);
//                    System.out.println("amountOfBalanceBeforeTransact: " + amountOfBalanceBeforeTransact);
//                    System.out.println("amountOfBalanceAfterTransact: " + amountOfBalanceAfterTransact);
//                    System.out.println("description: " + description);

                    transactionArrayList.add(new Transaction(
                            transactionExecutionAccount.toString(),
                            idTransaction.toString(),
                            Double.parseDouble(amountOfMoneyTransact.toString()),
                            Double.parseDouble(amountOfBalanceBeforeTransact.toString()),
                            Double.parseDouble(amountOfBalanceAfterTransact.toString()),
                            description.toString()));

                    count = 0;
                    transactionExecutionAccount = new StringBuilder();
                    idTransaction = new StringBuilder();
                    amountOfMoneyTransact = new StringBuilder();
                    amountOfBalanceBeforeTransact = new StringBuilder();
                    amountOfBalanceAfterTransact = new StringBuilder();
                    description = new StringBuilder();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactionArrayList;
    }
    public static void saveRegisterFormToFile(ArrayList<RegisterForm> registerFormArrayList) {
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
}
