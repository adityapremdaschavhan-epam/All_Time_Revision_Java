package DesignPattern.Creational.Factory.NotificationSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

//public class NotificationFactory {
//    public static Notification getNotification(String type){
//
//        if (type.equalsIgnoreCase("EMAIL")) {
//            return new Email();
//        } else if (type.equalsIgnoreCase("SMS")) {
//            return new Sms();
//        } else if (type.equalsIgnoreCase("PUSH")) {
//            return new PushNotification();
//        }
//        throw new IllegalArgumentException("enter valid notification type");
////        return null;
//    }
//}

class NotificationFactory {

    private static final Map<String, Supplier<Notification>> registry = new HashMap<>();

    // Static block: register creators
    static {
        registry.put("EMAIL", Email::new);
        registry.put("SMS", Sms::new);
        registry.put("PUSH", PushNotification::new);
    }

    public static Notification getNotification(String type) {

        Supplier<Notification> supplier = registry.get(type.toUpperCase());

        if (supplier == null) {
            throw new IllegalArgumentException("Invalid notification type");
        }

        return supplier.get();
    }
}
