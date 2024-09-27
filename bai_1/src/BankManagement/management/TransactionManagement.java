package BankManagement.management;

import BankManagement.entity.Transaction;

import java.util.ArrayList;

public class TransactionManagement {
    private ArrayList<Transaction> transactions;
    public TransactionManagement() {
        transactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
