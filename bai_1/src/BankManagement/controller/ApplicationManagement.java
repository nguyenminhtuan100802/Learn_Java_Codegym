package BankManagement.controller;

import BankManagement.service.ApplicationService;

public class ApplicationManagement {
    ApplicationService applicationService;
    public ApplicationManagement(){
        applicationService = new ApplicationService();
    }

    public ApplicationService getApplicationService() {
        return applicationService;
    }

    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
}
