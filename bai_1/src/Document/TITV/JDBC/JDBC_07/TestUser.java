package Document.TITV.JDBC.JDBC_07;

import Document.TITV.JDBC.JDBC_07.dao.UserDAO;
import Document.TITV.JDBC.JDBC_07.model.User;

public class TestUser {
    public static void main(String[] args) {
        User user = new User("tu123", "tu123", "tu do");
        UserDAO.getInstance().insert(user);
    }
}
