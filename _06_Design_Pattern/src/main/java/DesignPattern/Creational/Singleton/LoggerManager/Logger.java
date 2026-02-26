package DesignPattern.Creational.Singleton.LoggerManager;

public class Logger {

    // instance
    private static Logger instance;

    // Private constructor to stop the instantiation of objects
    private Logger(){}

    public Logger getInstance(){
        if(instance == null){
            return new Logger();
        }
        return instance;
    }
}
