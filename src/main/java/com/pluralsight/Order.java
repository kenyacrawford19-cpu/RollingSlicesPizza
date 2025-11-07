package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Pizza> pizzas = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private int chesseSticks = 0;

    public void addPizza(Pizza p) {pizzas.add(p); }
    public void addDrink(Drink d) {drinks.add(d); }
    public void addcheeseSticks() {chesseSticks++; }

    public void displayNewestFirst() {
        for (int i = pizzas.size() - 1; i >=0; i--)
            System.out.println("Pizza: " + pizzas.get(i));
        for (int i = drinks.size() - 1; i >=0; i--)
            System.out.println("Drink: " + drinks.get(i));
        if (chesseSticks > 0 ) System.out.println("Cheese Sticks: " + chesseSticks);
    }
    public double getTotal() {
        double total = 0;
        for (Pizza p : pizzas) total += p.getCost();
        for (Drink d : drinks) total += d.getCost();
        total += chesseSticks * 5.00;
        return total;
        }
    }

