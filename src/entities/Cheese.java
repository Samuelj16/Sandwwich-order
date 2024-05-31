package entities;

public class Cheese extends Toppings {
    private boolean cheeseExtra;

    // Constructor to initialize Cheese object with specified properties
    public Cheese(String topping, double price, int size, boolean cheeseExtra) {
        super(topping, price, size);
        this.cheeseExtra = cheeseExtra;
    }

    // Default constructor
    public Cheese() {

    }

    // Getter method for cheeseExtra property
    public boolean getCheeseExtra() {
        return cheeseExtra;
    }

    // Setter method for cheeseExtra property
    public void setCheeseExtra(boolean cheeseExtra) {
        this.cheeseExtra = cheeseExtra;
    }

    // Override toString method to provide custom string representation of Cheese object
    @Override
    public String toString() {
        return "Cheese{" +
                "cheeseExtra=" + cheeseExtra +
                '}';
    }
}
