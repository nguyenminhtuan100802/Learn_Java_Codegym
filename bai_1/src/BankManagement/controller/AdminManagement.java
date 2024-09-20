package BankManagement.controller;

import BankManagement.service.AdminService;

public class AdminManagement {
    AdminService adminService;
    public AdminManagement() {
        adminService = new AdminService();
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
