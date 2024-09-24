package BankManagement.model;

public class User {
    private String fullName;
    private String phoneNumber;
    private Account account = new Account();
    public User(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.account.setUsername(fullName + phoneNumber);
        this.account.setPassword(fullName + phoneNumber);
    }
    public User(String fullName, String phoneNumber, String username, String password, String pin, double balance) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.account.setUsername(username);
        this.account.setPassword(password);
        this.account.setPin(pin);
        this.account.setBalance(balance);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "fullName: " + fullName + " || phoneNumber: " + phoneNumber + " || username: " + account.getUsername() + " || password: " + account.getPassword();
    }

}
