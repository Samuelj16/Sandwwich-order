import entities.*;
import services.OrderService;
import services.OrderServiceImpl;
import services.ReceiptService;
import view.MainView;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Sandwich sandwich = new Sandwich();
        sandwich.setBread("Testing");
        sandwich.setSize(5);
        sandwich.setPrice(13.99);

        Meat meat =  new Meat();
        meat.setPrice(5.9);
        meat.setTopping("Meat Test");
        meat.setSize(9);

        Sauces sauces = new Sauces("Test Sauce");

        sandwich.addSauce(sauces);
        sandwich.addTopping(meat);

        Drinks drinks = new Drinks();
        drinks.setPrice(8);
        drinks.setSize(5.0);
        drinks.setDrinkType("Smoothie");

        Chips chips = new Chips(3.9);

        OrderService orderService = new OrderServiceImpl();
        orderService.addChips(chips);
        orderService.addSandwich(sandwich);
        orderService.addDrinks(drinks);

        System.out.println(orderService.calculateTotal());

        ReceiptService.generateReceipt(orderService);


         */

        MainView mainView = new MainView();
        mainView.mainMenu();

//        ReceiptService.generateReceipt(new OrderServiceImpl());

    }
}
