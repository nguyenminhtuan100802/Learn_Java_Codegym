package BankManagement.model;

public class Transaction {
    private String userTransact;
    private String id;
    private double amountOfTransactMoney;
    private double balanceBeforeTransaction;
    private double balanceAfterTransaction;
    private String description;
    public Transaction(String userTransact, String id, double amountOfTransactMoney, double balanceBeforeTransaction, double balanceAfterTransaction, String description) {
        this.userTransact = userTransact;
        this.id = id;
        this.amountOfTransactMoney = amountOfTransactMoney;
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.description = description;
    }

    public String getUserTransact() {
        return userTransact;
    }

    public void setUserTransact(String userTransact) {
        this.userTransact = userTransact;
    }

    public double getBalanceBeforeTransaction() {
        return balanceBeforeTransaction;
    }

    public void setBalanceBeforeTransaction(double balanceBeforeTransaction) {
        this.balanceBeforeTransaction = balanceBeforeTransaction;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setBalanceAfterTransaction(double balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmountOfTransactMoney() {
        return amountOfTransactMoney;
    }

    public void setAmountOfTransactMoney(double amountOfTransactMoney) {
        this.amountOfTransactMoney = amountOfTransactMoney;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amountOfTransactMoney=" + amountOfTransactMoney +
                ", description='" + description + '\'' +
                '}';
    }
}
