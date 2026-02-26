package DesignPattern.Creational.Factory.NotificationSystem;

public class Email implements Notification {
    public void send(){
        System.out.println("Sending Email");
    }
}
