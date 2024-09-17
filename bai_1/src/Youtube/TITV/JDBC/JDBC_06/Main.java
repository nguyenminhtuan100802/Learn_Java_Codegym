package Youtube.TITV.JDBC.JDBC_06;

import Youtube.TITV.JDBC.JDBC_06.database.JDBCUtil;
import Youtube.TITV.JDBC.JDBC_06.dao.BookDAO;
import Youtube.TITV.JDBC.JDBC_06.model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java", "Programing Java", 100.0, 2020);
        Book book2 = new Book("C++", "Programing Java Pro+", 150.0, 2018);

        BookDAO.getInstance().insert(book2);
    }
}
