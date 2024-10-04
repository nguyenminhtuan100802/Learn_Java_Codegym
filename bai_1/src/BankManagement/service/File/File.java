package BankManagement.service.File;

public interface File<T>{
    void saveToFile(T t);
    T loadFromFile();

}
