package BankManagement.service;

import BankManagement.management.TransactionManagement;
import BankManagement.management.UserManagement;

public class FileService {
    public static void saveAndLoadData() {
        UserFileService.getInstance().saveToFile(UserManagement.getUserArrayList());
        UserManagement.setUserArrayList(UserFileService.getInstance().loadFromFile());
        TransactionFileService.getInstance().saveToFile(TransactionManagement.getTransactionList());
        TransactionManagement.setTransactionList(TransactionFileService.getInstance().loadFromFile());
    }
}
