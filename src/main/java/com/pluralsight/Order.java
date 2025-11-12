package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Pizza> pizzas = new ArrayList<>();
    private List<Drinks> drinks = new ArrayList<>();
    private int cheeseSticks = 0;

    public void addPizza(Pizza p) {
        pizzas.add(p);
    }

    public void addDrink(Drinks d) {
        drinks.add(d);
    }

    public void addcheeseSticks() {
        cheeseSticks++;
    }

    public boolean isEmpty() {
        return pizzas.isEmpty() && drinks.isEmpty() && cheeseSticks == 0;
    }

    public double getTotal() {
        double total = 0;
        for (Pizza p : pizzas)
            total += p.getCost();
        for (Drinks d : drinks)
            total += d.getCost();
        total += cheeseSticks * 5.00;
        return total;
    }

    public String getReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your Order:\n");
        for (Pizza p : pizzas) sb.append(p).append("\n");
        for (Drinks d : drinks) sb.append(d).append("\n");
        if (cheeseSticks > 0) sb.append("Cheese sticks: ").append(cheeseSticks).append("\n");
        sb.append("Total: $").append(String.format("%.2f", getTotal()));
        return sb.toString();

    }

        public void displayNewestFirst(){
            for (int i = pizzas.size() -1; 1 >= 0; i--){
                System.out.println("Pizza: "+ pizzas.get(i));
            for (i = drinks.size() - 1; i >= 0; i--)
                System.out.println("Drink: " + drinks.get(i));
            if (cheeseSticks > 0) System.out.println("Cheese Sticks: " + cheeseSticks);
            }


        }
    }

