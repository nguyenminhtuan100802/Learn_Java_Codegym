package Youtube.TITV.JDBC.JDBC_06.dao;

import Youtube.TITV.JDBC.JDBC_06.dao.DAOInterface;
import Youtube.TITV.JDBC.JDBC_06.model.Customer;

import java.util.ArrayList;

public class CustomerDAO implements DAOInterface<Customer> {
    public static CustomerDAO getInstance(){
        return new CustomerDAO();
    }

    @Override
    public int insert(Customer customer) {
        return 0;
    }

    @Override
    public int update(Customer customer) {
        return 0;
    }

    @Override
    public int delete(Customer customer) {
        return 0;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }

    @Override
    public Customer selectById(Customer customer) {
        return null;
    }

    @Override
    public ArrayList<Customer> selectByCondition(Customer customer) {
        return null;
    }
}
