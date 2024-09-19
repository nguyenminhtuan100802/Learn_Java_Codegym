package Youtube.TITV.JDBC.JDBC_07.dao;

import Youtube.TITV.JDBC.JDBC_07.dao.DAOInterface;
import Youtube.TITV.JDBC.JDBC_07.model.Book;
import Youtube.TITV.JDBC.JDBC_07.database.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO implements DAOInterface<Book> {

    public static BookDAO getInstance(){
        return new BookDAO();
    }
    @Override
    public int insert(Book book) {
        int result = 0;
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            Statement statement = connection.createStatement();
            // 3. insert sql
            String sql = "INSERT INTO book (id, title, price, yearPublic)  VALUES (\"%s\",  \"%s\", %f, %d)"
                    .formatted(book.getId(),
                            book.getTitle(),
                            book.getPrice(),
                            book.getYearPublic());
            result = statement.executeUpdate(sql);
            // 4. do something
            System.out.println(sql);
            System.out.println(result + " line change");

            // 5. disconnect
            JDBCUtil.closeConnection(connection);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(Book book) {
        int result = 0;
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            Statement statement = connection.createStatement();
            // 3. insert sql
            String sql = "UPDATE book SET title = \"%s\", price = %f, yearPublic = %d WHERE id = \"%s\""
                    .formatted(book.getTitle(),
                            book.getPrice(),
                            book.getYearPublic(),
                            book.getId());
            result = statement.executeUpdate(sql);
            // 4. do something
            System.out.println(sql);
            System.out.println(result + " line change");

            // 5. disconnect
            JDBCUtil.closeConnection(connection);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int delete(Book book) {
        int result = 0;
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            Statement statement = connection.createStatement();
            // 3. insert sql
            String sql = "DELETE FROM book WHERE id = \"%s\""
                    .formatted(book.getId());
            result = statement.executeUpdate(sql);
            // 4. do something
            System.out.println(sql);
            System.out.println(result + " line change");

            // 5. disconnect
            JDBCUtil.closeConnection(connection);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public ArrayList<Book> getAll() {
        ArrayList<Book> result = new ArrayList<Book>();
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            Statement statement = connection.createStatement();
            // 3. insert sql
            String sql = "SELECT * FROM book";
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            // 4. do something
            while (resultSet.next()){
                String id = resultSet.getNString("id");
                String title = resultSet.getNString("title");
                double price = resultSet.getDouble("price");
                int yearPublic = resultSet.getInt("yearPublic");

                result.add(new Book(id, title, price, yearPublic));

            }

            // 5. disconnect
            JDBCUtil.closeConnection(connection);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
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
