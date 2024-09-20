package BankManagement.service;

import BankManagement.model.Admin;

import java.util.Scanner;

public class AdminService {
    Admin admin;
    public AdminService() {
        this.admin = new Admin();
    }
    public boolean loginVerify(){
        System.out.print("Enter username:");
        String username = new Scanner(System.in).nextLine();
        System.out.print("Enter password:");
        String password = new Scanner(System.in).nextLine();
        if (this.admin.getAccount().getUsername().equals(username) && this.admin.getAccount().getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public void manage(){
        System.out.println("Admin login successfully");
    }

}
