package BankManagement.utility.File;

public interface FileReadUser {
    int END_FILE = -1;
    int READING_FULL_NAME = 0;
    int READING_PHONE_NUMBER = 1;
    int READING_EMAIL = 2;
    int READING_USERNAME = 3;
    int READING_PASSWORD = 4;
    int READING_PIN = 5;
    int READING_BALANCE = 6;
    char DATA_SEPARATION = '-';
    char END_ONE_LINE = '|';
    char NEW_LINE = '\n';
}
