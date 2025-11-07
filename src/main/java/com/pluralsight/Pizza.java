package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
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
}
