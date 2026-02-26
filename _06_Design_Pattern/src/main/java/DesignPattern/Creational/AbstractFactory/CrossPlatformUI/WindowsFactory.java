package DesignPattern.Creational.AbstractFactory.CrossPlatformUI;

public class WindowsFactory  implements  OsFactory{
    public Button createButton(){
        return new WindowButton();
    }

    public CheckBox createCheckBox(){
        return new WindowCheckBox();
    }
}
