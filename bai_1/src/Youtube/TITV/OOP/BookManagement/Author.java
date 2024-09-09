package Youtube.TITV.OOP.BookManagement;

public class Author {
    private String name;
    private Date date;
    public Author(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
