package DesignPattern.Creational.Singleton.Application_Setting_Manager;

public class Main {
    public static void main(String[] args) {

        /* see me....>>>>>>>>>>>>>>>>>...........>>>>>>>>
        * so first there are two users
        * each using multiple functionality module ->login, dashboard,reports
        * 1) we want every user to use same instance of settings
        * 2) we want each functionality to use same instance
        * */

        System.out.println("hi there i am first user");
        LoginModule login1 = new LoginModule();
        DashboardModule dashboard1 = new DashboardModule();
        ReportsModule reports1 = new ReportsModule();

        login1.displaySettings();
        dashboard1.displaySettings();
        reports1.displaySettings();

        System.out.println("hi there i am second user");

        LoginModule login2 = new LoginModule();
        DashboardModule dashboard2 = new DashboardModule();
        ReportsModule reports2 = new ReportsModule();

        login2.displaySettings();
        dashboard2.displaySettings();
        reports2.displaySettings();


    }
}
