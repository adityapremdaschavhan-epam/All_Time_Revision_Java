package DesignPattern.Creational.AbstractFactory.CrossPlatformUI;

public class Application {
    private final  Button button;
    private final CheckBox checkbox;

    public Application(OsFactory factory){
        this.button = factory.createButton();
        this.checkbox = factory.createCheckBox();
    }

    public void renderUI(){
        button.click();
        checkbox.check();
    }

}
