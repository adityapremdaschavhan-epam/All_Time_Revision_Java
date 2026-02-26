package main.java.org.collection.revision;

public class App {

    public static void main(String[] args) {

        // Read the environment value passed by Maven profile
        String env = System.getProperty("env.name");

        // Print flow start
        System.out.println("Application started...");

        // Print which environment is active
        System.out.println("Running in environment: " + env);

        // Environment-specific logic (just prints for now)
        if ("DEV".equals(env)) {
            System.out.println("Connecting to DEV resources...");
        }
        else if ("TEST".equals(env)) {
            System.out.println("Connecting to TEST resources...");
        }
        else if ("PROD".equals(env)) {
            System.out.println("Connecting to PROD resources...");
        }
        else {
            System.out.println("No environment selected!");
        }

        // Print flow end
        System.out.println("Application finished.");
    }
}