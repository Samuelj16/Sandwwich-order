package services;

import entities.Chips;
import entities.Drinks;
import entities.Sandwich;

public interface OrderService {
    double calculateTotal();
    void addSandwich(Sandwich sandwich);
    void addDrinks(Drinks drinks);
    void addChips(Chips chips);

}
