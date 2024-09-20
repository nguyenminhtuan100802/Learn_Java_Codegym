package Youtube.TITV.OOP_Practice.Java61.controller;

import Youtube.TITV.OOP_Practice.Java61.const_variable.choice.*;
import Youtube.TITV.OOP_Practice.Java61.controller.menu.MenuAdmin;
import Youtube.TITV.OOP_Practice.Java61.model.Admin;
import Youtube.TITV.OOP_Practice.Java61.service.AdminService;

import java.util.Scanner;

public class AdminManagement {
    private final AdminService adminService;
    public AdminManagement() {
        this.adminService = new AdminService();
    }

    public AdminService getAdminService() {
        return adminService;
    }
}
