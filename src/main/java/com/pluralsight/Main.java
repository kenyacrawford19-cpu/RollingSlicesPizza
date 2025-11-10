package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                    orderScreen.display();
                    break;
                case "0" :
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
