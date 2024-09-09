package Youtube.TITV.OOP.BookManagement;

public class Book {
    private String name;
    private double price;
    private int yearPublic;
    private Author author;
    public Book(String name, double price, int yearPublic, Author author) {
        this.name = name;
        this.price = price;
        this.yearPublic = yearPublic;
        this.author = author;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void showBookName(){
        System.out.println("Book name: " + this.name);
    }
    public boolean isSameYearPublic(Book otherBook) {
        return this.yearPublic == otherBook.yearPublic;
    }
    public double calculatePriceAfterDiscount(double discountPercent) {
        return this.price - this.price * discountPercent / 100;
    }


}
