package com.pluralsight;

public class Drinks {
    public enum Size {Small, Medium, Large}

    private Size size;
    private String flavor;

    public Drinks(Size size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }
    public double getCost() {
        return switch (size) {
            case Size.Small -> 1.50;
            case Size.Medium -> 2.00;
            case Size.Large -> 2.50;
            default -> 0.00;
        };
    }

    @Override
    public String toString() {
        return size + " " + flavor;
    }
}
