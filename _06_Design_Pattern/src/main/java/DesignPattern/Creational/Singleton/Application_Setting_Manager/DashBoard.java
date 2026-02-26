package DesignPattern.Creational.Singleton.Application_Setting_Manager;

class DashboardModule {
    void displaySettings() {
        AppSettings settings = AppSettings.getInstance();
        System.out.println("Dashboard Module: " + settings.getEnvironment());
    }
}

