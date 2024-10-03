package BankManagement.entity;

public class User extends Account{
    private String fullName;
    private String phoneNumber;
    private String email;
    public User(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.id = phoneNumber;
        this.username = phoneNumber;
        this.password = phoneNumber;
        this.email = email;
    }
    public User(String fullName, String phoneNumber, String email, String username, String password, String pin, double balance) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.id = phoneNumber;
        this.username = username;
        this.password = password;
        this.pin = pin;
        this.balance = balance;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
