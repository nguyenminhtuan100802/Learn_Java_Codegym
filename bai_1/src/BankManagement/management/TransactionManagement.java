package BankManagement.management;

import BankManagement.entity.Transaction;

import java.util.ArrayList;

public class TransactionManagement {
    public static ArrayList<Transaction> transactionArrayList = new ArrayList<>();

    public static void addTransaction(Transaction transaction) {
        transactionArrayList.add(transaction);
    }
}
