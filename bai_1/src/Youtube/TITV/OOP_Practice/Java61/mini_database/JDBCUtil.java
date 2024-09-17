package Youtube.TITV.OOP_Practice.Java61.mini_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection connection = null;

        try {
            // register mysql
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/student_management";
            String user = "root";
            String password = "";

            // create connection
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return connection;
    }
    public static void closeConnection(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
