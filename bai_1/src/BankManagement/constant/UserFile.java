package BankManagement.constant;

public enum UserFile {
    getInstance();
    public static final int END_FILE = -1;
    public static final int READING_FULL_NAME = 0;
    public static final int READING_PHONE_NUMBER = 1;
    public static final int READING_EMAIL = 2;
    public static final int READING_USERNAME = 3;
    public static final int READING_PASSWORD = 4;
    public static final int READING_PIN = 5;
    public static final int READING_BALANCE = 6;
    public static final char DATA_SEPARATION = '-';
    public static final char END_ONE_LINE = '|';
    public static final char NEW_LINE = '\n';
}
