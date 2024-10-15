package BankManagement.constant;

public enum TransactionFile {
    getInstance();
    public static final int END_FILE = -1;
    public static final int TRANSACTION_ACCOUNT = 0;
    public static final int TRANSACTION_ID = 1;
    public static final int MONEY_TRACT = 2;
    public static final int BALANCE_BEFORE_TRANSACTION = 3;
    public static final int BALANCE_AFTER_TRANSACTION = 4;
    public static final int DESCRIPTION = 5;
    public static final char DATA_SEPARATION = ',';
    public static final char END_ONE_LINE = '|';
    public static final char NEW_LINE = '\n';
}
