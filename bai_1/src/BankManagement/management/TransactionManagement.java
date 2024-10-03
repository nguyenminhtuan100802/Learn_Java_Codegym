package BankManagement.management;

import BankManagement.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionManagement {
    private static List<Transaction> transactionList = new ArrayList<>();

    public static List<Transaction> getTransactionList() {
        return transactionList;
    }

    public static void setTransactionList(List<Transaction> transactionList) {
        TransactionManagement.transactionList = transactionList;
    }

    public static void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }
}
