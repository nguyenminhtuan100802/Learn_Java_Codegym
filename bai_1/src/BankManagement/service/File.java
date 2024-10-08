package BankManagement.service;

public interface File<T>{
    void saveToFile(T t);
    T loadFromFile();

}
