package DesignPattern.Creational.AbstractFactory.CrossPlatformUI;

public class MacFactory implements OsFactory {

    public Button createButton(){
        return new MacButton();
    }

    public CheckBox createCheckBox(){
        return new MacCheckBox();
    }
}
