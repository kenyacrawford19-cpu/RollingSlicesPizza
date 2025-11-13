package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface{

    public void HomeScreen(){
        OrderScreen orderScreen = new OrderScreen(){};
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("============");
            System.out.println("Welcome to Rolling Slices Pizza");
            System.out.println("============");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Enter choice: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1" :
                    startNewOrder(scanner);
                    break;
                case "0" :
                    System.out.println("Thank you! Goodbye");
                    running = false;
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void startNewOrder(Scanner scanner){
        Order order = new Order();
        boolean ordering = true;

        while (ordering){
            System.out.println("======================");
            System.out.println("      Order Screen    ");
            System.out.println("======================");
            System.out.println("Current order: ");
            order.displayNewestFirst();
            System.out.println("-----------------------");

            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Cheese Sticks");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Pizza p = buildPizza(scanner);
                    order.addPizza(p);
                    break;
                case "2":
                    addDrink(scanner,order);
                    break;
                case"3":
                    order.addcheeseSticks();
                    System.out.println("Cheese sticks added! ");
                    break;
                case"4":
                    checkout(scanner, order);
                    ordering =false;
                    break;
                default:
                    System.out.println("Invalid selection. Try again. ");
            }
        }

    }

    public static Pizza buildPizza(Scanner scanner){
        Order order = new Order();

        System.out.println("Select Crust Type: ");
        System.out.println("1) Thin");
        System.out.println("2) Regular");
        System.out.println("3) Thick");
        System.out.println("4) Cauliflower");
        System.out.println("Choice");

        Pizza.Crust crust = switch (scanner.nextLine()){
            case "1" -> Pizza.Crust.Thin;
            case "2" -> Pizza.Crust.Regular;
            case "3" -> Pizza.Crust.Thick;
            case "4" -> Pizza.Crust.Cauliflower;
            default -> Pizza.Crust.Regular;

        };

        System.out.println("Select Pizza Size:");
        System.out.println("1) Personal (8\")");
        System.out.println("2) Medium (12\")");
        System.out.println("3) Large (16\")");
        System.out.println("Choice: ");

        Pizza.Size size = switch(scanner.nextLine()){
            case "1" -> Pizza.Size.Personal;
            case "2" -> Pizza.Size.Medium;
            case "3" -> Pizza.Size.Large;
            default -> Pizza.Size.Medium;
        };

        Pizza pizza = new Pizza(false, crust, size);

        addToppingsFromCategory(scanner, pizza, "Meat Toppings", Menu.meatToppings);
        addToppingsFromCategory(scanner, pizza, "Chesese", Menu.cheeseToppings);
        addToppingsFromCategory(scanner, pizza, "Other Toppings" , Menu.otherToppings);
        addToppingsFromCategory(scanner, pizza, "Sauces", Menu.sauceToppings);


        System.out.println("Would you like stuffed crust? (Y/N): ");
        String stuffed = scanner.nextLine().trim().toUpperCase();
        if (stuffed.equals("Y")){
            pizza.setStuffedCrust(true);
        }
        order.addPizza(pizza);

        return pizza;
    }

    private static void addToppingsFromCategory(Scanner scanner, Pizza pizza, String toppings, List<Toppings> category_Toppings) {
        System.out.println("Add " + toppings + ":");

        boolean adding = true;

        while (adding){
            for (int i = 0; i < category_Toppings.size(); i++){
                System.out.println((i + 1)+ ")" + category_Toppings.get(i));
            }
            System.out.println("0) Done");
            System.out.println("Choice: ");

            String input = scanner.nextLine();
            if (input.equals("0")) break;
            try {
                int index = Integer.parseInt(input)-1;
                if (index >= 0 && index < category_Toppings.size()) {
                    pizza.addTopping(category_Toppings.get(index));
                    System.out.println(category_Toppings.get(index).getName() + "added!");
                }
            }catch (Exception ignored){}
        }
    }

    private static void addDrink (Scanner scanner, Order order){
        System.out.println("Select Drink Size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        Drinks.Size size = switch (scanner.nextLine()) {
            case "1" -> Drinks.Size.Small;
            case "2" -> Drinks.Size.Medium;
            case "3" -> Drinks.Size.Large;
            default -> Drinks.Size.Medium;
        };
        System.out.println("Select Flavor:");
        System.out.println("1) Lemonade");
        System.out.println("2) Cheerwine");
        System.out.println("3) Cola");
        System.out.println("4) Sprite");
        String flavor = switch (scanner.nextLine()) {
            case "1" -> "Lemonade";
            case "2" -> "Cheerwine";
            case "3" -> "Cola";
            case "4" -> "Sprite";
            default -> "Lemonade";
        };
        order.addDrink(new Drinks(size, flavor));
        System.out.println("Drink added!");
    }

private static void checkout(Scanner scanner, Order order){
    System.out.println("=====================================");
    System.out.println(order.getReceiptText());
    System.out.println("=====================================");

    System.out.println("Confirm?");
    System.out.println("1) Confirm & Save");
    System.out.println("0) Cancel");
    System.out.println("Choice: ");
    String c = scanner.nextLine();

    if (c.equals("1")){
        try {
            Receipt.saveReceipt(order);
            //change to IO later
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Receipt saved.");
    }else {
        System.out.println("Order cancelled.");
    }
}







}