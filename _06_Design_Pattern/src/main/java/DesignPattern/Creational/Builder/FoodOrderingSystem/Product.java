package Creational.Builder.FoodOrderingSystem;

// When an object has many optional parts, Builder helps you create it cleanly,
// safely, and readably.
// Telescoping Constructor Probl

import java.lang.module.ModuleDescriptor;

class Burger {
    // mandatory
    private final String bun;
    private final String patty;

    // optional
    private final boolean cheese;
    private final boolean lettuce;
    private final boolean tomato;
    private final boolean sauce;

    // priavete
}

public static class Builder {
    // mandatory
    private final String bun;
    private final String patty;
    // optional (default)
    private boolean cheese;
    private  boolean lettuce;
    private boolean tomato;
    private boolean sauce;

    public Builder(String bun, String patty){
        this.bun = bun;
        this.patty = patty;
    }

    public Builder addLettuce(){
        this.lettuce = true;
        return this;
    }

    public Builder addTomato(){
        this.tomato = true;
        return this;
    }

    public Builder addSauce(){
        this.tomato = true;
        return this;
    }

    public Burger build(){
        return new Burger(this);
    }

}

