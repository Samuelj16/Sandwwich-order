package services;

import entities.Chips;
import entities.Drinks;
import entities.Sandwich;
import entities.Toppings;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService{
    private List<Sandwich> sandwiches;
    private List<Drinks> drinks;
    private List<Chips> chips;

    public OrderServiceImpl(){
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }
    @Override
    public double calculateTotal() {
        double total = 0.0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
            for (Toppings topping : sandwich.getToppings()) {
                total += topping.getPrice();
            }
        }
        for (Drinks drink : drinks) {
            total += drink.getPrice();
        }
        for (Chips chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }

    @Override
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    @Override
    public void addDrinks(Drinks drink) {
        drinks.add(drink);
    }

    @Override
    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drinks> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    @Override
    public String toString() {
        return "OrderServiceImpl{" +
                "sandwiches=" + sandwiches +
                ", drinks=" + drinks +
                ", chips=" + chips +
                '}';
    }
}
