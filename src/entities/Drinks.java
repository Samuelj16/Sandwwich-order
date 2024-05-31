package entities;

public class Drinks {
    private String size;
    private double price;
    private String drinkType;

    public Drinks() {
    }

    public Drinks(String size, double price) {
        this.size = size;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "size=" + size +
                ", price=" + price +
                '}';
    }


}
