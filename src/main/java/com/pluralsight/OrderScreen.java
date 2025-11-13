package com.pluralsight;

import java.util.Scanner;

public class OrderScreen {
    Order order = new Order();
    boolean ordering = true;
    Scanner scanner = new Scanner(System.in);

    public static void displayMenu (Scanner scanner) {
        System.out.println("Starting new order");
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("==============================");
            System.out.println("     Starting new order");
            System.out.println("==============================");

            System.out.println("Current Order");
            if (order.isEmpty()) {
                System.out.println("  (no items yet)");
            }else {
                order.displayNewestFirst();
            }
            System.out.println("-------------------------------");

            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Cheese Sticks");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("Enter choice: ");


            String choice = scanner.nextLine();

            switch (choice) {
                case "1" :
                    UserInterface.buildPizza(scanner);
//                    order.addPizza(p);
                    System.out.println("Pizza added!");
                    break;

                case "2":
                    addDrink(scanner, order);
                    break;

                case "3":
                    order.addcheeseSticks();
                    System.out.println("Cheese sticks added");
                    break;

                case "4":
                    checkout(scanner, order);
                    ordering = false;
                    break;

                case "0":
                    System.out.println("Order successfully cancelled. Returning to Home.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid selection. Try again.");

            }

            System.out.println();

        }
    }

    private static void checkout(Scanner scanner,Order order) {
        System.out.println("===========================");
        System.out.println("     Order Summary");
        System.out.println("============================");
        System.out.println(order.getReceiptText());
        System.out.println("-----------------------------");
        System.out.println("Saving receipt");

        if (order.isEmpty()) {
            System.out.println("Cannot checkout an empty order. ");
            return;
        }

        System.out.println("Confirm order?");
        System.out.println("1) Confirm & Save");
        System.out.println("0) Cancel Order");
        System.out.println("Choice: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            try {
                Receipt.saveReceipt(order);
                System.out.println("Receipt saved!");
            } catch (Exception e) {
                System.out.println("Error saving receipt.");
            }
        } else {
            System.out.println("Order cancelled.");
        }
    }

    private static void addDrink(Scanner scanner, Order order){
            System.out.println(" Select drink size:");
            System.out.println("1) Small: ");
            System.out.println("2) Medium: ");
            System.out.println("3) Large: ");
            System.out.println("Choice: ");
            Drinks.Size size = switch (scanner.nextLine()){
                case "1" -> Drinks.Size.Small;
                case "2" -> Drinks.Size.Medium;
                case "3" -> Drinks.Size.Large;
                default -> Drinks.Size.Medium;
            };

            System.out.println("Select Drink Flavor: ");
            System.out.println("1) Lemonade");
            System.out.println("2) Cheerwine");
            System.out.println("3) Cola");
            System.out.println("4) Sprite");
            System.out.println("Choice: ");
            String flavor = switch (scanner.nextLine()){
                case "1" -> "Lemonade";
                case "2" -> "Cheerwine";
                case "3" -> "Cola";
                case "4" -> "Sprite";
                default -> "Lemonade";
            };
            order.addDrink(new Drinks(size, flavor));
            System.out.println("Drink added!");
        }

    }
