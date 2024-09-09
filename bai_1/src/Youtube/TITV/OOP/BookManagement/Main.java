package Youtube.TITV.OOP.BookManagement;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(10, 8, 2002);
        Date date1 = new Date(12, 10, 2004);

        Author author = new Author("tuan", date);
        Author author1 = new Author("heo", date1);

        Book book = new Book("conan", 1000, 2000, author);
        Book book1 = new Book("doremon", 10, 2001, author1);

        book.showBookName();
        book1.showBookName();

        System.out.println("book is same year public with book1: " + book.isSameYearPublic(book1));
        System.out.println("price book after discount: " + book.calculatePriceAfterDiscount(10));

    }
}
