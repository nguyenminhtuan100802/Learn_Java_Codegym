package Document.TITV.JDBC.JDBC_04.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection connection = null;

        try {
            // register mysql
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/ontap";
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

    public static void printInfo(Connection connection){
        if (connection != null) {
            try {
                DatabaseMetaData mtdt = connection.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
