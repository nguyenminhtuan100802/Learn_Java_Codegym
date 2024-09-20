package BankManagement.model;

public class User {
    private String fullName;
    private String phoneNumber;
    private Account account;
    public User(String fullName, String phoneNumber, Account account) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.account = account;
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
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", account=" + account +
                '}';
    }
}
