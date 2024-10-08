package Document.TITV.OOP_Practice.Java61.repository;

import java.util.ArrayList;

public interface DAOInterface<T> {
    public int insert(T t);
    public int update(T t);
    public int delete(T t);
    public ArrayList<T> getAll();
    public T selectById(T t);
    public ArrayList<T> selectByCondition(T t);
}
