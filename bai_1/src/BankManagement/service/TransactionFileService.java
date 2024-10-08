package BankManagement.service;

import BankManagement.constant.TransactionFile;
import BankManagement.entity.Transaction;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileService implements File<List<Transaction>> {
    public static TransactionFileService getInstance(){
        return new TransactionFileService();
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
                if (character == TransactionFile.END_FILE){
                    break;
                }
                if ((char)character == TransactionFile.DATA_SEPARATION){
                    count++;
                }
                if (count == TransactionFile.TRANSACTION_ACCOUNT && (char)character != TransactionFile.DATA_SEPARATION && (char)character != TransactionFile.NEW_LINE){
                    transactionExecutionAccount.append((char) character);
                }
                else if (count == TransactionFile.TRANSACTION_ID && (char)character != TransactionFile.DATA_SEPARATION){
                    idTransaction.append((char) character);
                }
                else if (count == TransactionFile.MONEY_TRACT && (char)character != TransactionFile.DATA_SEPARATION){
                    amountOfMoneyTransact.append((char) character);
                }
                else if (count == TransactionFile.BALANCE_BEFORE_TRANSACTION && (char)character != TransactionFile.DATA_SEPARATION){
                    amountOfBalanceBeforeTransact.append((char) character);
                }
                else if (count == TransactionFile.BALANCE_AFTER_TRANSACTION && (char)character != TransactionFile.DATA_SEPARATION){
                    amountOfBalanceAfterTransact.append((char) character);
                }
                else if (count == TransactionFile.DESCRIPTION && (char)character != TransactionFile.DATA_SEPARATION && (char)character != TransactionFile.END_ONE_LINE){
                    description.append((char) character);
                }
                if ((char)character == TransactionFile.END_ONE_LINE){
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
