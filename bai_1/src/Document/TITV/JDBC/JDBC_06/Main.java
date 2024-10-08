package Document.TITV.JDBC.JDBC_06;

import Document.TITV.JDBC.JDBC_06.dao.BookDAO;
import Document.TITV.JDBC.JDBC_06.model.Book;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Book book1 = new Book("Java", "Programing Java", 100.0, 2020);
//        Book book2 = new Book("C++", "Programing Java Pro+", 150.0, 2018);
//
////        BookDAO.getInstance().insert(book2);
//        for (int i = 1; i <= 10; i++) {
//            Book book = new Book("HTML Edition " + i, "Programing Java For Beginner", 100 + i, 2020);
//            BookDAO.getInstance().insert(book);
//        }
//        Book book2 = new Book("C++", "Programing C++ Pro+", 50.0, 2024);
//        BookDAO.getInstance().update(book2);
//        for (int i = 1; i <= 10; i++) {
//            Book book = new Book("HTML Edition " + i, "Programing Java For Beginner", 100 + i, 2020);
//            BookDAO.getInstance().delete(book);
//        }
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        bookArrayList = BookDAO.getInstance().getAll();
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println(bookArrayList.get(i).toString());
        }
    }
}
