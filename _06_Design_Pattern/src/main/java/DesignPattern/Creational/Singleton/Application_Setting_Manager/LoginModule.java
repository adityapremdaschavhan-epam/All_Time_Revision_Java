package DesignPattern.Creational.Singleton.Application_Setting_Manager;

class LoginModule {
    void displaySettings() {
        AppSettings settings = AppSettings.getInstance();
        System.out.println("Login Module: " + settings.getAppName());
    }
}

