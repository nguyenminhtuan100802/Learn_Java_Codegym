package Youtube.TITV.JDBC.JDBC_06.dao;

import Youtube.TITV.JDBC.JDBC_06.dao.DAOInterface;
import Youtube.TITV.JDBC.JDBC_06.model.Book;
import Youtube.TITV.JDBC.JDBC_06.database.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO implements DAOInterface<Book> {

    public static BookDAO getInstance(){
        return new BookDAO();
    }
    @Override
    public int insert(Book book) {
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            Statement statement = connection.createStatement();
            // 3. insert sql
            String sql = "INSERT INTO book (id, title, price, yearPublic) " +
                    " VALUES (\"" + book.getId() + "\",  \""
                    + book.getTitle() + "\", "
                    + book.getPrice() + ", "
                    + book.getYearPublic() + ")";
            int result = statement.executeUpdate(sql);
            // 4. do something
            System.out.println(sql);
            System.out.println(result + " line change");

            // 5. disconnect
            JDBCUtil.closeConnection(connection);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
