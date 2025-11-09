package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    public enum Size {Personal, Medium, Large}
    public enum Crust {Thin, Regular, Thick, Cauliflower}

    private String size;
    private String crustType;
    private boolean stuffedCrust;
    private List<Toppings> toppings = new ArrayList<>();

    public Pizza(boolean stuffedCrust, String crustType, String size) {
        this.stuffedCrust = stuffedCrust;
        this.crustType = crustType;
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }
    public void addTopping(Toppings t) {
        toppings.add(t);
    }
    public double getCost(){
        double base;
        switch (size){
            case Size.Personal -> base = 8.00;
            case Medium -> base = 12.00;
            case Large -> base = 16.00;
            default -> base = 10.00;
        }
        if (stuffedCrust) base += 3.00;

        for (Toppings t : toppings) {
            base += t.isPremium() ? 2.00 :1.00;
        }
        return base;

        @Override
         public String toString() {
            return size + "pizza, " + crust + "crust" +
                    (stuffedCrust ? "(stuffed crust)" : "") +
                    ", Toppings: " + toppings;
        }
    }
}
