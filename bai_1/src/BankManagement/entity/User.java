package BankManagement.entity;

public class User extends Account{
    private String fullName;
    private String phoneNumber;
    private String id;
    public User(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.id = phoneNumber;
        this.username = fullName + phoneNumber;
        this.password = fullName + phoneNumber;
    }
    public User(String fullName, String phoneNumber, String username, String password, String pin, double balance) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.id = phoneNumber;
        this.username = username;
        this.password = password;
        this.pin = pin;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "fullName: " + fullName + " || phoneNumber: " + phoneNumber + " || id: " + id + " || username: " + username + " || password: " + password;
    }

}
