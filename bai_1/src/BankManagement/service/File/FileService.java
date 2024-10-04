package BankManagement.service.File;

import BankManagement.management.TransactionManagement;
import BankManagement.management.UserManagement;

public class FileService {
    public static void saveAndLoadData() {
        FileUser.getInstance().saveToFile(UserManagement.getUserArrayList());
        UserManagement.setUserArrayList(FileUser.getInstance().loadFromFile());
        FileTransaction.getInstance().saveToFile(TransactionManagement.getTransactionList());
        TransactionManagement.setTransactionList(FileTransaction.getInstance().loadFromFile());
    }
}
