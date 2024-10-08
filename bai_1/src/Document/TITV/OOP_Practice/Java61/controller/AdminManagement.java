package Document.TITV.OOP_Practice.Java61.controller;

import Document.TITV.OOP_Practice.Java61.service.AdminService;

public class AdminManagement {
    private final AdminService adminService;
    public AdminManagement() {
        this.adminService = new AdminService();
    }

    public AdminService getAdminService() {
        return adminService;
    }
}
