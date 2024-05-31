package view;

import entities.*;
import services.OrderService;
import services.OrderServiceImpl;
import services.ReceiptService;

import java.util.Scanner;

public class MainView {

    private OrderService orderService = new OrderServiceImpl();

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display main menu options
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter Option: ");
            int userOption = scanner.nextInt();

            // Handle user input for main menu
            if (userOption == 1) {
                sandWichMenu(); // Navigate to sandwich menu
            } else if (userOption == 0) {
                System.exit(1); // Exit the application
            } else {
                System.out.println("You've entered the wrong option");
            }
        }
    }

    public void sandWichMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display sandwich menu options
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order - delete the order and go back to the home page");
            int choice = scanner.nextInt();

            // Handle user input for sandwich menu
            switch (choice) {
                case 1:
                    orderService.addSandwich(createSandwich(scanner)); // Add sandwich to order
                    break;
                case 2:
                    orderService.addDrinks(createDrink(scanner)); // Add drink to order
                    break;
                case 3:
                    orderService.addChips(createChips(scanner)); // Add chips to order
                    break;
                case 4:
                    // Display current order and total
                    System.out.println(orderService.toString());
                    System.out.println("Total: $" + orderService.calculateTotal());
                    System.out.println("1) Confirm");
                    System.out.println("2) Cancel");
                    int confirm = scanner.nextInt();
                    if (confirm == 1) {
                        ReceiptService.generateReceipt(orderService); // Generate receipt
                        running = false;
                    } else {
                        orderService = new OrderServiceImpl(); // Reset order service
                    }
                    break;
                case 0:
                    running = false; // Exit sandwich menu
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private Sandwich createSandwich(Scanner scanner) {
        Sandwich sandwich = new Sandwich();

        // Select bread type
        System.out.println("Select your bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        int breadChoice = scanner.nextInt();
        switch (breadChoice) {
            case 1:
                sandwich.setBread("White");
                break;
            case 2:
                sandwich.setBread("Wheat");
                break;
            case 3:
                sandwich.setBread("Rye");
                break;
            case 4:
                sandwich.setBread("Wrap");
                break;
            default:
                System.out.println("Invalid bread, defaulting to White.");
                sandwich.setBread("White");
        }

        // Select sandwich size
        System.out.println("Sandwich size:");
        System.out.println("1) 4\"");
        System.out.println("2) 8\"");
        System.out.println("3) 12\"");
        int sizeChoice = scanner.nextInt();
        switch (sizeChoice) {
            case 1:
                sandwich.setSize(4);
                sandwich.setPrice(5.00);
                break;
            case 2:
                sandwich.setSize(8);
                sandwich.setPrice(7.50);
                break;
            case 3:
                sandwich.setSize(12);
                sandwich.setPrice(10.00);
                break;
            default:
                System.out.println("Invalid choice, defaulting to 4\".");
                sandwich.setSize(4);
                sandwich.setPrice(5.00);
        }

        // Choose whether the sandwich should be toasted
        System.out.println("Would you like the sandwich toasted? (1) Yes (2) No");
        int toastedChoice = scanner.nextInt();
        sandwich.setToasted(toastedChoice == 1);

        // Add toppings and sauces
        addToppings(scanner, sandwich);
        addSauces(scanner, sandwich);

        return sandwich;
    }

    private void addToppings(Scanner scanner, Sandwich sandwich) {
        System.out.println("Add Toppings:");

        boolean addingToppings = true;
        while (addingToppings) {
            // Display topping options
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Other toppings");
            System.out.println("0) Done");
            int toppingChoice = scanner.nextInt();

            switch (toppingChoice) {
                case 1:
                    // Add meat topping
                    Meat meat = new Meat();
                    System.out.println("Meats\n" +
                            "- steak\n" +
                            "- ham\n" +
                            "- salami\n" +
                            "- roast beef\n" +
                            "- chicken\n" +
                            "- bacon");
                    System.out.println("Enter meat type:");
                    String meatType = scanner.next();
                    meat.setTopping(meatType);

                    System.out.println("1) 4\"");
                    System.out.println("2) 8\"");
                    System.out.println("3) 12\"");
                    System.out.println("Enter meat size:");
                    int meatSize = scanner.nextInt();
                    if(meatSize == 1){
                        meat.setPrice(1.0);
                    } else if (meatSize == 2) {
                        meat.setPrice(2.0);
                    } else if (meatSize == 3) {
                        meat.setPrice(3.0);
                    } else {
                        System.out.println("You've selected the wrong meat size. Setting the meat size to default");
                        meat.setPrice(1.0);
                    }

                    // Ask for extra meat
                    System.out.println("Do you want extra meat? Enter Yes or No");
                    String meatExtra = scanner.next();
                    if (meatExtra.equalsIgnoreCase("Yes")){
                        meat.setMeatExtra(true);
                        if(meatSize == 1){
                            meat.setPrice(meat.getPrice() + 0.50);
                        } else if (meatSize == 2) {
                            meat.setPrice(meat.getPrice() + 1.00);
                        } else if (meatSize == 3) {
                            meat.setPrice(meat.getPrice() + 1.50);
                        }
                    }
                    sandwich.addTopping(meat);
                    break;
                case 2:
                    // Add cheese topping
                    Cheese cheese = new Cheese();
                    System.out.println("Cheese\n" +
                            "- American\n" +
                            "- Provolone\n" +
                            "- Cheddar\n" +
                            "- Swiss");
                    System.out.println("Enter cheese type:");
                    String cheeseType = scanner.next();
                    cheese.setTopping(cheeseType);

                    System.out.println("1) 4\"");
                    System.out.println("2) 8\"");
                    System.out.println("3) 12\"");
                    System.out.println("Enter cheese size:");
                    int cheeseSize = scanner.nextInt();

                    if(cheeseSize == 1){
                        cheese.setPrice(0.75);
                    } else if (cheeseSize == 2) {
                        cheese.setPrice(1.50);
                    } else if (cheeseSize == 3) {
                        cheese.setPrice(2.25);
                    } else {
                        System.out.println("You've selected the wrong cheese size. Setting the cheese size to default");
                        cheese.setPrice(0.75);
                    }

                    // Ask for extra cheese
                    System.out.println("Do you want extra cheese? Enter Yes or No");
                    String cheeseExtra = scanner.next();
                    if (cheeseExtra.equalsIgnoreCase("Yes")){
                        cheese.setCheeseExtra(true);
                        if(cheeseSize == 1){
                            cheese.setPrice(cheese.getPrice() + 0.30);
                        } else if (cheeseSize == 2) {
                            cheese.setPrice(cheese.getPrice() + 0.60);
                        } else if (cheeseSize == 3) {
                            cheese.setPrice(cheese.getPrice() + 0.90);
                        }
                    }
                    sandwich.addTopping(cheese);
                    break;
                case 3:
                    // Add regular toppings
                    System.out.println("Regular Toppings\n" +
                            "- lettuce\n" +
                            "- peppers\n" +
                            "- onions\n" +
                            "- tomatoes\n" +
                            "- jalapenos\n" +
                            "- cucumbers\n" +
                            "- pickles\n" +
                            "- guacamole\n" +
                            "- mushrooms");

                    System.out.println("Enter topping type:");
                    String toppingType = scanner.next();

                    sandwich.addTopping(new Toppings(toppingType, 0.0, 0));
                    break;
                case 0:
                    addingToppings = false; // Exit toppings menu
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addSauces(Scanner scanner, Sandwich sandwich) {
        System.out.println("Sauces\n" +
                "- mayo\n" +
                "- mustard\n" +
                "- ketchup\n" +
                "- ranch\n" +
                "- thousand islands\n" +
                "- vinaigrette");

        boolean addingSauces = true;
        while (addingSauces) {
            // Prompt for sauce selection
            System.out.println("Select sauces (enter 0 when done):");
            System.out.println("Enter sauce type:");
            String sauceType = scanner.next();
            if (sauceType.equals("0")) {
                addingSauces = false; // Exit sauces menu
            } else {
                sandwich.addSauce(new Sauces(sauceType)); // Add sauce to sandwich
            }
        }
    }

    private Drinks createDrink(Scanner scanner) {
        Drinks drinks = new Drinks();
        System.out.println("Enter drink size:");
        System.out.println("Drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        int sizeChoice = scanner.nextInt();
        switch (sizeChoice) {
            case 1:
                drinks.setSize("Small");
                drinks.setPrice(2.00);
                break;
            case 2:
                drinks.setSize("Medium");
                drinks.setPrice(2.50);
                break;
            case 3:
                drinks.setSize("Large");
                drinks.setPrice(3.00);
                break;
            default:
                System.out.println("Invalid choice, defaulting to Small.");
                drinks.setSize("Small");
                drinks.setPrice(5.00);
        }
        return drinks;
    }

    private Chips createChips(Scanner scanner) {
        // Create chips with default price
        Chips chips = new Chips(1.50);
        return chips;
    }
}
