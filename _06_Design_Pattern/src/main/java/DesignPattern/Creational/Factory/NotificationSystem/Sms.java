package DesignPattern.Creational.Factory.NotificationSystem;

public class Sms implements Notification {
    public void send(){
        System.out.println("Sending SMS");
    }
}
