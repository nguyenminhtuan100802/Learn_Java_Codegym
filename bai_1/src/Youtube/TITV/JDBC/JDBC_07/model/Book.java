package Youtube.TITV.JDBC.JDBC_07.model;

public class Book {
    private String id;
    private String title;
    private double price;
    private int yearPublic;

    public Book() {}
    public Book(String id, String title, double price, int yearPublic) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.yearPublic = yearPublic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearPublic() {
        return yearPublic;
    }

    public void setYearPublic(int yearPublic) {
        this.yearPublic = yearPublic;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", yearPublic=" + yearPublic +
                '}';
    }
}
