package BankManagement.service;

import BankManagement.model.Transaction;
import BankManagement.model.User;
import Youtube.TITV.OOP_Practice.Java61.model.Student;

import java.io.*;
import java.util.ArrayList;

public class FileService {
    public static void saveUserToFile(ArrayList<User> userArrayList) {
        if (!userArrayList.isEmpty()){
            try {
                String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\repository\\user.txt";
                FileWriter fileWriter = new FileWriter(fileName);
                for (int i = 0; i < userArrayList.size(); i++) {
                    fileWriter.write(userArrayList.get(i).getFullName() + "-");
                    fileWriter.write(userArrayList.get(i).getPhoneNumber() + "-");
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
        StringBuilder userName = new StringBuilder();
        StringBuilder password = new StringBuilder();
        StringBuilder pin = new StringBuilder();
        StringBuilder balance = new StringBuilder();
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
                    fullName.append((char) character);
                }
                else if (count == 1 && (char)character != '-'){
                    phoneNumber.append((char) character);
                }
                else if (count == 2 && (char)character != '-'){
                    userName.append((char) character);
                }
                else if (count == 3 && (char)character != '-'){
                    password.append((char) character);
                }
                else if (count == 4 && (char)character != '-'){
                    pin.append((char) character);
                }
                else if (count == 5 && (char)character != '-' && (char)character != '|'){
                    balance.append((char) character);
                }
                if ((char)character == '|'){
//                    System.out.println();
//                    System.out.println("Full Name: " + fullName);
//                    System.out.println("Phone: " + phoneNumber);
//                    System.out.println("User Name: " + userName);
//                    System.out.println("Password: " + password);
//                    System.out.println("Pin: " + pin);
//                    System.out.println("Balance: " + balance);

                    userArrayList.add(new User(fullName.toString(), phoneNumber.toString(), userName.toString(), password.toString(), pin.toString(), Double.parseDouble(balance.toString())));

                    count = 0;
                    fullName = new StringBuilder();
                    phoneNumber = new StringBuilder();
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
    public static void saveTransactionToFile(TransactionService transactionService) {
        if (!transactionService.getTransactions().isEmpty()){
            try {
                String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\repository\\transaction_history.txt";
                FileWriter fileWriter = new FileWriter(fileName);
                for (int i = 0; i < transactionService.getTransactions().size(); i++) {
                    fileWriter.write(transactionService.getTransactions().get(i).getUserTransact() + "-");
                    fileWriter.write(transactionService.getTransactions().get(i).getId() + "-");
                    fileWriter.write(transactionService.getTransactions().get(i).getAmountOfTransactMoney() + "-");
                    fileWriter.write(transactionService.getTransactions().get(i).getBalanceBeforeTransaction() + "-");
                    fileWriter.write(transactionService.getTransactions().get(i).getBalanceAfterTransaction() + "-");
                    fileWriter.write(transactionService.getTransactions().get(i).getDescription() + "|\n");
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
            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\repository\\transaction_history.txt";
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

//                    for (int i = 0; i < userArrayList.size(); i++) {
//                        if (userArrayList.get(i).getPhoneNumber().equals(transactionExecutionAccount)){
//                            userArrayList.get(i).getAccount().getTransactionService().addTransaction(new Transaction(
//                                    transactionExecutionAccount,
//                                    idTransaction,
//                                    Double.parseDouble(amountOfMoneyTransact),
//                                    Double.parseDouble(amountOfBalanceBeforeTransact),
//                                    Double.parseDouble(amountOfBalanceAfterTransact),
//                                    description));
//                            break;
//                        }
//                    }
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
}
