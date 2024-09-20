package BankManagement.model;

public class Admin {
    private Account account = new Account();
    public Admin() {
        this.account.setUsername("admin");
        this.account.setPassword("admin");
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
