package Document.TITV.JDBC.JDBC_07.dao;

import Document.TITV.JDBC.JDBC_07.database.JDBCUtil;
import Document.TITV.JDBC.JDBC_07.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User> {
    public static UserDAO getInstance(){
        return new UserDAO();
    }
    @Override
    public int insert(User user) {
        int result = 0;
        try {
            // 1. create connection to database
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement object
            String sql = "INSERT INTO user (userName, password, fullName) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            // 3. execute sql command
            result = preparedStatement.executeUpdate();
            // 4. do something
            System.out.println(">>Execute command: " + sql);
            System.out.println(result + " line change");
            // 5. disconnect to database
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(User user) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "UPDATE user SET password = ?, fullName = ? WHERE userName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getUsername());

            result = preparedStatement.executeUpdate();
            System.out.println(">>Execute command: " + sql);
            System.out.println(result + " line change");
            // 5. disconnect
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int delete(User user) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "DELETE FROM user WHERE userName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            result = preparedStatement.executeUpdate();
            System.out.println(">>Execute command: " + sql);
            System.out.println(result + " line change");
            // 5. disconnect
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> result = new ArrayList<User>();
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            String sql = "SELECT * FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            // 4. do something
            while (resultSet.next()){
                String userName = resultSet.getNString("userName");
                String password = resultSet.getNString("password");
                String fullName = resultSet.getNString("fullName");
                result.add(new User(userName, password, fullName));
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
    public User selectById(User user) {
        return null;
    }

    @Override
    public ArrayList<User> selectByCondition(User user) {
        return null;
    }
}
