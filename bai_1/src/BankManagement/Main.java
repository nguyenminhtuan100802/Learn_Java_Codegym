package BankManagement;

import BankManagement.menu.LoginMenu;
import BankManagement.service.FormatMoneyService;

public class Main {
    public static void main(String[] args) {
        LoginMenu.getInstance().displayMenu();
//        System.out.println(FormatMoneyService.formatMoney(+15000));

    }
}
