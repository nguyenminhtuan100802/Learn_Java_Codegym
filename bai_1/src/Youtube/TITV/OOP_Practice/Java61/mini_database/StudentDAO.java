package Youtube.TITV.OOP_Practice.Java61.mini_database;

import Youtube.TITV.JDBC.JDBC_06.dao.BookDAO;
import Youtube.TITV.OOP_Practice.Java61.mini_database.JDBCUtil;
import Youtube.TITV.JDBC.JDBC_06.model.Book;
import Youtube.TITV.OOP_Practice.Java61.user.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO implements DAOInterface<Student> {
    public static StudentDAO getInstance(){
        return new StudentDAO();
    }
    @Override
    public int insert(Student student) {
        int result = 0;
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            Statement statement = connection.createStatement();
            // 3. insert sql
            String sql = ("INSERT INTO students (id, fullName, yearOfBirth, averageScore, userName, password) " +
                    " VALUES (\"%s\", \"%s\", %d, %f, \"%s\", \"%s\")")
                    .formatted(student.getId(),
                            student.getFullName(),
                            student.getYearOfBirth(),
                            student.getAverageScore(),
                            student.getAccount().getUserName(),
                            student.getAccount().getPassword());
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
    public int update(Student student) {
        return 0;
    }
    public int updateId(String newId) {
        return 0;
    }

    @Override
    public int delete(Student student) {
        return 0;
    }
    public int deleteById(String newId) {
        int result = 0;
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            Statement statement = connection.createStatement();
            // 3. insert sql
            String sql = "DELETE FROM students WHERE id = \"%s\""
                    .formatted(newId);
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
    public ArrayList<Student> getAll() {
        ArrayList<Student> result = new ArrayList<Student>();
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            Statement statement = connection.createStatement();
            // 3. insert sql
            String sql = "SELECT * FROM students";
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            // 4. do something
            while (resultSet.next()){
                String id = resultSet.getNString("id");
                String fullName = resultSet.getNString("fullName");
                int yearOfBirth = resultSet.getInt("yearOfBirth");
                double averageScore = resultSet.getDouble("averageScore");
                String userName = resultSet.getNString("userName");
                String password = resultSet.getNString("password");

                result.add(new Student(id, fullName, yearOfBirth, averageScore, userName, password));
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
    public Student selectById(Student student) {
        return null;
    }

    @Override
    public ArrayList<Student> selectByCondition(Student student) {
        return null;
    }
}
