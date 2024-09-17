package Youtube.TITV.JDBC.JDBC_05.dao;

import Youtube.TITV.JDBC.JDBC_05.model.Book;

import java.util.ArrayList;

public class BookDAO implements DAOInterface<Book> {

    public static BookDAO getInstance(){
        return new BookDAO();
    }
    @Override
    public int insert(Book book) {
        return 0;
    }

    @Override
    public int update(Book book) {
        return 0;
    }

    @Override
    public int delete(Book book) {
        return 0;
    }

    @Override
    public ArrayList<Book> getAll() {
        return null;
    }

    @Override
    public Book selectById(Book book) {
        return null;
    }

    @Override
    public ArrayList<Book> selectByCondition(Book book) {
        return null;
    }
}
