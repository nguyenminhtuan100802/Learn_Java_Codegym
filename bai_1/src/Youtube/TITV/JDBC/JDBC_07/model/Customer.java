package Youtube.TITV.JDBC.JDBC_07.model;

import java.sql.Date;

public class Customer {
    private int id;
    private String fullName;
    private Date yob;

    public Customer(int id, String fullName, Date yob) {
        this.id = id;
        this.fullName = fullName;
        this.yob = yob;
    }
}
