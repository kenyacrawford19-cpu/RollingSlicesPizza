package com.pluralsight;

public class Toppings {
    private String name;
    private boolean premium;

    public Toppings(String name, boolean premium) {
        this.name = name;
        this.premium = premium;
    }
    public boolean isPremium() {return premium; }
    public String getName() {return name; }

    @Override
    public String toString() {
        return "Toppings{" +
                "name='" + name + '\'' +
                ", premium=" + premium +
                '}';
    }
}
