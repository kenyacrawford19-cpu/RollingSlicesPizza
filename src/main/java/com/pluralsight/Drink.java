package com.pluralsight;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }
    public double getCost() {
        return switch (size) {
            case Small -> 1.50;
            case Medium -> 2.00;
            case Large -> 2.50;
        };
    }
}
