package DesignPattern.Creational.Factory.NotificationSystem;

public class PushNotification implements Notification {
    public void send(){
        System.out.println("Sending PushNotification");
    }
}
