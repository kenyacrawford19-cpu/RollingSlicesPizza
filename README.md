# 🍕 Rolling Slices Point of Sale System

A console-based Java application for managing custom pizza orders at Rolling SLices.  
Customers can create fully customized pizzas, add drinks and cheese sticks, and receive a detailed receipt — all within a simple interactive menu.

## 🧩 Features

### 🏠 Home Screen
- `1) New Order` — start a new order.
- `0) Exit` — exit the application.

### 🧾 Order Screen
The user can build their order interactively:
- `1) Add Pizza` — choose pizza size, crust, toppings (regular & premium), and stuffed crust.
- `2) Add Drink` — select drink size and flavor.
- `3) Add Cheese sticks — adds cheese sticks to the order.
- `4) Checkout` — review the order summary, confirm, and save a receipt.
- `0) Cancel Order` — discard the current order and return to the home screen.

### 🧀 Pizza Customization
- **Sizes:** Personal (8"), Medium (12"), Large (16")
- **Crusts:** Thin, Regular, Thick, or Cauliflower
- **Toppings:**
  - Regular: Onion, Mushroom, Olive, Pineapples
  - Premium: Pepperoni, Sausage, Bacon, Extra Cheese
- **Stuffed crust** option (+$2)

### 🥤 Drinks
- **Sizes:** Small, Medium, Large
- **Flavors:** Lemonade, Cheerwine, Cola, Sprite

### 🧄 Garlic Knots
- Adds a side of cheese stickes (+$5 each)

### 💾 Receipts
- Each completed order is saved in the `receipts` folder.
- Filenames are automatically generated using the order date and time:
