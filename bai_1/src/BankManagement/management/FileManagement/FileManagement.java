package BankManagement.management.FileManagement;

public interface FileManagement<T>{
    void saveToFile(T t);
    T loadFromFile();

}
