package Youtube.TITV.JDBC.JDBC_05.dao;

import java.util.ArrayList;

public class CustomerDAO implements DAOInterface{
    public static CustomerDAO getInstance(){
        return new CustomerDAO();
    }
    @Override
    public int insert(Object o) {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public Object selectById(Object o) {
        return null;
    }

    @Override
    public ArrayList selectByCondition(Object o) {
        return null;
    }
}
