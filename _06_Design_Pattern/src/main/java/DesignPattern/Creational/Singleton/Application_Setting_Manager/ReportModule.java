package DesignPattern.Creational.Singleton.Application_Setting_Manager;

class ReportsModule {
    void displaySettings() {
        AppSettings settings = AppSettings.getInstance();
        System.out.println("Reports Module: " + settings.getAppName());
    }
}

