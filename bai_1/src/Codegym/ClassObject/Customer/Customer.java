package Codegym.ClassObject.Customer;

public class Customer {
    private String customerName;
    private int customerId;
    private String email;
    private int mobile;
    private String address;

    public Customer(String customerName, int customerId, String email, int mobile, String address) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }
    public void register(){}
    public void login() {}
    public void updateProfile() {}
}
