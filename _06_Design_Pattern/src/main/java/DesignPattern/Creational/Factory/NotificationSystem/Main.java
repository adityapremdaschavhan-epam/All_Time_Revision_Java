package DesignPattern.Creational.Factory.NotificationSystem;

public class Main {
    public static void main(String[] args) {
        Notification sms =  NotificationFactory.getNotification("email");
        sms.send();
    }
}
