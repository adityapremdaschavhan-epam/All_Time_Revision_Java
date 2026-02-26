package DesignPattern.Creational.AbstractFactory.CrossPlatformUI;

public class Main {
    public static void main(String[] args) {
/*
// **********Basic run time polymorphism***********************
* client itself is selecting factory and then ui component also

        OsFactory macfactory = new MacFactory();
        Button macButton = macfactory.createButton();
        macButton.click();

        OsFactory windowfactory = new WindowsFactory();
        CheckBox windowCheckBox = windowfactory.createCheckBox();
        windowCheckBox.check();
*/
        DesignPattern.Creational.AbstractFactory.CrossPlatformUI.OsFactory factory;

        String os = "WINDOWS"; // change to MAC

        if (os.equals("WINDOWS")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }
        Application app = new Application(factory);
        app.renderUI();

    }
}
