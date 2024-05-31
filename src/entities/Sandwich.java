package entities;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread;
    private double price;
    private double size;
    private boolean toasted;
    private List<Toppings> toppings;
    private List<Sauces> sauces;

    public Sandwich(String bread, double price, double size) {
        this.bread = bread;
        this.price = price;
        this.size = size;
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();

    }

    public Sandwich() {
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void addTopping(Toppings topping) {
        this.toppings.add(topping);
    }

    public List<Sauces> getSauces() {
        return sauces;
    }

    public void addSauce(Sauces sauce) {
        this.sauces.add(sauce);
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", toasted=" + toasted +
                ", toppings=" + toppings +
                ", sauces=" + sauces +
                '}';
    }
}
