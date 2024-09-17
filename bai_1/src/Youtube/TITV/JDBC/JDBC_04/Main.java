package Youtube.TITV.JDBC.JDBC_04;

import Youtube.TITV.JDBC.JDBC_04.database.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. create connection
            Connection connection = JDBCUtil.getConnection();
            // 2. create statement
            Statement statement = connection.createStatement();
            // 3.execute sql command
            String sql = "INSERT INTO persons(last_name, gender, yob, income)" +
                    "VALUES " + "(\"phuong map dit\", \"F\", \"2003-01-21\", 2000)";
            int check = statement.executeUpdate(sql);
            System.out.println("Số dòng thay đổi: " + check);
            if (check > 0) {
                System.out.println("Thêm data thành công");
            }
            else {
                System.out.println("Thêm data thất baị");
            }
            // 5. disconnect
            JDBCUtil.closeConnection(connection);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
