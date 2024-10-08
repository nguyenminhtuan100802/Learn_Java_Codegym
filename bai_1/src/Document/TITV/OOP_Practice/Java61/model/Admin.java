package Document.TITV.OOP_Practice.Java61.model;

public class Admin {
    private Account account = new Account();

    public Admin() {
        this.account.setUserName("admin");
        this.account.setPassword("admin");
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
