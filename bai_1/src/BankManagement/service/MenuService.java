package BankManagement.service;

public class MenuService {
    private static StringBuilder tab;
    public static void refreshMenu() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public static void moveMenuDown2Times() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }
    public static String displayTab60Times() {
        tab = new StringBuilder();
        tab.append("=".repeat(60));
        return tab.toString();
    }
    public static String tab160Times() {
        tab = new StringBuilder();
        tab.append("-".repeat(160));
        return tab.toString();
    }
}
