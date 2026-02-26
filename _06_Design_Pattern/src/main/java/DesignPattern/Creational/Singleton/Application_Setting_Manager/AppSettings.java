package DesignPattern.Creational.Singleton.Application_Setting_Manager;

class AppSettings {

    // Step 1: static instance (class-level, single copy)
    private static AppSettings instance;

    // Step 2: configuration data
    private String appName;
    private String environment;

    // Step 3: private constructor
    private AppSettings() {
        this.appName = "MyApplication";
        this.environment = "PROD";
        System.out.println("Settings loaded once");
    }

    // Step 4: global access point
    public static AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    // Step 5: getters (read-only access)
    public String getAppName() {
        return appName;
    }

    public String getEnvironment() {
        return environment;
    }
}
