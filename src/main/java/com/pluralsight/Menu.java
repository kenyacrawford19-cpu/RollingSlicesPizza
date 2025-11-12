package com.pluralsight;

import java.util.List;

public class Menu {
    public static final List<Toppings> meatToppings = List.of(
       new Toppings("Pepperoni" , true),
       new Toppings("Sausage" , true),
       new Toppings("Ham" , true),
       new Toppings("Bacon" , true)

    );

   public static final List<Toppings> cheeseToppings = List.of(
           new Toppings("Mozzarella", true),
           new Toppings("Cheddar" , true),
           new Toppings("Parmesan" , true)
   );

   public static final List<Toppings> otherToppings = List.of(
           new Toppings("Onions" , false),
           new Toppings("Mushrooms" , false),
           new Toppings("Green Pepper" , false),
           new Toppings("Spinach" , false),
           new Toppings("Pineapples" , false)
   );

   public static final List<Toppings> sauceToppings = List.of(
           new Toppings("Tomato Sauce" , false),
           new Toppings("Garlic Alfredo" , false),
           new Toppings("Pesto Sauce" , false)
   );
}
