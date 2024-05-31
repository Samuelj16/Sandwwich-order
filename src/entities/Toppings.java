package entities;

public class Toppings {
    private String topping;
    private double price;
    private int size;

    public Toppings(){

    }
    public Toppings(String topping, double price, int size) {
        this.topping = topping;
        this.price = price;
        this.size = size;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "topping='" + topping + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
