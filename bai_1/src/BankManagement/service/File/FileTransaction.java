package BankManagement.service.File;

import BankManagement.entity.Transaction;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileTransaction implements File<List<Transaction>> {
    public static FileTransaction getInstance(){
        return new FileTransaction();
    }

    @Override
    public void saveToFile(List<Transaction> transactionList) {
        if (!transactionList.isEmpty()){
            try {
                String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\BankManagement\\data\\transaction_history.txt";
                FileWriter fileWriter = new FileWriter(fileName);
                for (Transaction transaction : transactionList) {
                    fileWriter.write(transaction.getUserTransact() + "-");
                    fileWriter.write(transaction.getId() + "-");
                    fileWriter.write(transaction.getAmountOfTransactMoney() + "-");
                    fileWriter.write(transaction.getBalanceBeforeTransaction() + "-");
                    fileWriter.write(transaction.getBalanceAfterTransaction() + "-");
                    fileWriter.write(transaction.getDescription() + "|\n");
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
    public List<Transaction> loadFromFile() {
        int count = 0;
        StringBuilder transactionExecutionAccount = new StringBuilder();
        StringBuilder idTransaction = new StringBuilder();
        StringBuilder amountOfMoneyTransact = new StringBuilder();
        StringBuilder amountOfBalanceBeforeTransact = new StringBuilder();
        StringBuilder amountOfBalanceAfterTransact = new StringBuilder();
        StringBuilder description = new StringBuilder();
        List<Transaction> transactionList = new ArrayList<>();
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

                    transactionList.add(new Transaction(
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
        return transactionList;
    }
}
