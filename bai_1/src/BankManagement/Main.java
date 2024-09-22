package BankManagement;

import BankManagement.controller.ApplicationManagement;

public class Main {
    public static void main(String[] args) {
        ApplicationManagement applicationManagement = new ApplicationManagement();
        applicationManagement.getApplicationService().run();
    }
}
