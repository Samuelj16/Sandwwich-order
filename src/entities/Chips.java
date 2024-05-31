package entities;

public class Chips {
    private double price;

    // Constructor to initialize Chips object with specified price
    public Chips(double price) {
        this.price = price;
    }

    // Default constructor
    public Chips() {
    }

    // Getter method for price property
    public double getPrice() {
        return price;
    }

    // Setter method for price property
    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString method to provide custom string representation of Chips object
    @Override
    public String toString() {
        return "Chips{" +
                "price=" + price +
                '}';
    }
}
